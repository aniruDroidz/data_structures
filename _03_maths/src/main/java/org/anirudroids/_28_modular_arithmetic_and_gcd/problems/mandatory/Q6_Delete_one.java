package org.anirudroids._28_modular_arithmetic_and_gcd.problems.mandatory;

import java.util.ArrayList;

public class Q6_Delete_one {
    /**
     * Problem Description
     * Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.
     *
     * Find the maximum value of GCD.
     *
     *
     *
     * Problem Constraints
     * 2 <= N <= 105
     * 1 <= A[i] <= 109
     *
     *
     *
     * Input Format
     * First argument is an integer array A.
     *
     *
     *
     * Output Format
     * Return an integer denoting the maximum value of GCD.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [12, 15, 18]
     * Input 2:
     *
     *  A = [5, 15, 30]
     *
     *
     * Example Output
     * Output 1:
     *
     *  6
     * Output 2:
     *
     *  15
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  If you delete 12, gcd will be 3.
     *  If you delete 15, gcd will be 6.
     *  If you delete 18, gcd will 3.
     *  Maximum value of gcd is 6.
     * Explanation 2:
     *
     *  If you delete 5, gcd will be 15.
     *  If you delete 15, gcd will be 5.
     *  If you delete 30, gcd will be 5.
     *  Maximum value of gcd is 15.
     */

    private int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }

    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        int[] prefix = new int[A.size() + 2];
        int[] suffix = new int[A.size() + 2];

        prefix[1] = A.get(0);
        for(int i = 2; i <= n; i++) {
            prefix[i] = gcd(prefix[i - 1], A.get(i-1));
        }

        suffix[n] = A.get(n-1);
        for(int i = n-1; i >= 1; i--) {
            suffix[i] = gcd(suffix[i + 1], A.get(i - 1));
        }

        int ans = Math.max(suffix[2], prefix[n - 1]);

        for(int i = 2; i < n; i++) {
            ans = Math.max(ans, gcd(prefix[i - 1], suffix[i + 1]));
        }

        return ans;
    }
}
