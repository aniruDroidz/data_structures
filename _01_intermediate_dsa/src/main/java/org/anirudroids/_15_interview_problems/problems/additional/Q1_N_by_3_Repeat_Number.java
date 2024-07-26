package org.anirudroids._15_interview_problems.problems.additional;

public class Q1_N_by_3_Repeat_Number {
    /**
     * Problem Description
     * You're given a read-only array of N integers. Find out if any integer occurs more than N/3 times in the array in linear time and constant additional space.
     * If so, return the integer. If not, return -1.
     *
     * If there are multiple solutions, return any one.
     *
     * Note: Read-only array means that the input array should not be modified in the process of solving the problem
     *
     *
     *
     * Problem Constraints
     * 1 <= N <= 7*105
     * 1 <= A[i] <= 109
     *
     *
     * Input Format
     * The only argument is an integer array A.
     *
     *
     * Output Format
     * Return an integer.
     *
     *
     * Example Input
     * Input 1:
     * [1 2 3 1 1]
     * Input 2:
     * [1 2 3]
     *
     *
     * Example Output
     * Output 1:
     * 1
     * Output 2:
     * -1
     *
     *
     * Example Explanation
     * Explanation 1:
     * 1 occurs 3 times which is more than 5/3 times.
     * Explanation 2:
     * No element occurs more than 3 / 3 = 1 times in the array.
     */

    public int repeatedNumber(int[] A) {
        int n = A.length;
        int count1 = 0, count2 = 0;
        int first =  Integer.MIN_VALUE;;
        int second = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (first == A[i])
                count1++;
            else if (second == A[i])
                count2++;
            else if (count1 == 0) {
                count1++;
                first = A[i];
            }
            else if (count2 == 0) {
                count2++;
                second = A[i];
            }
            else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int i = 0; i < n; i++) {
            if (A[i] == first)
                count1++;
            else if (A[i] == second)
                count2++;
        }

        if (count1 > n / 3)
            return first;

        if (count2 > n / 3)
            return second;

        return -1;
    }
}
