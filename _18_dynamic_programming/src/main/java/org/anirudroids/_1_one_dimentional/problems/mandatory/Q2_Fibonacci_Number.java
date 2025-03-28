package org.anirudroids._1_one_dimentional.problems.mandatory;

import java.util.Scanner;

public class Q2_Fibonacci_Number {
    /**
     * Problem Description
     * Given a positive integer A, write a program to find the Ath Fibonacci number.
     *
     * In a Fibonacci series, each term is the sum of the previous two terms and the first two terms of the series are 0 and 1. i.e. f(0) = 0 and f(1) = 1. Hence, f(2) = 1, f(3) = 2, f(4) = 3 and so on.
     *
     * NOTE: 0th term is 0. 1th term is 1 and so on.
     *
     *
     *
     * Problem Constraints
     * 0 <= A <= 44
     *
     *
     *
     * Input Format
     * First and only argument is an integer A.
     *
     *
     *
     * Output Format
     * Return an integer denoting the Ath Fibonacci number.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = 4
     * Input 2:
     *
     *  A = 6
     *
     *
     * Example Output
     * Output 1:
     *
     *  3
     * Output 2:
     *
     *  8
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  Terms of Fibonacci series are: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on.
     *  0th term is 0 So, 4th term of Fibonacci series is 3.
     * Explanation 2:
     *
     *  6th term of Fibonacci series is 8.
     */

    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output

        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();

        System.out.println(solve(input));
    }

    private static int solve(int A) {
        int fib1 = 0;
        int fib2 = 1;

        for(int index = 0; index <= A; index++) {
            int temp = fib1 + fib2;
            fib2 = fib1;
            fib1 = temp;
        }

        return fib2;
    }
}
