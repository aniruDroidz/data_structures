package org.anirudroids._3_knapsack.problems.additional;

import java.util.Arrays;

public class Q2_Tushars_Birthday_Party {
    /**
     * Problem Description
     * As it is Tushar's Birthday on March 1st, he decided to throw a party to all his friends at TGI Fridays in Pune. Given are the eating capacity of each friend, filling capacity of each dish and cost of each dish. A friend is satisfied if the sum of the filling capacity of dishes he ate is equal to his capacity. Find the minimum cost such that all of Tushar's friends are satisfied (reached their eating capacity).
     *
     * NOTE:
     *
     * Each dish is supposed to be eaten by only one person. Sharing is not allowed.
     *
     * Each friend can take any dish unlimited number of times.
     *
     * There always exists a dish with filling capacity 1 so that a solution always exists.
     *
     *
     *
     * Problem Constraints
     * |A| <= 1000
     *
     * |B| <= 1000
     *
     * |C| <= 1000
     *
     *
     *
     * Input Format
     * First Argument is vector A, denoting eating capacities
     *
     * Second Argument is vector B, denoting filling capacities
     *
     * Third Argument is vector C, denoting cost
     *
     *
     *
     * Output Format
     * Return a single integer, the answer to the problem
     *
     *
     *
     * Example Input
     * Input 1:
     *
     * A = [2, 4, 6]
     * B = [2, 1, 3]
     * C = [2, 5, 3]
     * Input 2:
     *
     * A = [2]
     * B = [1]
     * C = [2]
     *
     *
     * Example Output
     * Output 1:
     *
     * 12
     * Output 2:
     *
     * 4
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     * First friend takes dish 1, Second friend takes dish 1 twice and third friend takes dish 3 twice.
     * So 2 + 2*2 + 3*2 = 12.
     * Explanation 2:
     *
     * Only way is to take 2 dishes of cost 2, hence 4.
     */

    public int solve(final int[] A, final int[] B, final int[] C) {
        int maximum = Integer.MIN_VALUE;
        int minimum = 0;
        int n = B.length;
        for (int j : A) maximum = Math.max(j, maximum);
        int[][] dp = new int[n][maximum+1];
        for(int[] arr: dp) {
            Arrays.fill(arr,-1);
        }
        for(int manCap: A) {
            minimum += getMinimumCost(n-1, manCap, B, C, dp);
        };
        return minimum;
    }

    public int getMinimumCost(int i, int manCap, int[] B, int[] C, int[][] dp) {
        if(manCap==0) return 0;
        if(i<0) return Integer.MAX_VALUE;
        if(dp[i][manCap]!=-1) return dp[i][manCap];

        int notTake = getMinimumCost(i-1, manCap, B, C, dp);

        long result = 0L;

        if(manCap>=B[i]) {
            result = Math.min(notTake, Long.valueOf(getMinimumCost(i, manCap-B[i], B, C, dp)) + C[i]);
        }else {
            result = notTake;
        }

        dp[i][manCap] = (int)result;

        return dp[i][manCap];
    }
}
