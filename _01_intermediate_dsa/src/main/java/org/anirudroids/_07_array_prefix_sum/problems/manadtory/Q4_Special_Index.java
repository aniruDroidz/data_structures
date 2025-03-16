package org.anirudroids._07_array_prefix_sum.problems.manadtory;

public class Q4_Special_Index {
    /**
     * Problem Description
     * Given an array, arr[] of size N, the task is to find the count of array indices such that removing an element 
     * from these indices makes the sum of even-indexed and odd-indexed array elements equal.
     *
     *
     *
     * Problem Constraints
     * 1 <= N <= 105
     * -105 <= A[i] <= 105
     * Sum of all elements of A <= 109
     *
     *
     * Input Format
     * First argument contains an array A of integers of size N
     *
     *
     * Output Format
     * Return the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.
     *
     *
     *
     * Example Input
     * Input 1:
     * A = [2, 1, 6, 4]
     * Input 2:
     *
     * A = [1, 1, 1]
     *
     *
     * Example Output
     * Output 1:
     * 1
     * Output 2:
     *
     * 3
     *
     *
     * Example Explanation
     * Explanation 1:
     * Removing arr[1] from the array modifies arr[] to { 2, 6, 4 } such that, arr[0] + arr[2] = arr[1].
     * Therefore, the required output is 1.
     * Explanation 2:
     *
     * Removing arr[0] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
     * Removing arr[1] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
     * Removing arr[2] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
     * Therefore, the required output is 3.
     */

    public int solve(int[] A) {
        int n = A.length;
        int count = 0;

        long[] evenSum = new long[n];
        long[] oddSum = new long[n];
        for(int index = 0; index < n; index++) {
            if(index % 2 == 0) {
                if(index == 0) {
                    evenSum[index] = A[index];
                    oddSum[index] = 0;
                } else {
                    evenSum[index] = evenSum[index - 1] + A[index];
                    oddSum[index] = oddSum[index - 1];
                }
            } else {
                oddSum[index] = oddSum[index - 1] + A[index];
                evenSum[index] = evenSum[index - 1];
            }
        }

        for(int index = 0; index < n; index++) {
            long sumOfEven = 0;
            long sumOfOdd = 0;

            if(index == 0) {
                sumOfEven = oddSum[n - 1] - oddSum[index];
                sumOfOdd = evenSum[n - 1] - evenSum[index];
            } else {
                sumOfEven = evenSum[index - 1] + oddSum[n - 1] - oddSum[index];
                sumOfOdd = oddSum[index - 1] + evenSum[n - 1] - evenSum[index];
            }

            if(sumOfEven == sumOfOdd) {
                count++;
            }
        }

        return count;
    }
}
