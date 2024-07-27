package org.anirudroids._52_nearest_smaller_and_basics_problems.problems.additional;

import java.util.ArrayList;
import java.util.Stack;

public class Q3_Sort_stack_using_another_stack {
    /**
     * Problem Description
     * Given a stack of integers A, sort it using another stack.
     *
     * Return the array of integers after sorting the stack using another stack.
     *
     *
     *
     * Problem Constraints
     * 1 <= |A| <= 5000
     *
     * 0 <= A[i] <= 109
     *
     *
     *
     * Input Format
     * The only argument is a stack given as an integer array A.
     *
     *
     *
     * Output Format
     * Return the array of integers after sorting the stack using another stack.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [5, 4, 3, 2, 1]
     * Input 2:
     *
     *  A = [5, 17, 100, 11]
     *
     *
     * Example Output
     * Output 1:
     *
     *  [1, 2, 3, 4, 5]
     * Output 2:
     *
     *  [5, 11, 17, 100]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  Just sort the given numbers.
     * Explanation 2:
     *
     *  Just sort the given numbers.
     */

    public ArrayList<Integer> solve(ArrayList<Integer> A) {

        ArrayList<Integer> result = new ArrayList<>();
        for (Integer integer : A) {
            Stack<Integer> stack = new Stack<>();

            while (!result.isEmpty() && result.get(result.size() - 1) > integer) {
                stack.push(result.remove(result.size() - 1));
            }
            result.add(integer);
            while (!stack.isEmpty()) {
                result.add(stack.pop());
            }
        }

        return result;
    }
}
