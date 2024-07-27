package org.anirudroids._28_modular_arithmetic_and_gcd.problems.additional;

public class Q2_Mod_Sum {
    /**
     * Problem Description
     * Given an array of integers A, calculate the sum of A [ i ] % A [ j ] for all possible i, j pairs. Return sum % (109 + 7) as an output.
     *
     *
     *
     * Problem Constraints
     * 1 <= length of the array A <= 105
     *
     * 1 <= A[i] <= 103
     *
     *
     *
     * Input Format
     * The only argument given is the integer array A.
     *
     *
     *
     * Output Format
     * Return a single integer denoting sum % (109 + 7).
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [1, 2, 3]
     * Input 2:
     *
     *  A = [17, 100, 11]
     *
     *
     * Example Output
     * Output 1:
     *
     *  5
     * Output 2:
     *
     *  61
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  (1 % 1) + (1 % 2) + (1 % 3) + (2 % 1) + (2 % 2) + (2 % 3) + (3 % 1) + (3 % 2) + (3 % 3) = 5
     */

    public int solve(int[] A) {
        long mod = 1000000007;

        int n = A.length;
        int[] count = new int[1001];
        for(int a: A) {
            count[a]++;
        }

        long ans = 0;
        for(int i = 1; i < 1001; i++) {
            for(int j = 1; j < 1001; j++) {
                int val = i%j;
                int temp = count[i] * count[j] * val;
                ans = ((ans%mod) + (temp%mod)) % mod;
            }
        }

        return (int)ans;
    }
}
