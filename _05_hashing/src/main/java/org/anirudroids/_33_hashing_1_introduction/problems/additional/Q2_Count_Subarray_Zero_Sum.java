package org.anirudroids._33_hashing_1_introduction.problems.additional;

public class Q2_Count_Subarray_Zero_Sum {
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
        int n = A.length;

        int count = 0;
        for(int i = 0; i < n; i++) {
            int sum = A[i];
            if(sum == 0) {
                count++;
            }
            for(int j = i + 1; j < n; j++) {
                sum += A[j];
                if(sum == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
