package org.anirudroids._28_modular_arithmetic_and_gcd.problems.mandatory;

public class Q3_Trailing_Zeros_in_Factorial {
    /**
     * Problem Description
     * Given an integer A, return the number of trailing zeroes in A! i.e., factorial of A.
     *
     * Note: Your solution should run in logarithmic time complexity.
     *
     *
     *
     * Problem Constraints
     * 1 <= A <= 109
     *
     *
     *
     * Input Format
     * First and only argument is a single integer A.
     *
     *
     *
     * Output Format
     * Return a single integer denoting number of zeroes.
     *
     *
     *
     * Example Input
     * Input 1
     *
     *  A = 5
     * Input 2:
     *
     *  A = 6
     *
     *
     * Example Output
     * Output 1:
     *
     *  1
     * Output 2:
     *
     *  1
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  A! = 120.
     *  Number of trailing zeros = 1. So, return 1.
     * Explanation 2:
     *
     *  A! = 720
     *  Number of trailing zeros = 1. So, return 1.
     */

    public int trailingZeroes(int A) {
        int power = 1;
        int currentDiviser = (int)Math.pow(5, power++);
        int currentResult = A/currentDiviser;
        int count = currentResult;
        while(currentResult > 0) {
            currentResult = A/((int)Math.pow(5, power++));
            count += currentResult;
        }
        return count;
    }
}
