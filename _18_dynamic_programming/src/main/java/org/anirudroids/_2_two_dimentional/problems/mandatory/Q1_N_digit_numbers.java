package org.anirudroids._2_two_dimentional.problems.mandatory;

public class Q1_N_digit_numbers {
    /**
     * Problem Description
     * Find out the number of A digit positive numbers, whose digits on being added equals to a given number B.
     *
     * Note that a valid number starts from digits 1-9 except the number 0 itself. i.e. leading zeroes are not allowed.
     *
     * Since the answer can be large, output answer modulo 1000000007
     *
     *
     *
     * Problem Constraints
     * 1 <= A <= 1000
     *
     * 1 <= B <= 10000
     *
     *
     *
     * Input Format
     * First argument is the integer A
     *
     * Second argument is the integer B
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
     *  A = 2
     *  B = 4
     * Input 2:
     *
     *  A = 1
     *  B = 3
     *
     *
     * Example Output
     * Output 1:
     *
     *  4
     * Output 2:
     *
     *  1
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  Valid numbers are {22, 31, 13, 40}
     *  Hence output 4.
     * Explanation 2:
     *
     *  Only valid number is 3
     */

    public int solve(int A, int B) {
        if(B > A*9) {
            return 0;
        }

        long[][] dp = new long[A+1][B+1];

        dp[0][0] = 1;

        for(int i = 1; i <= A; i++) {
            dp[i][0] = 0;
        }

        for(int j = 1; j <= B; j++) {
            dp[0][j] = 0;
        }

        for(int i = 1; i <= A; i++) {
            for(int j = 1; j <= B; j++) {
                for(int k = Math.min(9, j); k >= 0; k--) {
                    if(i == 1 && k == 0) continue;
                    dp[i][j] += dp[i-1][j-k];
                }
                dp[i][j] = dp[i][j]%1000000007;
            }
        }

        return (int)dp[A][B];
    }
}
