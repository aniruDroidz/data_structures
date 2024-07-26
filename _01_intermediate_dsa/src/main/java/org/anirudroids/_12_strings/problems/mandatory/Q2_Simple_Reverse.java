package org.anirudroids._12_strings.problems.mandatory;

public class Q2_Simple_Reverse {
    /**
     * Problem Description
     * Given a string A, you are asked to reverse the string and return the reversed string.
     *
     *
     *
     * Problem Constraints
     * 1 <= |A| <= 105
     *
     * String A consist only of lowercase characters.
     *
     *
     *
     * Input Format
     * First and only argument is a string A.
     *
     *
     *
     * Output Format
     * Return a string denoting the reversed string.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = "scaler"
     * Input 2:
     *
     *  A = "academy"
     *
     *
     * Example Output
     * Output 1:
     *
     *  "relacs"
     * Output 2:
     *
     *  "ymedaca"
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  Reverse the given string.
     */

    public String solve(String A) {
        char[] charArray = A.toCharArray();
        for(int index = 0; index < charArray.length/2; index++) {
            char temp = charArray[index];
            charArray[index] = charArray[charArray.length - 1 - index];
            charArray[charArray.length - 1 - index] = temp;
        }
        return new String(charArray);
    }
}
