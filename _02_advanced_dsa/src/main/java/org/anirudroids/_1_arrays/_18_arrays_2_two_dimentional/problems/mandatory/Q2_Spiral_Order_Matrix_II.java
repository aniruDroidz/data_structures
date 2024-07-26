package org.anirudroids._1_arrays._18_arrays_2_two_dimentional.problems.mandatory;

public class Q2_Spiral_Order_Matrix_II {
    /**
     * Problem Description
     * Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order and return the generated square matrix.
     *
     *
     *
     * Problem Constraints
     * 1 <= A <= 1000
     *
     *
     *
     * Input Format
     * First and only argument is integer A
     *
     *
     * Output Format
     * Return a 2-D matrix which consists of the elements added in spiral order.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     * 1
     * Input 2:
     *
     * 2
     * Input 3:
     *
     * 5
     *
     *
     * Example Output
     * Output 1:
     *
     * [ [1] ]
     * Output 2:
     *
     * [ [1, 2],
     *   [4, 3] ]
     * Output 3:
     *
     * [ [1,   2,  3,  4, 5],
     *   [16, 17, 18, 19, 6],
     *   [15, 24, 25, 20, 7],
     *   [14, 23, 22, 21, 8],
     *   [13, 12, 11, 10, 9] ]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     * Only 1 is to be arranged.
     * Explanation 2:
     *
     * 1 --> 2
     *       |
     *       |
     * 4<--- 3
     * Explanation 3:
     */

    public int[][] generateMatrix(int A) {
        int[][] result = new int[A][A];

        int number = 1;
        int i = 0;
        int j = 0;

        int n = A;
        while(n > 1) {
            number = iterate(result, n, number, i, j);
            i++;
            j++;
            n -= 2;
        }

        if(n == 1) {
            result[i][j] = number;
        }

        return result;
    }

    public int iterate(int[][] result, int count, int number, int i, int j) {
        for(int index = 0; index < count; index++) {
            result[i][j++] = number++;
        }

        i++;
        j--;
        for(int index = 1; index < count; index++) {
            result[i++][j] = number++;
        }
        j--;
        i--;
        for(int index = 1; index < count; index++) {
            result[i][j--] = number++;
        }
        j++;
        i--;
        for(int index = 2; index < count; index++) {
            result[i--][j] = number++;
        }
        return number;
    }
}
