package org.anirudroids._06_introduction_to_arrays.problems.additional;

public class Q5_Count_of_elements {
    /**
     * Problem Description
     * Given an array A of N integers.
     * Count the number of elements that have at least 1 elements greater than itself.
     *
     *
     * Problem Constraints
     * 1 <= N <= 105
     * 1 <= A[i] <= 109
     *
     *
     * Input Format
     * First and only argument is an array of integers A.
     *
     *
     * Output Format
     * Return the count of elements.
     *
     *
     * Example Input
     * Input 1:
     * A = [3, 1, 2]
     * Input 2:
     * A = [5, 5, 3]
     *
     *
     * Example Output
     * Output 1:
     * 2
     * Output 2:
     * 1
     *
     *
     * Example Explanation
     * Explanation 1:
     * The elements that have at least 1 element greater than itself are 1 and 2
     * Explanation 2:
     * The elements that have at least 1 element greater than itself is 3
     */

    public int solve(int[] A) {
        int max = -1;
        int count = 0;
        for(int index = 0; index < A.length; index++) {
            if(max < A[index]) {
                max = A[index];
            }
        }

        for(int index = 0; index < A.length; index++) {
            if(max - A[index] > 0) {
                count++;
            }
        }

        return count;
    }
}
