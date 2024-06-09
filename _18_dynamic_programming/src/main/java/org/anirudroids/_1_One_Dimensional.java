package org.anirudroids;

import java.util.Arrays;
import java.util.Scanner;

public class _1_One_Dimensional {

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    /**
     * Code for fibonacci series by using dynamic programming by storing the sub-problems which we've already calculated
     * Top-Down DP
     */

    private int[] fib;
    private int fibonacci(int n) {
        if(fib == null) {
            fib = new int[n+1];
            Arrays.fill(fib, -1);
        }
        if(n == 0 || n == 1) return n;

        if(fib[n] != -1) {
            return fib[n];
        }

        fib[n] = fibonacci(n-1) + fibonacci(n-2);

        return fib[n];
    }

    /**
     * Bottom-Up DP
     */
    private int fibonacci_1(int n) {
        int[] fib = new int[n+1];
        fib[0] = 0;
        fib[1] = 1;

        for(int i = 2; i <= n; i++) {
            fib[i] = fib[i-1]+fib[i-2];
        }

        return fib[n];
    }

    /**
     * Bottom-Up DP - more optimised
     */
    private int fibonacci_2(int n) {
        int fibn2 = 0;
        int fibn1 = 1;

        for(int i = 2; i <= n; i++) {
            int temp = fibn1 + fibn2;
            fibn2 = fibn1;
            fibn1 = temp;
        }

        return fibn1;
    }

    /**
     * Staircase
     * One step = jump 1 staircase or jump 2 staircases
     * Find the no. of ways to reach Nth staircase.
     */
    /**
     * Using top-down = recursion + memoization
     */
    int[] sc;
    private int staircase_1(int n) {
        if(sc == null) {
            sc = new int[n+1];
            Arrays.fill(sc, -1);
        }
        if(n == 1 || n == 2) return n;

        if(sc[n] != -1) {
            return sc[n];
        }

        sc[n] = staircase_1(n-1) + staircase_1(n-2);

        return sc[n];
    }

    /**
     * Using bottom-up = iterative
     */

    private int staircase_2(int n) {
        int fibn2 = 2;
        int fibn1 = 1;

        for (int i = 2; i <= n; i++) {
            int temp = fibn1 + fibn2;
            fibn2 = fibn1;
            fibn1 = temp;
        }

        return fibn1;
    }

    /**
     * Given an integer N.
     * Figure out the minimum number of perfect squares we can add to get the sum = N
     */
    int[] dp;
    private int fifth(int n) {
        // Elements of choice = all where i*i <= n
        // What will the state represent = min num of squares required to form sum = n
            // min square(i) = min squares required to form sum = i
        // Recurrence relationship
            // minSquare[i] = for all j where j*j<=n Math.min(min, Square(i-j^2))+1);
        //Which state is the answer?
            // minSquare(N)
        if(dp == null) {
            dp = new int[n+1];
            Arrays.fill(dp, -1);
        }

        if(n == 0) {
            return 0;
        }

        if(dp[n] != -1) {
            return dp[n];
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 1; i * i <= n; i++) {
            ans = Math.min(ans, fifth(n-i*i) + 1);
        }

        dp[n] = ans;
        return dp[n];
    }
}