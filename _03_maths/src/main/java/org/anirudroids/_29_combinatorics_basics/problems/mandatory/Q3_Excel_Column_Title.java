package org.anirudroids._29_combinatorics_basics.problems.mandatory;

public class Q3_Excel_Column_Title {
    /**
     * Problem Description
     * Given a positive integer A, return its corresponding column title as it appears in an Excel sheet.
     *
     * For example:
     *
     *     1 -> A
     *     2 -> B
     *     3 -> C
     *     ...
     *     26 -> Z
     *     27 -> AA
     *     28 -> AB
     *
     *
     * Problem Constraints
     * 1 <= A <= 109
     *
     *
     *
     * Input Format
     * First and only argument of input contains single integer A
     *
     *
     *
     * Output Format
     * Return a string denoting the corresponding title.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     * A = 3
     * Input 2:
     *
     *
     * A = 27
     *
     *
     * Example Output
     * Output 1:
     *
     * "C"
     * Output 2:
     *
     * "AA"
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *
     * 3 corrseponds to C.
     * Explanation 2:
     *
     *     1 -> A,
     *     2 -> B,
     *     3 -> C,
     *     ...
     *     26 -> Z,
     *     27 -> AA,
     *     28 -> AB
     */

    public String convertToTitle(int A) {
        StringBuilder builder = new StringBuilder();
        if(A <= 26) {
            builder.append((char)(A + 64));
            return builder.toString();
        }
        while(A > 0) {
            if(A <= 26) {
                builder.append((char)(A + 64));
                break;
            }
            int modulo = A%26;
            char secondChar = (char)((modulo == 0 ? 26 : modulo) + 64);
            builder.append(secondChar);
            A = A/26;
            if(modulo == 0) {
                A = A-1;
            }
        }

        return builder.reverse().toString();
    }
}
