package org.anirudroids._45_two_pointers.problems.additional;

public class Q5_Array_3_Pointers {
    /**
     * Problem Description
     * You are given 3 sorted arrays A, B and C.
     *
     * Find i, j, k such that : max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
     *
     * Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])).
     *
     *
     *
     * Problem Constraints
     * 1 <= len(A), len(B), len(c) <= 106
     *
     * 0 <= A[i], B[i], C[i] <= 107
     *
     *
     *
     * Input Format
     * First argument is an integer array A.
     *
     * Second argument is an integer array B.
     *
     * Third argument is an integer array C.
     *
     *
     *
     * Output Format
     * Return an single integer denoting the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])).
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [1, 4, 10]
     *  B = [2, 15, 20]
     *  C = [10, 12]
     * Input 2:
     *
     *  A = [3, 5, 6]
     *  B = [2]
     *  C = [3, 4]
     *
     *
     * Example Output
     * Output 1:
     *
     *  5
     * Output 2:
     *
     *  1
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  With 10 from A, 15 from B and 10 from C.
     * Explanation 2:
     *
     *  With 3 from A, 2 from B and 3 from C.
     */

    public int minimize(final int[] A, final int[] B, final int[] C) {
        int i = 0;
        int j = 0;
        int k = 0;

        int result = Integer.MAX_VALUE;
        while(i < A.length && j < B.length && k < C.length) {
            int min = Math.min(A[i], Math.min(B[j], C[k]));
            int max = Math.max(A[i], Math.max(B[j], C[k]));
            int difference = max - min;

            if(difference < result) {
                result = difference;
            }

            if(min == A[i]) {
                i++;
            } else if(min == B[j]) {
                j++;
            } else if(min == C[k]) {
                k++;
            }
        }

        return result;
    }
}
