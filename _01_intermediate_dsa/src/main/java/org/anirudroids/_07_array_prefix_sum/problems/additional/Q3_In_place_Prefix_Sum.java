package org.anirudroids._07_array_prefix_sum.problems.additional;

public class Q3_In_place_Prefix_Sum {
    /**
     * Problem Description
     * Given an array A of N integers. Construct prefix sum of the array in the given array itself.
     *
     *
     * Problem Constraints
     * 1 <= N <= 105
     * 1 <= A[i] <= 103
     *
     *
     * Input Format
     * Only argument A is an array of integers.
     *
     *
     * Output Format
     * Return an array of integers denoting the prefix sum of the given array.
     *
     *
     * Example Input
     * Input 1:
     *
     * A = [1, 2, 3, 4, 5]
     * Input 2:
     *
     * A = [4, 3, 2]
     *
     *
     * Example Output
     * Output 1:
     *
     * [1, 3, 6, 10, 15]
     * Output 2:
     *
     * [4, 7, 9]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     * The prefix sum array of [1, 2, 3, 4, 5] is [1, 3, 6, 10, 15].
     * Explanation 2:
     *
     * The prefix sum array of [4, 3, 2] is [4, 7, 9].
     */

    public int[] solve(int[] A) {
        int n = A.length;
        int[] prefixSum = new int[n];

        prefixSum[0] = A[0];
        for(int index = 1; index < n; index++) {
            prefixSum[index] = prefixSum[index - 1] + A[index];
        }

        return prefixSum;
    }
}
