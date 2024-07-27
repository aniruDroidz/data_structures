package org.anirudroids._1_one_dimentional.problems.additional;

import java.util.Arrays;

public class Q3_Ways_to_Decode {
    /**
     * Problem Description
     * A message containing letters from A-Z is being encoded to numbers using the following mapping:
     *
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     * Given an encoded message denoted by string A containing digits, determine the total number of ways to decode it modulo 109 + 7.
     *
     *
     *
     * Problem Constraints
     * 1 <= length(A) <= 105
     *
     *
     *
     * Input Format
     * The first and the only argument is a string A.
     *
     *
     *
     * Output Format
     * Return an integer, representing the number of ways to decode the string modulo 109 + 7.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = "12"
     * Input 2:
     *
     *  A = "8"
     *
     *
     * Example Output
     * Output 1:
     *
     *  2
     * Output 2:
     *
     *  1
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  Given encoded message "12", it could be decoded as "AB" (1, 2) or "L" (12).
     *  The number of ways decoding "12" is 2.
     * Explanation 2:
     *
     *  Given encoded message "8", it could be decoded as only "H" (8).
     *  The number of ways decoding "8" is 1.
     */

    int n;
    int[] dp;
    public int numDecodings(String A) {
        n = A.length();
        dp = new int[n+1];

        Arrays.fill(dp, -1);
        return count(A, 0);
    }

    private int count(String A, int position) {
        if(position == n) return 1;
        if(A.charAt(position) == '0') return 0;

        if(dp[position] != -1) return dp[position];

        int count = count(A, position+1);

        if(position < n-1 && (A.charAt(position) == '1' || A.charAt(position) == '2' && A.charAt(position+1) < '7')) {
            count += count(A, position+2)%1000000007;
        }

        dp[position] = count%1000000007;

        return dp[position];
    }
}
