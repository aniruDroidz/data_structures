package org.anirudroids._51_implementation_and_basics_problems.problems.additional;

import java.util.Arrays;
import java.util.Stack;

public class Q4_Check_two_bracket_expressions {
    /**
     * Problem Description
     * Given two strings A and B. Each string represents an expression consisting of lowercase English alphabets, '+', '-', '(' and ')'.
     *
     * The task is to compare them and check if they are similar. If they are identical, return 1 else, return 0.
     *
     * NOTE: It may be assumed that there are at most 26 operands from ‘a’ to ‘z’, and every operand appears only once.
     *
     *
     *
     * Problem Constraints
     * 1 <= length of the each String <= 100
     *
     *
     *
     * Input Format
     * The given arguments are string A and string B.
     *
     *
     *
     * Output Format
     * Return 1 if they represent the same expression else return 0.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = "-(a+b+c)"
     *  B = "-a-b-c"
     * Input 2:
     *
     *  A = "a-b-(c-d)"
     *  B = "a-b-c-d"
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
     *  The expression "-(a+b+c)" can be written as "-a-b-c" which is equal as B.
     * Explanation 2:
     *
     *  Both the expression are different.
     */

    public int solve(String A, String B) {
        char[] ch1 = new char[26];
        char[] ch2 = new char[26];

        Stack<Character> stack1 = new Stack<>();
        char sign = '+';
        stack1.push(sign);

        for(int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            switch(ch) {
                case '(':
                    if(!stack1.isEmpty() && stack1.peek() == sign) {
                        stack1.push('+');
                    } else {
                        stack1.push('-');
                    }
                    sign = '+';
                    break;
                case ')':
                    stack1.pop();
                    break;
                case '+':
                case '-':
                    sign = ch;
                    break;
                default:
                    if(!stack1.isEmpty() && stack1.peek() == sign) {
                        ch1[ch-'a'] = '+';
                    } else {
                        ch1[ch-'a'] = '-';
                    }
                    break;
            }
        }
        stack1 = new Stack<>();
        sign = '+';
        stack1.push(sign);
        for(int i = 0; i < B.length(); i++) {
            char ch = B.charAt(i);
            switch(ch) {
                case '(':
                    if(!stack1.isEmpty() && stack1.peek() == sign) {
                        stack1.push('+');
                    } else {
                        stack1.push('-');
                    }
                    sign = '+';
                    break;
                case ')':
                    stack1.pop();
                    break;
                case '+':
                case '-':
                    sign = ch;
                    break;
                default:
                    if(!stack1.isEmpty() && stack1.peek() == sign) {
                        ch2[ch-'a'] = '+';
                    } else {
                        ch2[ch-'a'] = '-';
                    }
                    break;
            }
        }

        return Arrays.equals(ch1, ch2) ? 1 : 0;
    }
}
