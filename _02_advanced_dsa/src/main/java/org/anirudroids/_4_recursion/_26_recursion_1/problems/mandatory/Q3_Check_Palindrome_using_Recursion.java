package org.anirudroids._4_recursion._26_recursion_1.problems.mandatory;

public class Q3_Check_Palindrome_using_Recursion {
    /**
     * Problem Description
     * Write a recursive function that checks whether string A is a palindrome or Not.
     * Return 1 if the string A is a palindrome, else return 0.
     *
     * Note: A palindrome is a string that's the same when read forward and backward.
     *
     *
     *
     * Problem Constraints
     * 1 <= |A| <= 50000
     *
     * String A consists only of lowercase letters.
     *
     *
     *
     * Input Format
     * The first and only argument is a string A.
     *
     *
     *
     * Output Format
     * Return 1 if the string A is a palindrome, else return 0.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = "naman"
     * Input 2:
     *
     *  A = "strings"
     *
     *
     * Example Output
     * Output 1:
     *
     *  1
     * Output 2:
     *
     *  0
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  "naman" is a palindomic string, so return 1.
     * Explanation 2:
     *
     *  "strings" is not a palindrome, so return 0.
     */

    public int solve(String A) {
        if(A.length() == 2) {
            if(A.charAt(0) == A.charAt(1)) {
                return 1;
            } else {
                return 0;
            }
        } else if(A.length() == 3) {
            if(A.charAt(0) == A.charAt(2)) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return solve(A.substring(1, A.length() - 1));
        }
    }
}
