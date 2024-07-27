package org.anirudroids._41_binary_search_on_arrays.problems.mandatory;

public class Q3_Find_a_peak_element {
    /**
     * Problem Description
     * Given an array of integers A, find and return the peak element in it.
     * An array element is considered a peak if it is not smaller than its neighbors. For corner elements, we need to consider only one neighbor.
     *
     * NOTE:
     *
     * It is guaranteed that the array contains only a single peak element.
     * Users are expected to solve this in O(log(N)) time. The array may contain duplicate elements.
     *
     *
     * Problem Constraints
     * 1 <= |A| <= 100000
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
     * Return the peak element.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     * A = [1, 2, 3, 4, 5]
     * Input 2:
     *
     * A = [5, 17, 100, 11]
     *
     *
     * Example Output
     * Output 1:
     *
     *  5
     * Output 2:
     *
     *  100
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  5 is the peak.
     * Explanation 2:
     *
     *  100 is the peak.
     */

    public int solve(int[] A) {
        int s = 0;
        int e = A.length - 1;

        while(s <= e) {
            int mid = s + (e-s)/2;
            if((mid == 0 || A[mid-1] <= A[mid]) && (mid == A.length-1 || A[mid+1] <= A[mid])) {
                return A[mid];
            } else if(A[mid+1] >= A[mid]) {
                s = mid+1;
            } else {
                e = mid-1;
            }
        }

        return -1;
    }
}
