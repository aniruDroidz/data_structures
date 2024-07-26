package org.anirudroids._13_hashing_basics.problems.additional;

import java.util.HashMap;

public class Q1_Count_Subarray_Zero_Sum {
    /**
     * Problem Description
     * Given an array A of N integers.
     *
     * Find the count of the subarrays in the array which sums to zero. Since the answer can be very large, return the remainder on dividing the result with 109+7
     *
     *
     * Problem Constraints
     * 1 <= N <= 105
     * -109 <= A[i] <= 109
     *
     *
     * Input Format
     * Single argument which is an integer array A.
     *
     *
     * Output Format
     * Return an integer.
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [1, -1, -2, 2]
     * Input 2:
     *
     *  A = [-1, 2, -1]
     *
     *
     * Example Output
     * Output 1:
     *
     * 3
     * Output 2:
     *
     * 1
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  The subarrays with zero sum are [1, -1], [-2, 2] and [1, -1, -2, 2].
     * Explanation 2:
     *
     *  The subarray with zero sum is [-1, 2, -1].
     */

    public int solve(int[] A) {
        int[] prefixSum = new int[A.length];
        prefixSum[0] = A[0];

        int count = 0;
        if(prefixSum[0] == 0) {
            count++;
        }
        for(int index = 1; index < A.length; index++) {
            prefixSum[index] = prefixSum[index - 1] + A[index];
            if(prefixSum[index] == 0) {
                count++;
            }
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : prefixSum) {
            if (hashMap.containsKey(i)) {
                count = count + hashMap.get(i);
                hashMap.put(i, hashMap.get(i) + 1);
            } else {
                hashMap.put(i, 1);
            }
        }

        return count;
    }
}
