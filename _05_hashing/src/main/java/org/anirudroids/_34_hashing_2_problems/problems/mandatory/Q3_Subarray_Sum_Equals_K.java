package org.anirudroids._34_hashing_2_problems.problems.mandatory;

import java.util.HashMap;
import java.util.Map;

public class Q3_Subarray_Sum_Equals_K {
    /**
     * Problem Description
     * Given an array of integers A and an integer B.
     * Find the total number of subarrays having sum equals to B.
     *
     *
     * Problem Constraints
     *  1 <= length of the array <= 50000
     * -1000 <= A[i] <= 1000
     *
     *
     * Input Format
     * The first argument given is the integer array A.
     * The second argument given is integer B.
     *
     *
     * Output Format
     * Return the total number of subarrays having sum equals to B.
     *
     *
     * Example Input
     * Input 1:
     * A = [1, 0, 1]
     * B = 1
     * Input 2:
     * A = [0, 0, 0]
     * B = 0
     *
     *
     * Example Output
     * Output 1:
     * 4
     * Output 2:
     * 6
     *
     *
     * Example Explanation
     * Explanation 1:
     * [1], [1, 0], [0, 1] and [1] are four subarrays having sum 1.
     * Explanation 1:
     * All the possible subarrays having sum 0.
     */

    public int solve(int[] A, int B) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        frequencyMap.put(0, 1);
        for (int j : A) {
            sum += j;
            int target = sum - B;

            if (frequencyMap.containsKey(target)) {
                count += frequencyMap.get(target);
            }
            if (frequencyMap.containsKey(sum)) {
                frequencyMap.put(sum, frequencyMap.get(sum) + 1);
            } else {
                frequencyMap.put(sum, 1);
            }
        }

        return count;
    }
}
