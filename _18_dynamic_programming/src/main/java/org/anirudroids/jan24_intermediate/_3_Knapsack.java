package org.anirudroids.jan24_intermediate;

public class _3_Knapsack {

    public static void main(String[] args) {

    }

    /**
     * Given N objects with their profit/loss value[i] & weight[i]
     * A bag is given with capacity W that can be used to carry objects s.t.
     * 1) total sum of selected objects <= W
     * 2) Sum of profit/loss is max/min
     */

    /*--------------------------------------------------------------------*/

    /**
     * Fractional Knapsack.
     * Q. Given N cakes with their happiness & weight.
     * Find max total happiness that can be kept in a bag with total capacity of W (Cakes can be divided)
     */
    private void first(int[] h, int[] w) {
        // 1) Sort w.r.t. h/w
        // 2) Select cakes/part in descending order of h[i]/w[i]

        //T.C. => O(N logN) S.C. => O(N)
    }

    /**
     * 0-1 Knapsack
     * Q. Given N toys with their happiness & weight (cost).
     * Find max total happiness that can be kept in a bag with total capacity of W
     */
    private void second(int[] h, int[] w, int c) {
        // Greedy approach like above won't work here
        // Brute force - For all subsets of toys, check if sum of weights <= W, take max of all h[i]
        // T.C. = O (N * 2^N), post optimisation (2^N -> using carry forward technic)

        // For these kind of problems we need to save the state => (index, capacity)
        // T.C = Number of unique states => N*(W+1) => N*W < 2^N
        // ans[i][j] = max. happiness considering first i objects & capacity j

        int[][] ans = new int[h.length][c+1];

        for(int i = 1; i < h.length; i++) {
            for(int j = 1; j <= c; j++) {
                if (j < w[i]) {
                    ans[i][j] = ans[i - 1][j];
                } else {
                    ans[i][j] = Math.max(h[i] + ans[i-1][j-w[i]], ans[i-1][j]);
                }
            }
        }

        // T.C. => O(N*W)
        // S.C. => O(N*W) -- after optimising O(W) with 2 1D arrays
    }

    /**
     * Type 3: Unbounded Knapsack/0-N Knapsack
     * Objects cannot be divided
     * Diff - One object can be selected multiple times
     */

    /**
     * Q. Given N toys with their happiness & weight (cost).
     * Find max total happiness that can be kept in a bag with total capacity of W.
     * A toy can be selected multiple times
     */
    private int third(int[] h, int[] w, int c) {
        // state will be the remaining capacity
        // Number of unique states => W
        // T.C. => N^Height => N^W

        int[] ans = new int[c+1];
        // ans[i] => max happiness with capacity i
        // ans[i] => for all j.. max(h[j] + ans[i - w[j]])

        for(int i = 1; i <= c; i++) {
            for(int j = 1; j < h.length; j++) {
                if(i >= w[j]) {
                    ans[i] = Math.max(ans[i], h[j] + ans[i-w[j]]);
                }
            }
        }

        return ans[c];
    }
}
