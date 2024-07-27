package org.anirudroids._44_backtracking.problems.mandatory;

import java.util.Arrays;

public class Q2_Permutations {
    /**
     * Problem Description
     * Given an integer array A of size N denoting collection of numbers , return all possible permutations.
     *
     * NOTE:
     *
     * No two entries in the permutation sequence should be the same.
     * For the purpose of this problem, assume that all the numbers in the collection are unique.
     * Return the answer in any order
     * WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
     * Example : next_permutations in C++ / itertools.permutations in python.
     * If you do, we will disqualify your submission retroactively and give you penalty points.
     *
     *
     * Problem Constraints
     * 1 <= N <= 9
     *
     *
     *
     * Input Format
     * Only argument is an integer array A of size N.
     *
     *
     *
     * Output Format
     * Return a 2-D array denoting all possible permutation of the array.
     *
     *
     *
     * Example Input
     * A = [1, 2, 3]
     *
     *
     * Example Output
     * [ [1, 2, 3]
     *   [1, 3, 2]
     *   [2, 1, 3]
     *   [2, 3, 1]
     *   [3, 1, 2]
     *   [3, 2, 1] ]
     *
     *
     * Example Explanation
     * All the possible permutation of array [1, 2, 3].
     */
    private int[][] result;
    int i = 0;

    public int[][] permute(int[] A) {
        result = new int[factorial(A.length)][A.length];
        solve(A, 0, new int[A.length], new boolean[A.length]);
        return result;
    }

    private int factorial(int n) {
        if(n == 0) {
            return 1;
        }

        return factorial(n-1) * n;
    }

    private void solve(int[] A, int index, int[] ans, boolean[] visited) {
        if(index == ans.length) {
            result[i++] = Arrays.copyOf(ans, ans.length);
            return;
        }

        for(int j = 0; j < A.length; j++) {
            if(!visited[j]) {
                visited[j] = true;
                ans[index] = A[j];
                solve(A, index+1, ans, visited);
                visited[j] = false;
            }
        }
    }

}
