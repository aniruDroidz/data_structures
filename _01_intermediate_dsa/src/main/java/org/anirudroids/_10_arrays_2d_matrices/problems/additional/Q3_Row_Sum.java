package org.anirudroids._10_arrays_2d_matrices.problems.additional;

public class Q3_Row_Sum {
    /**
     * Problem Constraints
     * 1 <= A.size() <= 103
     *
     * 1 <= A[i].size() <= 103
     *
     * 1 <= A[i][j] <= 103
     *
     *
     *
     * Input Format
     * First argument A is a 2D array of integers.(2D matrix).
     *
     *
     *
     * Output Format
     * Return an array containing row-wise sums of original matrix.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     * [1,2,3,4]
     * [5,6,7,8]
     * [9,2,3,4]
     *
     *
     * Example Output
     * Output 1:
     *
     * [10,26,18]
     *
     *
     * Example Explanation
     * Explanation 1
     *
     * Row 1 = 1+2+3+4 = 10
     * Row 2 = 5+6+7+8 = 26
     * Row 3 = 9+2+3+4 = 18
     */

    public int[] solve(int[][] A) {
        int[] sums = new int[A.length];
        for(int index = 0; index < A.length; index++) {
            for(int jIndex = 0; jIndex < A[index].length; jIndex++) {
                sums[index] += A[index][jIndex];
            }
        }

        return sums;
    }
}
