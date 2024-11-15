package org.anirudroids._2_two_dimentional.problems.additional;

public class Q2_Max_Rectangle_in_Binary_Matrix {
    /**
     * Problem Description
     * Given a 2-D binary matrix A of size N x M filled with 0's and 1's, find the largest rectangle containing only ones and return its area.
     *
     *
     *
     * Problem Constraints
     * 1 <= N, M <= 100
     *
     *
     *
     * Input Format
     * The first argument is a 2-D binary array A.
     *
     *
     *
     * Output Format
     * Return an integer denoting the area of the largest rectangle containing only ones.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [
     *        [1, 1, 1]
     *        [0, 1, 1]
     *        [1, 0, 0]
     *      ]
     * Input 2:
     *
     *  A = [
     *        [0, 1, 0]
     *        [1, 1, 1]
     *      ]
     *
     *
     * Example Output
     * Output 1:
     *
     *  4
     * Output 2:
     *
     *  3
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  As the max area rectangle is created by the 2x2 rectangle created by (0, 1), (0, 2), (1, 1) and (1, 2).
     * Explanation 2:
     *
     *  As the max area rectangle is created by the 1x3 rectangle created by (1, 0), (1, 1) and (1, 2).
     */

    public int maximalRectangle(int[][] A) {

        for(int i = 0; i < A.length; i++){
            int sum = 0;
            for(int j = 0; j < A[i].length; j++){
                if(A[i][j] == 0){
                    sum = 0;
                }else{
                    sum += A[i][j];
                }
                A[i][j] = sum;
            }
        }

        int result = 0;
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[i].length; j++){
                int width = Integer.MAX_VALUE;
                int height = 0;
                int k = i;

                while(k >= 0){
                    width = Math.min(width, A[k][j]);
                    height += 1;
                    result = Math.max(result, width * height);
                    k--;
                }
            }
        }

        return result;
    }
}
