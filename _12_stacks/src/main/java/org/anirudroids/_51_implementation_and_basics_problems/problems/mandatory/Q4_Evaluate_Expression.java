package org.anirudroids._51_implementation_and_basics_problems.problems.mandatory;

import java.util.Stack;

public class Q4_Evaluate_Expression {
    /**
     * Problem Description
     * An arithmetic expression is given by a string array A of size N. 
Evaluate the value of an arithmetic expression in Reverse Polish Notation.
     *
     * Valid operators are +, -, *, /. Each string may be an integer or an 
operator.
     *
     * Note: Reverse Polish Notation is equivalent to Postfix Expression, 
where operators are written after their operands.
     *
     *
     *
     * Problem Constraints
     * 1 <= N <= 105
     *
     *
     *
     * Input Format
     * The only argument given is string array A.
     *
     *
     *
     * Output Format
     * Return the value of arithmetic expression formed using reverse Polish 
Notation.
     *
     *
     *
     * Example Input
     * Input 1:
     * A =   ["2", "1", "+", "3", "*"]
     * Input 2:
     * A = ["4", "13", "5", "/", "+"]
     *
     *
     * Example Output
     * Output 1:
     * 9
     * Output 2:
     * 6
     *
     *
     * Example Explanation
     * Explaination 1:
     * starting from backside:
     *     * : () * ()
     *     3 : () * (3)
     *     + : (() + ()) * (3)
     *     1 : (() + (1)) * (3)
     *     2 : ((2) + (1)) * (3)
     *     ((2) + (1)) * (3) = 9
     * Explaination 2:
     * starting from backside:
     *     + : () + ()
     *     / : () + (() / ())
     *     5 : () + (() / (5))
     *     13 : () + ((13) / (5))
     *     4 : (4) + ((13) / (5))
     *     (4) + ((13) / (5)) = 6
     */
    public int evalRPN(String[] A) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < A.length; i++) {
            String str = A[i];
            switch(str) {
                case "+": {
                    int first = (int)stack.pop();
                    int second = (int)stack.pop();

                    int res = second + first;
                    stack.push(res);
                }
                break;

                case "-": {
                    int first = (int)stack.pop();
                    int second = (int)stack.pop();

                    int res = second - first;
                    stack.push(res);
                }
                break;

                case "*": {
                    int first = (int)stack.pop();
                    int second = (int)stack.pop();

                    int res = second * first;
                    stack.push(res);
                }
                break;

                case "/": {
                    int first = (int)stack.pop();
                    int second = (int)stack.pop();

                    int res = second / first;
                    stack.push(res);
                }
                break;

                default:
                    stack.push(Integer.parseInt(str));
                    break;
            }
        }

        return (int)stack.pop();
    }

}
