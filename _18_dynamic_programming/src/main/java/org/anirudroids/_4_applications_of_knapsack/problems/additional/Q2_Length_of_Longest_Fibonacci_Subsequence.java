package org.anirudroids._4_applications_of_knapsack.problems.additional;

import java.util.HashMap;

public class Q2_Length_of_Longest_Fibonacci_Subsequence {
    /**
     * Problem Description
     * Given a strictly increasing array A of positive integers forming a sequence.
     *
     * A sequence X1, X2, X3, ..., XN is fibonacci like if
     *
     *
     * N > =3
     * Xi + Xi+1 = Xi+2 for all i+2 <= N
     * Find and return the length of the longest Fibonacci-like subsequence of A.
     *
     * If one does not exist, return 0.
     *
     * NOTE: A subsequence is derived from another sequence A by deleting any number of elements (including none) from A, without changing the order of the remaining elements.
     *
     *
     *
     * Problem Constraints
     * 3 <= length of the array <= 1000
     *
     * 1 <= A[i] <= 109
     *
     *
     *
     * Input Format
     * The only argument given is the integer array A.
     *
     *
     *
     * Output Format
     * Return the length of the longest Fibonacci-like subsequence of A.
     * If one does not exist, return 0.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [1, 2, 3, 4, 5, 6, 7, 8]
     * Input 2:
     *
     *  A = [1, 3, 7, 11, 12, 14, 18]
     *
     *
     * Example Output
     * Output 1:
     *
     *  5
     * Output 2:
     *
     *  3
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  The longest subsequence that is fibonacci-like: [1, 2, 3, 5, 8].
     * Explanation 2:
     *
     *  The longest subsequence that is fibonacci-like: [1, 11, 12], [3, 11, 14] or [7, 11, 18].
     *  The length will be 3.
     */

    public int solve(int[] A) {
        int n = A.length;
        int result = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            map.put(A[i],i);
        }

        int[][] dp = new int[n][n];

        for(int i=2; i<n; i++) {
            for(int j=i-1; j>=0; j--) {
                int diff = A[i]-A[j];
                if(map.containsKey(diff) && map.get(diff)<j) {
                    dp[i][j] = Math.max(dp[i][j], dp[j][map.get(diff)]+1);
                    result = Math.max(result, dp[i][j]);
                }
            }
        }

        return (result==0) ? 0 : result+2;
    }
}
