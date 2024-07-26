package org.anirudroids._08_arrays_carry_forward_subarrays.problems.additional;

public class Q1_Best_Time_to_Buy_and_Sell_Stocks_I {
    /**
     * Problem Description
     * Say you have an array, A, for which the ith element is the price of a given stock on day i.
     * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
     *
     * Return the maximum possible profit.
     *
     *
     *
     * Problem Constraints
     * 0 <= A.size() <= 700000
     * 1 <= A[i] <= 107
     *
     *
     *
     * Input Format
     * The first and the only argument is an array of integers, A.
     *
     *
     * Output Format
     * Return an integer, representing the maximum possible profit.
     *
     *
     * Example Input
     * Input 1:
     * A = [1, 2]
     * Input 2:
     *
     * A = [1, 4, 5, 2, 4]
     *
     *
     * Example Output
     * Output 1:
     * 1
     * Output 2:
     *
     * 4
     *
     *
     * Example Explanation
     * Explanation 1:
     * Buy the stock on day 0, and sell it on day 1.
     * Explanation 2:
     *
     * Buy the stock on day 0, and sell it on day 2.
     */

    public int maxProfit(final int[] A) {

        if(A.length == 0) {
            return 0;
        }

        int n = A.length;
        int result = 0;

        int max = A[n-1];
        for(int index = n-2; index >= 0; index--) {
            if(A[index] > max) {
                max = A[index];
            }
            int profit = max - A[index];
            if(profit > result) {
                result = profit;
            }
        }

        return result;
    }
}
