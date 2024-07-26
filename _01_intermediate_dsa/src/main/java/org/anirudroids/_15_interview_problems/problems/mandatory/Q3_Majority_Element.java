package org.anirudroids._15_interview_problems.problems.mandatory;

public class Q3_Majority_Element {
    /**
     * Problem Description
     * Given an array of size N, find the majority element. The majority element is the element that appears more than floor(n/2) times.
     * You may assume that the array is non-empty and the majority element always exists in the array.
     *
     *
     *
     * Problem Constraints
     * 1 <= N <= 5*105
     * 1 <= num[i] <= 109
     *
     *
     * Input Format
     * Only argument is an integer array.
     *
     *
     * Output Format
     * Return an integer.
     *
     *
     * Example Input
     * Input 1:
     * [2, 1, 2]
     * Input 2:
     * [1, 1, 1]
     *
     *
     * Example Output
     * Input 1:
     * 2
     * Input 2:
     * 1
     *
     *
     * Example Explanation
     * For Input 1:
     * 2 occurs 2 times which is greater than 3/2.
     * For Input 2:
     *  1 is the only element in the array, so it is majority
     */

    public int majorityElement(final int[] A) {
        int majorityCandidate = A[0];

        int count = 1;
        for(int index = 1; index < A.length; index++) {
            if(count == 0) {
                majorityCandidate = A[index];
                count = 1;
            }

            if(majorityCandidate == A[index]) {
                count++;
            } else {
                count--;
            }
        }

        count = 0;
        for(int index = 0; index < A.length; index++) {
            if(A[index] == majorityCandidate) {
                count++;
            }
        }

        if(count > A.length/2) {
            return majorityCandidate;
        }
        return 0;
    }
}
