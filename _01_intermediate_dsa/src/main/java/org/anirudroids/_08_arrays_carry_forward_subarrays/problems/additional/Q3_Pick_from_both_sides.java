package org.anirudroids._08_arrays_carry_forward_subarrays.problems.additional;

public class Q3_Pick_from_both_sides {
    /**
     * Problem Description
     * You are given an integer array A of size N.
     *
     * You have to perform B operations. In one operation, you can remove either the leftmost or the rightmost element of the array A.
     *
     * Find and return the maximum possible sum of the B elements that were removed after the B operations.
     *
     * NOTE: Suppose B = 3, and array A contains 10 elements, then you can:
     *
     * Remove 3 elements from front and 0 elements from the back, OR
     * Remove 2 elements from front and 1 element from the back, OR
     * Remove 1 element from front and 2 elements from the back, OR
     * Remove 0 elements from front and 3 elements from the back.
     *
     *
     * Problem Constraints
     * 1 <= N <= 105
     *
     * 1 <= B <= N
     *
     * -103 <= A[i] <= 103
     *
     *
     *
     * Input Format
     * First argument is an integer array A.
     *
     * Second argument is an integer B.
     *
     *
     *
     * Output Format
     * Return an integer denoting the maximum possible sum of elements you removed.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [5, -2, 3 , 1, 2]
     *  B = 3
     * Input 2:
     *
     *  A = [ 2, 3, -1, 4, 2, 1 ]
     *  B = 4
     *
     *
     * Example Output
     * Output 1:
     *
     *  8
     * Output 2:
     *
     *  9
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  Remove element 5 from front and element (1, 2) from back so we get 5 + 1 + 2 = 8
     * Explanation 2:
     *
     *  Remove the first element and the last 3 elements. So we get 2 + 4 + 2 + 1 = 9
     */

    public int solve(int[] A, int B) {
        int max = Integer.MIN_VALUE;
        int n = A.length;
        int[] prefixSum = new int[n];
        int[] suffixSum = new int[n];

        prefixSum[0] = A[0];
        suffixSum[n-1] = A[n-1];
        for(int index = 1; index < n; index++) {
            prefixSum[index] = prefixSum[index - 1] + A[index];
            suffixSum[n-1-index] = suffixSum[n-1-index+1] + A[n-1-index];
        }

        if(prefixSum[B-1] > suffixSum[n-B]) {
            max = prefixSum[B-1];
        } else {
            max = suffixSum[n-B];
        }

        for(int index = 1; index < B; index++) {
            int sum = prefixSum[index - 1] + suffixSum[n-(B-index)];
            if(max < sum) {
                max = sum;
            }
        }

        return max;
    }
}
