package org.anirudroids._34_hashing_2_problems.problems.mandatory;

import java.util.HashMap;

public class Q2_Count_Pair_Difference {
    /**
     * Problem Description
     * You are given an array A of N integers and an integer B.
     * Count the number of pairs (i,j) such that A[i] - A[j] = B and i ≠ j.
     *
     * Since the answer can be very large, return the remainder after dividing the count with 109+7.
     *
     *
     * Problem Constraints
     * 1 <= N <= 105
     * 1 <= A[i] <= 109
     * 1 <= B <= 109
     *
     *
     * Input Format
     * First argument A is an array of integers and second argument B is an integer.
     *
     *
     * Output Format
     * Return an integer.
     *
     *
     * Example Input
     * Input 1:
     *
     * A = [3, 5, 1, 2]
     * B = 4
     * Input 2:
     *
     * A = [1, 2, 1, 2]
     * B = 1
     *
     *
     * Example Output
     * Output 1:
     *
     * 1
     * Output 2:
     *
     * 4
     *
     *
     * Example Explanation
     * Example 1:
     *
     * The only pair is (2, 3) which gives difference as 4
     * Example 2:
     *
     * The pair which gives difference as 3 are (2, 1), (4, 1), (2, 3) and (4, 3).
     */

    public int solve(int[] A, int B) {
        int n = A.length;
        long mod = (long)(Math.pow(10, 9)) + 7;
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        long count = 0;
        for(int i = n-1; i >= 0; i--) {
            if(frequencyMap.containsKey(A[i] - B)) {
                count += frequencyMap.get(A[i] - B) % mod;
            }
            if(frequencyMap.containsKey(A[i] + B)) {
                count += frequencyMap.get(A[i] + B) % mod;
            }

            frequencyMap.put(A[i], frequencyMap.containsKey(A[i]) ? (int)(frequencyMap.get(A[i])%mod) + 1 : 1);
        }

        return (int)(count%mod);
    }
}
