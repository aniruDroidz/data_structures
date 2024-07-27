package org.anirudroids._1_introduction_dfs_cycle_detection.problems.additional;

import java.util.ArrayList;

public class Q1_Capture_Regions_on_Board {
    /**
     * Problem Description
     * Given a 2-D board A of size N x M containing 'X' and 'O', capture all regions surrounded by 'X'.
     *
     * A region is captured by flipping all 'O's into 'X's in that surrounded region.
     *
     *
     *
     * Problem Constraints
     * 1 <= N, M <= 1000
     *
     *
     *
     * Input Format
     * First and only argument is a N x M character matrix A.
     *
     *
     *
     * Output Format
     * Return nothing. Make changes to the the input only as matrix is passed by reference.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [
     *        [X, X, X, X],
     *        [X, O, O, X],
     *        [X, X, O, X],
     *        [X, O, X, X]
     *      ]
     * Input 2:
     *
     *  A = [
     *        [X, O, O],
     *        [X, O, X],
     *        [O, O, O]
     *      ]
     *
     *
     * Example Output
     * Output 1:
     *
     *  After running your function, the board should be:
     *  A = [
     *        [X, X, X, X],
     *        [X, X, X, X],
     *        [X, X, X, X],
     *        [X, O, X, X]
     *      ]
     * Output 2:
     *
     *  After running your function, the board should be:
     *  A = [
     *        [X, O, O],
     *        [X, O, X],
     *        [O, O, O]
     *      ]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  O in (4,2) is not surrounded by X from below.
     * Explanation 2:
     *
     *  No O's are surrounded.
     */

    public void solve(ArrayList<ArrayList<Character>> a) {
        if (a == null || a.isEmpty())
            return;
        int rows = a.size();
        int cols = a.get(0).size();
        for (int i = 0; i < cols; i++) {
            if (a.get(0).get(i) == 'O') {
                dfs(a, 0, i);
            }
            if (a.get(rows - 1).get(i) == 'O') {
                dfs(a, rows - 1, i);
            }
        }
        for (int i = 0; i < rows; i++) {
            if (a.get(i).get(0) == 'O') {
                dfs(a, i, 0);
            }
            if (a.get(i).get(cols - 1) == 'O') {
                dfs(a, i, cols - 1);
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (a.get(i).get(j) == 'O') {
                    a.get(i).set(j, 'X');
                }
                if (a.get(i).get(j) == 'B') {
                    a.get(i).set(j, 'O');
                }
            }
        }
    }

    private void dfs(ArrayList<ArrayList<Character>> a, int row, int col) {
        if (row < 0 || col < 0 || row >= a.size() || col >= a.get(0).size() || a.get(row).get(col) == 'X' || a.get(row).get(col) == 'B')
            return;
        a.get(row).set(col, 'B');
        dfs(a, row + 1, col);
        dfs(a, row - 1, col);
        dfs(a, row, col + 1);
        dfs(a, row, col - 1);
    }
}
