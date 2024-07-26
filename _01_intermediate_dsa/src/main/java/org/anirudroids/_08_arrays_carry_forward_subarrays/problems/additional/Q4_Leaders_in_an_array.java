package org.anirudroids._08_arrays_carry_forward_subarrays.problems.additional;

public class Q4_Leaders_in_an_array {
    /**
     * Problem Description
     * Given an integer array A containing N distinct integers, you have to find all the leaders in array A. An element is a leader if it is strictly greater than all the elements to its right side.
     *
     * NOTE: The rightmost element is always a leader.
     *
     *
     * Problem Constraints
     * 1 <= N <= 105
     * 1 <= A[i] <= 108
     *
     *
     * Input Format
     * There is a single input argument which a integer array A
     *
     *
     * Output Format
     * Return an integer array denoting all the leader elements of the array.
     *
     *
     * Example Input
     * Input 1:
     *  A = [16, 17, 4, 3, 5, 2]
     * Input 2:
     *  A = [5, 4]
     *
     *
     * Example Output
     * Output 1:
     * [17, 2, 5]
     * Output 2:
     * [5, 4]
     */

    public int[] solve(int[] A) {
        int n = A.length;

        int[] answerArray = new int[n];
        answerArray[n-1] = A[n-1];

        int maxTillNow = A[n-1];
        int leaderCount = 1;
        for(int index = n-2; index >= 0; index--) {
            int element = A[index];
            if(element > maxTillNow) {
                answerArray[index] = element;
                maxTillNow = element;
                leaderCount++;
            }
        }

        int[] result = new int[leaderCount];
        int count = 0;
        for(int index = 0; index < n; index++) {
            int element = answerArray[index];
            if(element != 0) {
                result[count++] = element;
            }
        }

        return result;
    }
}
