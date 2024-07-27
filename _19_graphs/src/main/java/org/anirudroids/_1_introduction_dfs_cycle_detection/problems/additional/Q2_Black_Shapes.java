package org.anirudroids._1_introduction_dfs_cycle_detection.problems.additional;

public class Q2_Black_Shapes {
    /**
     * Problem Description
     * Given character matrix A of dimensions N×M consisting of O's and X's, where O = white, X = black.
     *
     * Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)
     *
     *
     *
     * Problem Constraints
     * 1 <= N, M <= 1000
     *
     * A[i][j] = 'X' or 'O'
     *
     *
     *
     * Input Format
     * The First and only argument is character matrix A.
     *
     *
     *
     * Output Format
     * Return a single integer denoting number of black shapes.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [ [X, X, X], [X, X, X], [X, X, X] ]
     * Input 2:
     *
     *  A = [ [X, O], [O, X] ]
     *
     *
     * Example Output
     * Output 1:
     *
     *  1
     * Output 2:
     *
     *  2
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  All X's belong to single shapes
     * Explanation 2:
     *
     *  Both X's belong to different shapes
     */

    public int black(String[] A) {
        int result = 0;

        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[i].length(); j++) {
                if(A[i].charAt(j) == 'X') {
                    isPartOfBlackShape(A, i, j);
                    result++;
                }
            }
        }

        return result;
    }

    private void isPartOfBlackShape(String[] A, int i, int j) {
        if(i < 0 || i >= A.length || j < 0 || j >= A[0].length() || A[i].charAt(j) == 'O' || A[i].charAt(j) == 'B') return;

        char[] arr = A[i].toCharArray();
        arr[j] = 'B';
        A[i] = new String(arr);

        isPartOfBlackShape(A, i-1, j);
        isPartOfBlackShape(A, i+1, j);
        isPartOfBlackShape(A, i, j-1);
        isPartOfBlackShape(A, i, j+1);
    }
}
