package org.anirudroids._2_two_dimentional.problems.additional;

public class Q1_Min_Sum_Path_in_Matrix {
    /**
     * Problem Description
     * Given a M x N grid A of integers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
     *
     * Return the minimum sum of the path.
     *
     * NOTE: You can only move either down or right at any point in time.
     *
     *
     *
     * Problem Constraints
     * 1 <= M, N <= 2000
     *
     * -1000 <= A[i][j] <= 1000
     *
     *
     *
     * Input Format
     * First and only argument is a 2-D grid A.
     *
     *
     *
     * Output Format
     * Return an integer denoting the minimum sum of the path.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [
     *        [1, 3, 2]
     *        [4, 3, 1]
     *        [5, 6, 1]
     *      ]
     * Input 2:
     *
     *  A = [
     *        [1, -3, 2]
     *        [2, 5, 10]
     *        [5, -5, 1]
     *      ]
     *
     *
     * Example Output
     * Output 1:
     *
     *  8
     * Output 2:
     *
     *  -1
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  The path will be: 1 -> 3 -> 2 -> 1 -> 1.
     * Input 2:
     *
     *  The path will be: 1 -> -3 -> 5 -> -5 -> 1.
     */

    public int minPathSum(int[][] A) {

        for(int i = A.length-1; i >= 0; i--) {
            for(int j = A[i].length-1; j >= 0; j--) {
                if(i == A.length-1 && j == A[i].length-1) {
                    continue;
                } else if(j == A[i].length-1) {
                    A[i][j] = A[i][j] + A[i+1][j];
                } else if(i == A.length-1) {
                    A[i][j] = A[i][j] + A[i][j+1];
                } else {
                    A[i][j] = Math.min(A[i+1][j], A[i][j+1]) + A[i][j];
                }
            }
        }

        return A[0][0];
    }
}
