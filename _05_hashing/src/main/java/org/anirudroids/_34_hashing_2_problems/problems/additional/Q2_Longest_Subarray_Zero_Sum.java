package org.anirudroids._34_hashing_2_problems.problems.additional;

import java.util.HashMap;
import java.util.Map;

public class Q2_Longest_Subarray_Zero_Sum {
    /**
     * Problem Description
     * Given an array A of N integers.
     * Find the length of the longest subarray in the array which sums to zero.
     *
     * If there is no subarray which sums to zero then return 0.
     *
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
     *  A = [1, -2, 1, 2]
     * Input 2:
     *
     *  A = [3, 2, -1]
     *
     *
     * Example Output
     * Output 1:
     *
     * 3
     * Output 2:
     *
     * 0
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  [1, -2, 1] is the largest subarray which sums up to 0.
     * Explanation 2:
     *
     *  No subarray sums up to 0.
     */

    public int solve(int[] A) {
        int n = A.length;
        int maxLen = 0;
        Map<Long, Integer> map = new HashMap<>();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i];
            if (sum == 0) {
                maxLen = i + 1;
            } else if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxLen;
    }
}
