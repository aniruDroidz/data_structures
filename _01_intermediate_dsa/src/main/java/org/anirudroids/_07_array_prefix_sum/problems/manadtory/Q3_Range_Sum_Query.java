package org.anirudroids._07_array_prefix_sum.problems.manadtory;

public class Q3_Range_Sum_Query {
    /**
     * Problem Description
     * You are given an integer array A of length N.
     * You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
     * For each query, you have to find the sum of all elements from L to R indices in A (0 - indexed).
     * More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.
     *
     *
     *
     * Problem Constraints
     * 1 <= N, M <= 105
     * 1 <= A[i] <= 109
     * 0 <= L <= R < N
     *
     *
     * Input Format
     * The first argument is the integer array A.
     * The second argument is the 2D integer array B.
     *
     *
     * Output Format
     * Return an integer array of length M where ith element is the answer for ith query in B.
     *
     *
     * Example Input
     * Input 1:
     * A = [1, 2, 3, 4, 5]
     * B = [[0, 3], [1, 2]]
     * Input 2:
     *
     * A = [2, 2, 2]
     * B = [[0, 0], [1, 2]]
     *
     *
     * Example Output
     * Output 1:
     * [10, 5]
     * Output 2:
     *
     * [2, 4]
     *
     *
     * Example Explanation
     * Explanation 1:
     * The sum of all elements of A[0 ... 3] = 1 + 2 + 3 + 4 = 10.
     * The sum of all elements of A[1 ... 2] = 2 + 3 = 5.
     * Explanation 2:
     *
     * The sum of all elements of A[0 ... 0] = 2 = 2.
     * The sum of all elements of A[1 ... 2] = 2 + 2 = 4.
     */

    public long[] rangeSum(int[] A, int[][] B) {

        long[] result = new long[B.length];


        long[] prefixSum = new long[A.length];
        prefixSum[0] = A[0];
        for(int index = 1; index < A.length; index++) {
            prefixSum[index] = prefixSum[index - 1] + A[index];
        }

        for(int index = 0; index < B.length; index++) {
            int[] range = B[index];
            int l = range[0];
            int r = range[1];

            if(l == 0) {
                result[index] = prefixSum[r];
            } else {
                result[index] = prefixSum[r] - prefixSum[l - 1];
            }
        }

        return result;
    }
}
