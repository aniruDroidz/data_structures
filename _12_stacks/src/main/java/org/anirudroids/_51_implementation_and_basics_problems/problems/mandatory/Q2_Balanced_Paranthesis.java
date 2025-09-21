package org.anirudroids._51_implementation_and_basics_problems.problems.mandatory;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q2_Balanced_Paranthesis {
    /**
     * Problem Description
     * Given an expression string A, examine whether the pairs and the orders 
of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.
     *
     * Refer to the examples for more clarity.
     *
     *
     *
     * Problem Constraints
     * 1 <= |A| <= 100
     *
     *
     *
     * Input Format
     * The first and the only argument of input contains the string A having 
the parenthesis sequence.
     *
     *
     *
     * Output Format
     * Return 0 if the parenthesis sequence is not balanced.
     *
     * Return 1 if the parenthesis sequence is balanced.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = {([])}
     * Input 2:
     *
     *  A = (){
     * Input 3:
     *
     *  A = ()[]
     *
     *
     * Example Output
     * Output 1:
     *
     *  1
     * Output 2:
     *
     *  0
     * Output 3:
     *
     *  1
     */

    public int solve(String A) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();

        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');

        for(int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            switch(ch){
                case '{':
                case '[':
                case '(':
                    stack.push(ch);
                    break;
                default:
                    if(stack.isEmpty()) {
                        return 0;
                    }
                    char top =(char) stack.peek();
                    if(top == map.get(ch)) {
                        stack.pop();
                    } else {
                        return 0;
                    }
                    break;
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
