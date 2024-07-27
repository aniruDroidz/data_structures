package org.anirudroids._60_internal_implementation_problems.problems.mandatory;

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
        long sum = 0;
        int ans = 0;
        Map<Long, Integer> map = new HashMap<>();

        for (int index = 0; index < A.length; index++) {
            sum = sum + A[index];

            if (sum == 0) {
                ans = Math.max(ans, index + 1);
            } else if (map.containsKey(sum)) {
                int indexFromMap = map.get(sum);

                int difference = Math.abs(indexFromMap - index);

                if (difference > ans) {
                    ans = difference;
                }
            } else {
                map.put(sum, index);
            }
        }

        return ans;
    }

}
