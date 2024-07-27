package org.anirudroids._4_recursion._26_recursion_1.problems.additional;

public class Q2_Print_A_to_1_function {
    /**
     * Problem Description
     * You are given an integer A, print A to 1 using using recursion.
     *
     * Note :- After printing all the numbers from A to 1, print a new line.
     *
     *
     *
     * Problem Constraints
     * 1 <= A <= 104
     *
     *
     *
     * Input Format
     * First argument A is an integer.
     *
     *
     *
     * Output Format
     * Print A space-separated integers A to 1.
     * Note: There should be exactly one space after each integer. Print a new line after printing the A integers
     *
     *
     *
     * Example Input
     * Input 1:
     *
     * 10
     * Input 2:
     *
     * 5
     *
     *
     * Example Output
     * Output 1:
     *
     * 10 9 8 7 6 5 4 3 2 1
     * Output 2:
     *
     * 5 4 3 2 1
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     * Print 10 to 1 space separated integers.
     * Explanation 2:
     *
     * Print 5 to 1 space separated integers.
     */

    public void printElements(int A) {
        if(A == 0) {
            return;
        }

        System.out.print(A + " ");
        printElements(A - 1);
    }

    public void solve(int A) {
        printElements(A);

        System.out.println();
    }
}
