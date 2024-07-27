package org.anirudroids._44_backtracking.problems.mandatory;

public class Q1_Generate_all_Parentheses_II {
    /**
     * Problem Description
     * Given an integer A pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*A.
     *
     *
     *
     * Problem Constraints
     * 1 <= A <= 10
     *
     *
     *
     * Input Format
     * First and only argument is integer A.
     *
     *
     *
     * Output Format
     * Return a sorted list of all possible parenthesis.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     * A = 3
     * Input 2:
     *
     * A = 1
     *
     *
     * Example Output
     * Output 1:
     *
     * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
     * Output 2:
     *
     * [ "()" ]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  All paranthesis are given in the output list.
     * Explanation 2:
     *
     *  All paranthesis are given in the output list.
     */

    private String[] result;
    private int index;
    public String[] generateParenthesis(int A) {
        result = new String[A*2];

        generate(new StringBuilder(), 0, 0, A);
        return result;
    }

    private void generate(StringBuilder curr, int countOpen, int countClose, int n) {
        if(countClose == n && countOpen == n) {
            result[index++] = curr.toString();
            return;
        }

        if(countOpen > n && countClose > countOpen) {
            return;
        }

        if(countOpen < n) {
            curr.append("(");
            generate(curr, countOpen + 1, countClose, n);
            curr.deleteCharAt(curr.length() - 1);
        }

        if(countClose < countOpen) {
            curr.append(")");
            generate(curr, countOpen, countClose + 1, n);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
