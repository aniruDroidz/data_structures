package org.anirudroids._06_introduction_to_arrays.problems.mandatory;

public class Q5_Max_Min_of_an_Array {
    /**
     * Problem Description
     * Given an array A of size N. You need to find the sum of Maximum and Minimum element in the given array.
     *
     *
     * Problem Constraints
     * 1 <= N <= 105
     * -109 <= A[i] <= 109
     *
     *
     * Input Format
     * First argument A is an integer array.
     *
     *
     * Output Format
     * Return the sum of maximum and minimum element of the array
     *
     *
     * Example Input
     * Input 1:
     *
     * A = [-2, 1, -4, 5, 3]
     * Input 2:
     *
     * A = [1, 3, 4, 1]
     *
     *
     * Example Output
     * Output 1:
     *
     * 1
     * Output 2:
     *
     * 5
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     * Maximum Element is 5 and Minimum element is -4. (5 + (-4)) = 1.
     * Explanation 2:
     *
     * Maximum Element is 4 and Minimum element is 1. (4 + 1) = 5.
     */

    public int solve(int[] A) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int index = 0; index < A.length; index++) {
            int element = A[index];
            if(max < element) {
                max = element;
            }

            if(min > element) {
                min = element;
            }
        }

        return min + max;
    }
}
