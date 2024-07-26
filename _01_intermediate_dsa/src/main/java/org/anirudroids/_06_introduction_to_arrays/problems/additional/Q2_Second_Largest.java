package org.anirudroids._06_introduction_to_arrays.problems.additional;

public class Q2_Second_Largest {
    /**
     * Problem Description
     * You are given an integer array A. You have to find the second largest element/value in the array or report that no such element exists.
     *
     *
     * Problem Constraints
     * 1 <= |A| <= 105
     *
     * 0 <= A[i] <= 109
     *
     *
     *
     * Input Format
     * The first argument is an integer array A.
     *
     *
     *
     * Output Format
     * Return the second largest element. If no such element exist then return -1.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [2, 1, 2]
     * Input 2:
     *
     *  A = [2]
     *
     *
     * Example Output
     * Output 1:
     *
     *  1
     * Output 2:
     *
     *  -1
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  First largest element = 2
     *  Second largest element = 1
     * Explanation 2:
     *
     *  There is no second largest element in the array.
     */

    public int solve(int[] A) {
        int max = -1;
        int secondLargest = -1;

        boolean found = false;
        for(int index = 0; index < A.length; index++) {
            int element = A[index];

            if(max < element) {
                secondLargest = max;
                max = element;
                found = true;
            }
            if(element > secondLargest && element < max) {
                secondLargest = element;
            }
        }

        if(!found) {
            System.out.println("There is no second largest element in the array.");
        }

        return secondLargest;
    }
}
