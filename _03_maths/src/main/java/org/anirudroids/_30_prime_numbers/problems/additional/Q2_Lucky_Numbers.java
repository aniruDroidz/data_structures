package org.anirudroids._30_prime_numbers.problems.additional;

public class Q2_Lucky_Numbers {
    /**
     * Problem Description
     * A lucky number is a number that has exactly 2 distinct prime divisors.
     *
     * You are given a number A, and you need to determine the count of lucky numbers between the range 1 to A (both inclusive).
     *
     *
     *
     * Problem Constraints
     * 1 <= A <= 50000
     *
     *
     *
     * Input Format
     * The first and only argument is an integer A.
     *
     *
     *
     * Output Format
     * Return an integer i.e the count of lucky numbers between 1 and A, both inclusive.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = 8
     * Input 2:
     *
     *  A = 12
     *
     *
     * Example Output
     * Output 1:
     *
     *  1
     * Output 2:
     *
     *  3
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  Between [1, 8] there is only 1 lucky number i.e 6.
     *  6 has 2 distinct prime factors i.e 2 and 3.
     * Explanation 2:
     *
     *  Between [1, 12] there are 3 lucky number: 6, 10 and 12.
     */

    public int solve(int A) {
        int[] primeCount = new int[A+1];

        for(int i = 2; i <= A; i++) {
            if(primeCount[i] == 0) {
                for(int j = 2*i; j <= A; j = j + i) {
                    primeCount[j] += 1;
                }
            }
        }

        int count = 0;
        for (int j : primeCount) {
            if (j == 2) {
                count++;
            }
        }

        return count;
    }
}
