package org.anirudroids._06_introduction_to_arrays.problems.additional;

public class Q1_Linear_Search_Multiple_Occurences {
    /**
     * Problem Description
     * Given an array A and an integer B, find the number of occurrences of B in A.
     *
     *
     * Problem Constraints
     * 1 <= B, Ai <= 109
     * 1 <= length(A) <= 105
     *
     *
     * Input Format
     * Given an integer array A and an integer B.
     *
     *
     * Output Format
     * Return an integer, number of occurrences of B in A.
     *
     *
     * Example Input
     * Input 1:
     *  A = [1, 2, 2], B = 2
     * Input 2:
     *  A = [1, 2, 1], B = 3
     *
     *
     * Example Output
     * Output 1:
     *  2
     * Output 2:
     *  0
     *
     *
     * Example Explanation
     * Explanation 1:
     * Element at index 2, 3 is equal to 2 hence count is 2.
     * Explanation 2:
     * There is no element equal to 3 in the array.
     */

    public int solve(int[] A, int B) {
        int count = 0;
        for(int index = 0; index < A.length; index++) {
            if(A[index] == B) {
                count++;
            }
        }
        return count;
    }
}
