package org.anirudroids.jan24_intermediate;

import javax.swing.*;
import java.util.Arrays;

public class _1_One_Dimensional {

    /**
     * Fibonacci series - recursive
     */
    public int fibonacci(int n) {
        // fib(n) = fib(n-1) + fib(n-2)

        if(n <= 1) return n;

        return fibonacci(n-1) + fibonacci(n-2);

        // T.C. = O(2^n)
        // S.C. = recursive space
    }

    /**
     * Dynamic programming
     * 2 Properties
     * 1. Optimal substructure      => If ans of a big problem can be calculated using ans of its sub-problem
     * 2. Overlapping sub-problems  => Same problem is calculated multiple times
     */

    /**
     * Fibonacci series using dynamic programming (using memoization)
     */
    int[] dp;
    public int fibonacciUsingDp(int n) {
        // fib(n) = fib(n-1) + fib(n-2)
        if(dp == null) {
            dp = new int[n];
            Arrays.fill(dp, -1);
        }

        if(n <= 1) return n;

        if(dp[n] != -1) {
            return dp[n];
        }
        dp[n] = fibonacci(n-1) + fibonacci(n-2);
        return dp[n];

        // T.C. = O(n)
        // S.C. = O(N+recursive space)
    }

    /**
     * Types pf D.P.
     * 1. Top Down -> Memoization -> recursive approach
     *  -> Start with big problem, go down till the smallest sub-problem for which you already know the answer & use that to compute ans for bigger/original problem
     *  -------
     * 2. Bottom Up/Iterative
     *  -> Start with smallest sub-problem for which you already know the answer and use it to iteratively get the ans for current problem.
     */

    int[] dp1;
    public int fibonacciUsingDp_Iterative(int n) {
        if(dp1 == null) dp = new int[n];

        dp[0] = 0;
        dp[1] = 1;

        for(int index = 2; index < n; index++) {
            dp[index] = dp[index-1] + dp[index-2];
        }

        return dp[n];
        // T.C. = O(N)
        // S.C. = O(N)
    }

    /**
     * Which approach to choose?
     * Recursive DP => Easy to code
     * Iterative DP => No recursive space => There are chances to optimise space
     */


    public int fibonacciUsingDp_Iterative_WithoutExtraSpace(int n) {
        int a = 0;
        int b = 1;
        for(int index = 2; index < n; index++) {
            int c = a + b;
            a = b;
            b = c;
        }

        return b;
        // T.C. = O(N)
        // S.C. = O(N)
    }

    /**
     * Calculate # of ways to reach nth stair. You can take 1 step or 2 steps at a time.
     */

    public int ways(int n) {
        return 0;
    }

    /**
     * Find min # of perfect squares required to get sum = N (duplicates are allowed)
     */
    int[] dp2;
    public int minPerfectSquares(int n) {
        if(dp2 == null) {
            dp2 = new int[n+1];
            Arrays.fill(dp2, -1);
        }

        if(n == 0 || n == 1) {
            return n;
        }
        if(dp2[n] != -1) {
            return dp2[n];
        }

        int ans = Integer.MAX_VALUE;
        for(int index = 1; index * index <= n; index++) {
            ans = Math.min(ans, minPerfectSquares(n-(int)Math.pow(index, 2)));
        }

        dp[n] = ans+1;
        return dp[n];
        //T.C. = O(n)
        //S.c. = O(n)
    }

    /**
     * Minimum # of notes required for the amount.
     * Notes are => 50, 30, 5
     */
    int[] dp3;
    public int minNotes(int n) {
        if(dp3 == null) {
            dp3 = new int[n+1];
        }
        if(n == 0) return 0;
        if(n < 0) return Integer.MAX_VALUE;

        if(dp[n] == -1) return dp[n];

        int ans = Integer.MAX_VALUE;
        ans = 1 + Math.min(ans, Math.min(minNotes(n-50), Math.min(minNotes(n-30), minNotes(n-5))));

        dp[n] = ans;
        return dp[n];
        //T.C. = O(N)
        //S.C. = O(N)
    }
    
    /**
     * Bottoms-up (Iterative) for above question - homework
     */
}
