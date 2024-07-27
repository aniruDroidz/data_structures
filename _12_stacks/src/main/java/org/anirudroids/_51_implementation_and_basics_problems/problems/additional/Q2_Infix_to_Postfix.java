package org.anirudroids._51_implementation_and_basics_problems.problems.additional;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q2_Infix_to_Postfix {
    /**
     * Problem Description
     * Given string A denoting an infix expression. Convert the infix expression into a postfix expression.
     *
     * String A consists of ^, /, *, +, -, (, ) and lowercase English alphabets where lowercase English alphabets are operands and ^, /, *, +, - are operators.
     *
     * Find and return the postfix expression of A.
     *
     * NOTE:
     *
     * ^ has the highest precedence.
     * / and * have equal precedence but greater than + and -.
     * + and - have equal precedence and lowest precedence among given operators.
     *
     *
     * Problem Constraints
     * 1 <= length of the string <= 500000
     *
     *
     *
     * Input Format
     * The only argument given is string A.
     *
     *
     *
     * Output Format
     * Return a string denoting the postfix conversion of A.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = "x^y/(a*z)+b"
     * Input 2:
     *
     *  A = "a+b*(c^d-e)^(f+g*h)-i"
     *
     *
     * Example Output
     * Output 1:
     *
     *  "xy^az*///b+"
    /**Output 2:
     * "abcd^e-fgh*+^*+i-"
     */

    public String solve(String A) {
        StringBuilder builder = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        Map<Character, Integer> map = new HashMap<>();
        map.put('^', 3);
        map.put('/', 2);
        map.put('*', 2);
        map.put('+', 1);
        map.put('-', 1);

        for(int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);

            switch(ch) {
                case '^':
                case '/':
                case '*':
                case '+':
                case '-':
                    if(stack.isEmpty() || stack.peek() == '(' || map.get(ch) > map.get(stack.peek())) {
                        stack.push(ch);
                    } else if(map.get(ch) <= map.get(stack.peek())) {
                        while(!stack.isEmpty() && stack.peek() != '(' && map.get(ch) <= map.get(stack.peek())) {
                            builder.append(stack.pop());
                        }
                        stack.push(ch);
                    }
                    break;
                case '(':
                    stack.push(ch);
                    break;
                case ')':
                    while(!stack.isEmpty() && stack.peek() != '(') {
                        builder.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    builder.append(ch);
                    break;
            }
        }

        while(!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.toString();
    }
}
