package org.anirudroids._52_nearest_smaller_and_basics_problems.problems.mandatory;

import java.util.Stack;

public class Q2_Largest_Rectangle_in_Histogram {
    /**
     * Problem Description
     * Given an array of integers A.
     *
     * A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.
     *
     * Find the area of the largest rectangle formed by the histogram.
     *
     *
     *
     * Problem Constraints
     * 1 <= |A| <= 100000
     *
     * 1 <= A[i] <= 10000
     *
     *
     *
     * Input Format
     * The only argument given is the integer array A.
     *
     *
     *
     * Output Format
     * Return the area of the largest rectangle in the histogram.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [2, 1, 5, 6, 2, 3]
     * Input 2:
     *
     *  A = [2]
     *
     *
     * Example Output
     * Output 1:
     *
     *  10
     * Output 2:
     *
     *  2
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     * The largest rectangle has area = 10 unit. Formed by A[3] to A[4].
     * Explanation 2:
     *
     * Largest rectangle has area 2.
     */

    public int largestRectangleArea(int[] A) {
        Stack<Integer> stack = new Stack<>();

        int[] nsl = getNsl(A);
        int[] nsr = getNsr(A);

        int max = 0;
        for(int i = 0; i < A.length; i++) {
            int j = nsl[i];
            int k = nsr[i];

            int area = (k-j-1) * A[i];
            max = Math.max(area, max);
        }

        return max;
    }

    private int[] getNsl(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[A.length];

        for(int i = 0; i < A.length; i++) {
            while(!stack.isEmpty() && A[i] <= A[stack.peek()]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(i);
        }

        return result;
    }

    private int[] getNsr(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[A.length];

        for(int i = A.length-1; i >= 0; i--) {
            while(!stack.isEmpty() && A[i] <= A[stack.peek()]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                result[i] = A.length;
            } else {
                result[i] = stack.peek();
            }
            stack.push(i);
        }

        return result;
    }
}
