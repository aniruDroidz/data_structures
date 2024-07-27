package org.anirudroids._30_prime_numbers.problems.additional;

import java.util.Arrays;

public class Q1_Prime_Sum {
    /**
     * Problem Description
     * Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal to the given number.
     *
     * If there is more than one solution possible, return the lexicographically smaller solution.
     *
     * If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then
     * [a, b] < [c, d], If a < c OR a==c AND b < d.
     * NOTE: A solution will always exist. Read Goldbach's conjecture.
     *
     *
     *
     * Problem Constraints
     * 4 <= A <= 2*107
     *
     *
     *
     * Input Format
     * First and only argument of input is an even number A.
     *
     *
     *
     * Output Format
     * Return a integer array of size 2 containing primes whose sum will be equal to given number.
     *
     *
     *
     * Example Input
     *  4
     *
     *
     * Example Output
     *  [2, 2]
     *
     *
     * Example Explanation
     *  There is only 1 solution for A = 4.
     */

    public int[] primesum(int A) {
        boolean[] primes = new boolean[A+1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for(int index = 2; index <= (int)Math.sqrt(A); index++) {
            if(primes[index]) {
                for(int j = index*index; j <= A; j = j+index) {
                    primes[j] = false;
                }
            }
        }

        for(int index = 0; index < primes.length; index++) {
            if(primes[index] && primes[A-index]) {
                return new int[] {index, A-index};
            }
        }

        return new int[]{0, 0};
    }
}
