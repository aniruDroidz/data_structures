package org.anirudroids._1_arrays._20_arrays_3_interview_problems.problems.additional;

public class Q2_Number_of_Digit_One {
    /**
     * Problem Description
     * Given an integer A, find and return the total number of digit 1 appearing in all non-negative integers less than or equal to A.
     *
     *
     *
     * Problem Constraints
     * 0 <= A <= 109
     *
     *
     *
     * Input Format
     * The only argument given is the integer A.
     *
     *
     *
     * Output Format
     * Return the total number of digit 1 appearing in all non-negative integers less than or equal to A.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = 10
     * Input 2:
     *
     *  A = 11
     *
     *
     * Example Output
     * Output 1:
     *
     *  2
     * Output 2:
     *
     *  4
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     * Digit 1 appears in 1 and 10 only and appears one time in each. So the answer is 2.
     * Explanation 2:
     *
     * Digit 1 appears in 1(1 time) , 10(1 time) and 11(2 times) only. So the answer is 4.
     */

    public int solve(int A) {
        int answer = 0;

        for(int index = 1; index <= A; index = index*10) {
            answer += (A/ (index*10)) * index + Math.min(Math.max(A % (index * 10) - (index - 1), 0), index);
        }

        return answer;
    }
}
