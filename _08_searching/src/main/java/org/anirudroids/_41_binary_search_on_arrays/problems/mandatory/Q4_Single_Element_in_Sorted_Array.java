package org.anirudroids._41_binary_search_on_arrays.problems.mandatory;

public class Q4_Single_Element_in_Sorted_Array {
    /**
     * Problem Description
     * Given a sorted array of integers A where every element appears twice except for one element which appears once, find and return this single element that appears only once.
     *
     * Elements which are appearing twice are adjacent to each other.
     *
     * NOTE: Users are expected to solve this in O(log(N)) time.
     *
     *
     *
     * Problem Constraints
     * 1 <= |A| <= 100000
     *
     * 1 <= A[i] <= 10^9
     *
     *
     *
     * Input Format
     * The only argument given is the integer array A.
     *
     *
     *
     * Output Format
     * Return the single element that appears only once.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     * A = [1, 1, 7]
     * Input 2:
     *
     * A = [2, 3, 3]
     *
     *
     * Example Output
     * Output 1:
     *
     *  7
     * Output 2:
     *
     *  2
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  7 appears once
     * Explanation 2:
     *
     *  2 appears once
     */

    public int solve(int[] A) {
        int ans = 0;
        int s = 0;
        int e = A.length - 1;

        while(s <= e){
            int mid = (e-s)/2 + s;

            if((mid == 0 || A[mid-1] != A[mid]) && (mid == A.length - 1 || A[mid+1] != A[mid])) {
                ans = A[mid];
                break;
            } else if((mid != 0 && A[mid] == A[mid-1] && (mid-1) % 2 == 0) ||
                    (mid != A.length - 1 && A[mid] == A[mid+1] && mid%2 == 0)) {
                s = mid+1;
            } else {
                e = mid-1;
            }
        }

        return ans;
    }
}
