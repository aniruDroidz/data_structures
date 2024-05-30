package org.anirudroids;

public class _2_Two_Dimensional {
    public static void main(String[] args) {

    }

    /**
     * Find maximum subsequence sum from a given integer array of size N, where you can't select adjacent elements
     */
    private int first(int[] A) {
        maxSum(A, A.length-1, false, 0);

        return ans;
    }
    int ans = 0;
    private void maxSum(int[] A, int index, boolean lastSelect, int sum) {
        if(index == -1) {
            ans = Math.max(ans, sum);
            return;
        }

        maxSum(A, index-1, false, sum); // NS

        if(!lastSelect) {
            maxSum(A, index-1, true, sum+A[index]);
        }
    }

    /**
     * Optimise above solution using recursion
     */
    private int second(int[] A) {
        return maxSumSecond(A, A.length-1);
    }

    private int maxSumSecond(int[] A, int index) {
        if(index == 0) {
            return A[0];
        }

        if(index == 1) {
            return Math.max(A[0], A[1]);
        }

        return Math.max(maxSumSecond(A, index-1), A[index] + maxSumSecond(A, index-2));
    }

    /**
     * Optimise above solution using recursion - Fibonacci DP, using memoisation
     */
    private int third(int[] A) {
        return maxSumTopDown(A, A.length-1);
    }

    /**
     * Top-Down
     */
    int[] dp;
    private int maxSumTopDown(int[] A, int index) {
        if(dp == null) {
            dp = new int[A.length+1];
        }
        if(index == 0) {
            return A[0];
        }

        if(index == 1) {
            return Math.max(A[0], A[1]);
        }

        if(dp[index] != -1) {
            return dp[index];
        }
        dp[index] = Math.max(maxSumSecond(A, index-1), A[index] + maxSumSecond(A, index-2));

        return dp[index];
    }

    /**
     * Bottom-Up
     */
    private int maxSumBottomUp(int[] A) {
        if(dp == null) {
            dp = new int[A.length];
        }

        dp[0] = A[0];
        dp[1] = Math.max(A[0], A[1]);

        for(int i = 2; i < A.length; i++) {
            dp[i] = Math.max(dp[i-1], A[i]+dp[i-2]);
        }

        return dp[A.length-1];
    }

    /**
     * Given a matrix of size n*m. Find the total no. of ways to go from (0,0) to (n-1,m-1).
     */
    private void forth(int[][] A) {
        //Step 1. Notion of choice => Recursion
            // Elements of choice => Go right or Go down
            // What does the recursive state calculates
            // Recurrence relationship
            // Which state is answer ??


    }

    private int ways(int i, int j) {
        if(i == 0 || j == 0) {
            return 1;
        }

        return ways(i-1,j) + ways(i, j-1);
    }

    /**
     * Using memoisation (Top-Down)
     */
    int[][] dp1;
    private int ways1(int i, int j) {
        if(i == 0 || j == 0) {
            return 1;
        }

        if(dp1[i][j] != -1) {
            return dp1[i][j];
        }

        dp1[i][j] = ways1(i-1,j) + ways1(i, j-1);

        return dp1[i][j];
    }

    /**
     * Using Bottom-Up approach
     */
    private void ways2(int[][] A) {
        int[][] dp2 = new int[A.length][A[0].length];

        for(int j = 0; j < A[0].length; j++) {
            dp2[0][j] = 1;
        }

        for(int i = 0; i < A.length; i++) {
            dp2[i][0] = 1;
        }

        for(int i = 1; i < A.length; i++) {
            for(int j = 1; j < A[0].length; j++) {
                dp2[i][j] = dp2[i-1][j] + dp2[i][j-1];
            }
        }
    }
}
