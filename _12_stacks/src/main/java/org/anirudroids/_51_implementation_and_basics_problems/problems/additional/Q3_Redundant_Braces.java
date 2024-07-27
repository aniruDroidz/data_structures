package org.anirudroids._51_implementation_and_basics_problems.problems.additional;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q3_Redundant_Braces {
    /**
     * Problem Description
     * Given a string A denoting an expression. It contains the following operators '+', '-', '*', '/'.
     *
     * Check whether A has redundant braces or not.
     *
     * NOTE: A will be always a valid expression and will not contain any white spaces.
     *
     *
     *
     * Problem Constraints
     * 1 <= |A| <= 105
     *
     *
     *
     * Input Format
     * The only argument given is string A.
     *
     *
     *
     * Output Format
     * Return 1 if A has redundant braces else, return 0.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = "((a+b))"
     * Input 2:
     *
     *  A = "(a+(a+b))"
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
     *  ((a+b)) has redundant braces so answer will be 1.
     * Explanation 2:
     *
     *  (a+(a+b)) doesn't have have any redundant braces so answer will be 0.
     */

    public int braces(String A) {
        Stack<Character> stack = new Stack<>();

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');

        for(int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);

            switch(ch) {
                case ')':
                    if(!stack.isEmpty() && stack.peek() == map.get(ch)) {
                        return 1;
                    } else {
                        while(!stack.isEmpty() && stack.peek() != map.get(ch)) {
                            stack.pop();
                        }
                        stack.pop();
                    }
                    break;
                case '(':
                case '+':
                case '-':
                case '*':
                case '/':
                    stack.push(ch);
                    break;
            }
        }

        return 0;
    }
}
