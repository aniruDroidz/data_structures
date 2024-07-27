package org.anirudroids._1_one_dimentional.problems.mandatory;

import java.util.Arrays;

public class Q3_Minimum_Number_of_Squares {
    /**
     * Problem Description
     * Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.
     *
     *
     *
     * Problem Constraints
     * 1 <= A <= 105
     *
     *
     *
     * Input Format
     * First and only argument is an integer A.
     *
     *
     *
     * Output Format
     * Return an integer denoting the minimum count.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = 6
     * Input 2:
     *
     *  A = 5
     *
     *
     * Example Output
     * Output 1:
     *
     *  3
     * Output 2:
     *
     *  2
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  Possible combinations are : (12 + 12 + 12 + 12 + 12 + 12) and (12 + 12 + 22).
     *  Minimum count of numbers, sum of whose squares is 6 is 3.
     * Explanation 2:
     *
     *  We can represent 5 using only 2 numbers i.e. 12 + 22 = 5
     */

    int[] dp;
    public int countMinSquares(int A) {
        if(dp == null) {
            dp = new int[A+1];
            Arrays.fill(dp, -1);
        }

        if(A == 0 || A == 1) {
            return A;
        }
        if(dp[A] != -1) {
            return dp[A];
        }

        int ans = Integer.MAX_VALUE;
        for(int index = 1; index * index <= A; index++) {
            ans = Math.min(ans, countMinSquares(A-(int)Math.pow(index, 2)));
        }

        dp[A] = ans+1;
        return dp[A];
    }
}
