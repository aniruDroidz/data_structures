package org.anirudroids._42_binary_search_problems.problems.additional;

import java.util.Arrays;

public class Q1_ADD_OR_NOT {
    /**
     * Problem Description
     * Given an array of integers A of size N and an integer B.
     *
     * In a single operation, any one element of the array can be increased by 1. You are allowed to do at most B such operations.
     *
     * Find the number with the maximum number of occurrences and return an array C of size 2, where C[0] is the number of occurrences, and C[1] is the number with maximum occurrence.
     * If there are several such numbers, your task is to find the minimum one.
     *
     *
     *
     * Problem Constraints
     * 1 <= N <= 105
     *
     * -109 <= A[i] <= 109
     *
     * 0 <= B <= 109
     *
     *
     *
     * Input Format
     * The first argument given is the integer array A.
     * The second argument given is the integer B.
     *
     *
     *
     * Output Format
     * Return an array C of size 2, where C[0] is number of occurence and C[1] is the number with maximum occurence.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [3, 1, 2, 2, 1]
     *  B = 3
     * Input 2:
     *
     *  A = [5, 5, 5]
     *  B = 3
     *
     *
     * Example Output
     * Output 1:
     *
     *  [4, 2]
     * Output 2:
     *
     *  [3, 5]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  Apply operations on A[2] and A[4]
     *  A = [3, 2, 2, 2, 2]
     *  Maximum occurence =  4
     *  Minimum value of element with maximum occurence = 2
     * Explanation 2:
     *
     *  A = [5, 5, 5]
     *  Maximum occurence =  3
     *  Minimum value of element with maximum occurence = 5
     */

    public int[] solve(int[] A, int B) {
        Arrays.sort(A);
        long[] prefixSum = new long[A.length + 1];
        for(int i = 0; i < A.length; i++) {
            prefixSum[i+1] += prefixSum[i] + A[i];
        }

        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;

        for(int i = 0; i < A.length; i++) {

            int s = 1;
            int e = i+1;

            int max = 0;
            while(s <= e) {
                int mid = (e-s)/2 + s;

                if(check(mid, B, A, i, prefixSum)) {
                    max = mid;
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }

            if(ans[0] < max) {
                ans[0] = max;
                ans[1] = A[i];
            }
        }

        return ans;
    }

    private boolean check(int count, int B, int[] A, int i, long[] prefixSum) {
        return (count * (long) A[i]) - (prefixSum[i + 1] - prefixSum[i - count + 1]) <= B;
    }
}
