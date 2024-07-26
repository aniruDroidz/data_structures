package org.anirudroids._12_strings.problems.mandatory;

public class Q1_Toggle_Case {
    /**
     * Problem Description
     * You are given a character string A having length N, consisting of only lowercase and uppercase latin letters.
     *
     * You have to toggle case of each character of string A. For e.g 'A' is changed to 'a', 'e' is changed to 'E', etc.
     *
     *
     *
     * Problem Constraints
     * 1 <= N <= 105
     *
     * A[i] ∈ ['a'-'z', 'A'-'Z']
     *
     *
     *
     * Input Format
     * First and only argument is a character string A.
     *
     *
     *
     * Output Format
     * Return a character string.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = "Hello"
     * Input 2:
     *
     *  A = "tHiSiSaStRiNg"
     *
     *
     * Example Output
     * Output 1:
     *
     *  hELLO
     * Output 2:
     *
     *  ThIsIsAsTrInG
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  'H' changes to 'h'
     *  'e' changes to 'E'
     *  'l' changes to 'L'
     *  'l' changes to 'L'
     *  'o' changes to 'O'
     * Explanation 2:
     *
     *  "tHiSiSaStRiNg" changes to "ThIsIsAsTrInG".
     */

    public String solve(String A) {
        char[] charArray = A.toCharArray();

        for(int index = 0; index < charArray.length; index++) {
            char ch = charArray[index];
            if(ch >= 65 && ch <= 90) {
                charArray[index] = (char)(ch + 32);
            } else if(ch >= 97 && ch <= 122) {
                charArray[index] = (char)(ch - 32);
            }
        }

        return new String(charArray);
    }
}
