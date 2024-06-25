package org.anirudroids.jan24_intermediate;

import java.util.Arrays;

public class _2_Two_Dimensional {
    public static void main(String[] args) {

    }

    /**
     * Find maximum subsequence sum from a give array, where selecting adjacent element is not allowed
     */
    int[] dp;
    private void maxSubsequence(int[] A) {
        dp = new int[A.length];
        Arrays.fill(dp, -1);
        maxSum(A, A.length-1);
    }

    private int maxSum(int[] arr, int index) {
        if(index < 0) return 0;

        if(dp[index] != -1) return dp[index];

        int t1 = maxSum(arr, index-1);
        int t2 = arr[index] + maxSum(arr, index-2);

        dp[index] = Math.max(t1, t2);
        return dp[index];
    }

    int[] dp2;
    private int maxSubsequenceIterative(int[] A) {
        dp2 = new int[A.length];
        dp2[0] = A[0];
        dp2[1] = Math.max(A[0], A[1]);

        for(int index = 2; index < A.length; index++) {
            dp[index] = Math.max(A[index] + dp[index-2], dp[index-1]);
        }

        return dp[A.length-1];
    }

    /**
     * Count Unique paths
     */
    private void third(int[][] arr) {
        // ways(i, j) = ways(i-1, j) + ways(i, j-1)

        dp3 = new int[arr.length][arr[0].length];

        waysUsingDp(arr.length-1, arr.length-1);
    }

    private int ways(int i, int j) {
        if(i==0 || j==0) {
            return 1;
        }

        return ways(i-1, j) + ways(i, j-1);

        // T.C. = O(2^n*m)
    }

    int[][] dp3;
    private int waysUsingDp(int i, int j) {
        if(i==0 || j==0) {
            return 1;
        }

        if(dp3[i][j] == -1) {
            return dp3[i][j];
        }

        dp3[i][j] = waysUsingDp(i-1, j) + waysUsingDp(i, j-1);

        return dp3[i][j];

        // T.C. = O(2^n*m)
    }

    /**
     * No. of ways to reach bottom right with the given constraint
     */
    private void forth(int[][] mat) {
        // extension to previous problem
    }

    /**
     * Dungeons and Princes
     * Find min health with which prince should start so that he can reach to princes without dying
     */

    int[][] dp4;
    private int find(int[][] mat) {
        // Start from the princes
        // x + arr[i][j] = min(dp[i+1][j], dp[i][j+1])
        // If entry health is negative, reset it to 1
        int n = mat.length;
        int m = mat[0].length;
        dp4 = new int[n-1][m-1];

        if(mat[n-1][m-1] > 0) {
            dp4[n-1][m-1] = 1;
        } else {
            dp4[n-1][m-1] = 1 - Math.abs(mat[n-1][m-1]);
        }

        //Fill last row & last column
        for(int index = n-2; index >= 0; index--) {
            for(int jIndex = m-2; jIndex >= 0; jIndex--) {
                dp4[index][jIndex] = Math.max(1, Math.min(dp4[index+1][jIndex], dp4[index][jIndex+1]) - mat[index][jIndex]);
            }
        }

        return dp4[0][0];
    }
}
