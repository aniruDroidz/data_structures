package org.anirudroids._04_introduction_to_problem_solving.problems.mandatory;

public class Q2_IsPrime {
    /**
     * Problem Description
     * Given a number A. Return 1 if A is prime and return 0 if not.
     *
     * Note :
     * The value of A can cross the range of Integer.
     *
     *
     * Problem Constraints
     * 1 <= A <= 109
     *
     *
     * Input Format
     * The first argument is a single integer A.
     *
     *
     * Output Format
     * Return 1 if A is prime else return 0.
     *
     *
     * Example Input
     * Input 1:
     * A = 5
     * Input 2:
     *
     * A = 10
     *
     *
     * Example Output
     * Output 1:
     * 1
     * Output 2:
     *
     * 0
     *
     *
     * Example Explanation
     * Explanation 1:
     * 5 is a prime number.
     * Explanation 2:
     *
     * 10 is not a prime number.
     */

    public int solve(int A) {
        boolean isPrime = A == 1 ? false : true;
        for(int index = 2; index <= A/2; index++) {
            if(A % index == 0) {
                isPrime = false;
            }
        }
        return isPrime ? 1 : 0;
    }
}
