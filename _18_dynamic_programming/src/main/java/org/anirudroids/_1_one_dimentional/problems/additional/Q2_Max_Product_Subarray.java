package org.anirudroids._1_one_dimentional.problems.additional;

public class Q2_Max_Product_Subarray {
    /**
     * Problem Description
     * Given an integer array A of size N. Find the contiguous subarray within the given array (containing at least one number) which has the largest product.
     *
     * Return an integer corresponding to the maximum product possible.
     *
     * NOTE: Answer will fit in 32-bit integer value.
     *
     *
     *
     * Problem Constraints
     * 1 <= N <= 5 * 105
     *
     * -100 <= A[i] <= 100
     *
     *
     *
     * Input Format
     * First and only argument is an integer array A.
     *
     *
     *
     * Output Format
     * Return an integer corresponding to the maximum product possible.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [4, 2, -5, 1]
     * Input 2:
     *
     *  A = [-3, 0, -5, 0]
     *
     *
     * Example Output
     * Output 1:
     *
     *  8
     * Output 2:
     *
     *  0
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  We can choose the subarray [4, 2] such that the maximum product is 8.
     * Explanation 2:
     *
     *  0 will be the maximum product possible.
     */

    public int maxProduct(final int[] A) {
        if(A.length == 1) {
            return A[0];
        }

        int[] dp1 = new int[A.length];
        int[] dp2 = new int[A.length];

        dp1[0] = A[0];
        dp2[0] = A[0];

        int result = Integer.MIN_VALUE;
        for(int index = 1; index < A.length; index++) {
            dp1[index] = Math.min(A[index], Math.min(A[index]*dp1[index-1], A[index]*dp2[index-1]));
            dp2[index] = Math.max(A[index], Math.max(A[index]*dp1[index-1], A[index]*dp2[index-1]));

            result = Math.max(result, dp2[index]);
        }

        return result;
    }
}
