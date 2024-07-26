package org.anirudroids._15_interview_problems.problems.mandatory;

public class Q2_Row_to_Column_Zero {
    /**
     * Problem Description
     * You are given a 2D integer matrix A, make all the elements in a row or column zero if the A[i][j] = 0. Specifically, make entire ith row and jth column zero.
     *
     *
     *
     * Problem Constraints
     * 1 <= A.size() <= 103
     *
     * 1 <= A[i].size() <= 103
     *
     * 0 <= A[i][j] <= 103
     *
     *
     *
     * Input Format
     * First argument is a 2D integer matrix A.
     *
     *
     *
     * Output Format
     * Return a 2D matrix after doing required operations.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     * [1,2,3,4]
     * [5,6,7,0]
     * [9,2,0,4]
     *
     *
     * Example Output
     * Output 1:
     *
     * [1,2,0,0]
     * [0,0,0,0]
     * [0,0,0,0]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     * A[2][4] = A[3][3] = 0, so make 2nd row, 3rd row, 3rd column and 4th column zero.
     */

    public int[][] solve(int[][] A) {
        for(int index = 0; index < A.length; index++) {
            int flag = 0;

            for(int jIndex = 0; jIndex < A[index].length; jIndex++) {
                if(A[index][jIndex] == 0) {
                    flag = 1;
                    break;
                }
            }

            if(flag == 1) {
                for(int jIndex = 0; jIndex < A[index].length; jIndex++) {
                    if(A[index][jIndex] != 0) {
                        A[index][jIndex] = -1;
                    }
                }
            }
        }

        for(int jIndex = 0; jIndex < A[0].length; jIndex++) {
            int flag = 0;

            for(int index = 0; index < A.length; index++) {
                if(A[index][jIndex] == 0) {
                    flag = 1;
                    break;
                }
            }

            if(flag == 1) {
                for(int index = 0; index < A.length; index++) {
                    if(A[index][jIndex] != 0) {
                        A[index][jIndex] = -1;
                    }
                }
            }
        }

        for(int index = 0; index < A.length; index++) {
            for(int jIndex = 0; jIndex < A[index].length; jIndex++) {
                if(A[index][jIndex] == -1) {
                    A[index][jIndex] = 0;
                }
            }
        }

        return A;
    }
}
