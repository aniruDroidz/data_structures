package org.anirudroids._42_binary_search_problems.problems.mandatory;

public class Q3_Ath_Magical_Number {
    /**
     * Problem Description
     * You are given three positive integers, A, B, and C.
     *
     * Any positive integer is magical if divisible by either B or C.
     *
     * Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
     *
     * Note: Ensure to prevent integer overflow while calculating.
     *
     *
     *
     * Problem Constraints
     * 1 <= A <= 109
     *
     * 2 <= B, C <= 40000
     *
     *
     *
     * Input Format
     * The first argument given is an integer A.
     *
     * The second argument given is an integer B.
     *
     * The third argument given is an integer C.
     *
     *
     *
     * Output Format
     * Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = 1
     *  B = 2
     *  C = 3
     * Input 2:
     *
     *  A = 4
     *  B = 2
     *  C = 3
     *
     *
     * Example Output
     * Output 1:
     *
     *  2
     * Output 2:
     *
     *  6
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  1st magical number is 2.
     * Explanation 2:
     *
     *  First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.
     */

    public long lcm(int n1, int n2) {
        int x = n1;
        int y = n2;
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        int gcd = x;
        return ((long) n1 * n2) / gcd;
    }

    public int solve(int A, int B, int C) {
        long x = lcm(B,C);

        long s = Math.min(B, C);
        long e = s * A;
        long ans = 0;
        while(s <= e) {
            long mid = (s + e)/2;
            long count = mid/B + mid/C - mid/x;

            if(count == A) {
                ans = mid;
                e = mid - 1;
            } else if(count > A){
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return (int)(ans% 1000000007);
    }
}
