package org.anirudroids.jan24_intermediate;

public class _4_Applications_of_Knapsack {

    public static void main(String[] args) {
        System.out.println(first(new int[] {1, 4 , 2, 5, 6}));
    }

    /**
     * Given a rod of length N and an array A of length N.
     * A[i] => price of 5 length rod (index is 1 based)
     * Find max value that can be obtained by cutting some pieces & selling them
     */

    private static int first(int[] arr) {
        // dp[i] => max value if length is i
        // for all dp[i] = 0

        int[] dp = new int[arr.length];
        for(int index = 0; index < arr.length; index++) {
            for(int jIndex = 0; jIndex < index; jIndex++) {
                dp[index] = Math.max(dp[index], arr[jIndex] + dp[index-jIndex]);
            }
        }

        return dp[arr.length-1];
    }

    /**
     * In how many ways can we make N by using coins given in the arrays.
     * A[i] = value of ith coin
     * One coin can be used multiple times
     * (Ordered selection)
     */
    private static int second(int[] arr, int N) {
        // dp[i] => # of ways to select coins such that sum = i
        int[] dp = new int[N+1];
        dp[0] = 1;

        for(int index = 1; index <= N; index++) {
            for(int jIndex = 0; jIndex < arr.length - 1; jIndex++) {
                if(arr[jIndex] <= index) {
                    dp[index] = dp[index] + dp[index-arr[jIndex]];
                }
            }
        }

        return dp[N];

        // T.C. = O(N*A.length)
    }

    /**
     * In how many ways can we make N by using coins given in the arrays.
     * A[i] = value of ith coin
     * One coin can be used multiple times
     * (unordered selection)
     */
    private int third(int[] arr, int N) {
        int[] dp = new int[N+1];
        dp[0] = 1;
        for(int jIndex = 0; jIndex < arr.length - 1; jIndex++) {
            for(int index = 0; index <= N; index++) {
                if(arr[jIndex] <= index) {
                    dp[index] = dp[index] + dp[index-arr[jIndex]];
                }
            }
        }

        return dp[N];
    }

    /**
     * We are given N toys with their happiness & weight. Find maximum total happiness that can be kept in a bag with capacity W.
     *
     * 0 <= N <= 500
     * 0 <= h[i] <= 50
     * 0 <= wt[i] <= 10^9
     * 0 <= W <= 10^9
     */
    private int forth(int[] toys, int W) {

        return 0;
    }
}
