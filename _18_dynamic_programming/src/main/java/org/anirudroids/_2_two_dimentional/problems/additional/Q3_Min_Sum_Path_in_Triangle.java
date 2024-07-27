package org.anirudroids._2_two_dimentional.problems.additional;

import java.util.ArrayList;

public class Q3_Min_Sum_Path_in_Triangle {
    /**
     * Problem Description
     * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
     *
     * Adjacent numbers for jth column of ith row is jth and (j+1)th column of (i + 1)th row
     *
     *
     *
     * Problem Constraints
     * |A| <= 1000
     *
     * A[i] <= 1000
     *
     *
     *
     * Input Format
     * First and only argument is the vector of vector A defining the given triangle
     *
     *
     *
     * Output Format
     * Return the minimum sum
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *
     * A = [
     *          [2],
     *         [3, 4],
     *        [6, 5, 7],
     *       [4, 1, 8, 3]
     *     ]
     * Input 2:
     *
     *  A = [ [1] ]
     *
     *
     * Example Output
     * Output 1:
     *
     *  11
     * Output 2:
     *
     *  1
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
     * Explanation 2:
     *
     *  Only 2 can be collected.
     */

    public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        int[][] dp = new int[a.size()][a.size()];

        for(int j = 0; j < a.get(a.size()-1).size(); j++) {
            dp[a.size()-1][j] = a.get(a.size()-1).get(j);
        }

        for(int i = a.size()-2; i >= 0; i--) {
            for(int j = 0; j < a.get(i).size(); j++) {
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + a.get(i).get(j);
            }
        }

        return dp[0][0];
    }
}
