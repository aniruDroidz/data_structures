package org.anirudroids._2_bit_manipulation._21_bit_manipulation_1.problems.additional;

public class Q4_Find_nth_Magic_Number {
    /**
     * Problem Description
     * Given an integer A, find and return the Ath magic number.
     *
     * A magic number is defined as a number that can be expressed as a power of 5 or a sum of unique powers of 5.
     *
     * First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….
     *
     *
     *
     * Problem Constraints
     * 1 <= A <= 5000
     *
     *
     *
     * Input Format
     * The only argument given is integer A.
     *
     *
     *
     * Output Format
     * Return the Ath magic number.
     *
     *
     *
     * Example Input
     * Example Input 1:
     *
     *  A = 3
     * Example Input 2:
     *
     *  A = 10
     *
     *
     * Example Output
     * Example Output 1:
     *
     *  30
     * Example Output 2:
     *
     *  650
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  Magic Numbers in increasing order are [5, 25, 30, 125, 130, ...]
     *  3rd element in this is 30
     * Explanation 2:
     *
     *  In the sequence shown in explanation 1, 10th element will be 650.
     */

    public int solve(int A) {
        int answer = 0;
        int i = 1;
        while (A > 0) {
            answer += (int) ((A & 1) * Math.pow(5, i));
            i++;
            A = A >> 1;
        }

        return answer;
    }
}
