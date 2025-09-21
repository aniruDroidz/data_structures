package org.anirudroids._52_nearest_smaller_and_basics_problems.problems.mandatory;

import java.util.Stack;

public class Q3_MAX_and_MIN {
    /**
     * Problem Description
     * Given an array of integers A.
     *
     * The value of an array is computed as the difference between the maximum
 element in the array and the minimum element in the array A.
     *
     * Calculate and return the sum of values of all possible subarrays of 
A modulo 109+7.
     *
     *
     *
     * Problem Constraints
     * 1 <= |A| <= 100000
     *
     * 1 <= A[i] <= 1000000
     *
     *
     *
     * Input Format
     * The first and only argument given is the integer array A.
     *
     *
     *
     * Output Format
     * Return the sum of values of all possible subarrays of A modulo 109+7.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [1]
     * Input 2:
     *
     *  A = [4, 7, 3, 8]
     *
     *
     * Example Output
     * Output 1:
     *
     *  0
     * Output 2:
     *
     *  26
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     * Only 1 subarray exists. Its value is 0.
     * Explanation 2:
     *
     * value ( [4] ) = 4 - 4 = 0
     * value ( [7] ) = 7 - 7 = 0
     * value ( [3] ) = 3 - 3 = 0
     * value ( [8] ) = 8 - 8 = 0
     * value ( [4, 7] ) = 7 - 4 = 3
     * value ( [7, 3] ) = 7 - 3 = 4
     * value ( [3, 8] ) = 8 - 3 = 5
     * value ( [4, 7, 3] ) = 7 - 3 = 4
     * value ( [7, 3, 8] ) = 8 - 3 = 5
     * value ( [4, 7, 3, 8] ) = 8 - 3 = 5
     * sum of values % 10^9+7 = 26
     */

    public int solve(int[] A) {
        int mod = 1000000007;

        int[] nsl = getNsl(A);
        int[] nsr = getNsr(A);
        int[] ngl = getNgl(A);
        int[] ngr = getNgr(A);

        long ans = 0;
        for(int i = 0; i < A.length; i++) {
            long maximum = (long) (i - (ngl[i] + 1) + 1) * ((ngr[i] - 1) - i + 1) % mod;
            long minimum = (long) (i - (nsl[i] + 1) + 1) * ((nsr[i] - 1) - i + 1) % mod;

            ans += (maximum % mod - minimum % mod) * A[i]%mod;
        }

        return (int)(ans%mod+mod)%mod;
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

    private int[] getNgl(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[A.length];

        for(int i = 0; i < A.length; i++) {
            while(!stack.isEmpty() && A[i] >= A[stack.peek()]) {
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

    private int[] getNgr(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[A.length];

        for(int i = A.length-1; i >= 0; i--) {
            while(!stack.isEmpty() && A[i] >= A[stack.peek()]) {
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
