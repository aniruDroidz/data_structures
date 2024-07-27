package org.anirudroids._41_binary_search_on_arrays.problems.mandatory;

public class Q1_Sorted_Insert_Position {
    /**
     * Problem Description
     *
     * You are given a sorted array A of size N and a target value B.
     * Your task is to find the index (0-based indexing) of the target value in the array.
     *
     * If the target value is present, return its index.
     * If the target value is not found, return the index of least element greater than equal to B.
     * If the target value is not found and least number greater than equal to target is also not present, return the length of array (i.e. the position where target can be placed)
     * Your solution should have a time complexity of O(log(N)).
     *
     *
     * Problem Constraints
     *
     * 1 <= N <= 105
     * 1 <= A[i] <= 105
     * 1 <= B <= 105
     *
     *
     *
     * Input Format
     *
     * The first argument is an integer array A of size N.
     * The second argument is an integer B.
     *
     *
     *
     * Output Format
     *
     * Return an integer denoting the index of target value.
     *
     *
     *
     * Example Input
     *
     * Input 1:
     *
     * A = [1, 3, 5, 6]
     * B = 5
     * Input 2:
     *
     * A = [1, 4, 9]
     * B = 3
     *
     *
     * Example Output
     *
     * Output 1:
     *
     * 2
     * Output 2:
     *
     * 1
     *
     *
     * Example Explanation
     *
     * Explanation 1:
     *
     * The target value is present at index 2.
     * Explanation 2:
     *
     * The target value should be inserted at index 1.
     */

    public int searchInsert(int[] A, int B) {
        int s = 0;
        int e = A.length - 1;
        int ans = 0;
        while (s <= e) {
            int mid = (e-s)/2 + s;
            if(A[mid] == B) {
                ans = mid;
            } else if(A[mid] < B) {
                ans = mid + 1;
            }

            if(A[mid] < B) {
                s = mid+1;
            } else {
                e = mid-1;
            }
        }

        return ans;
    }
}
