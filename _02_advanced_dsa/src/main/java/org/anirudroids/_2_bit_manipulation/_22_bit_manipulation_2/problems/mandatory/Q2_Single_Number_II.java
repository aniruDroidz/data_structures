package org.anirudroids._2_bit_manipulation._22_bit_manipulation_2.problems.mandatory;

import java.util.List;

public class Q2_Single_Number_II {
    /**
     * Problem Description
     * Given an array of integers, every element appears thrice except for one, which occurs once.
     *
     * Find that element that does not appear thrice.
     *
     * NOTE: Your algorithm should have a linear runtime complexity.
     *
     * Could you implement it without using extra memory?
     *
     *
     *
     *
     * Problem Constraints
     * 2 <= A <= 5*106
     *
     * 0 <= A <= INTMAX
     *
     *
     *
     * Input Format
     * First and only argument of input contains an integer array A.
     *
     *
     *
     * Output Format
     * Return a single integer.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
     * Input 2:
     *
     *  A = [0, 0, 0, 1]
     *
     *
     * Example Output
     * Output 1:
     *
     *  4
     * Output 2:
     *
     *  1
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  4 occurs exactly once in Input 1.
     *  1 occurs exactly once in Input 2.
     */

    public int singleNumber(final List<Integer> A) {

        int answer = 0;

        for(int index = 0; index < 32; index++) {
            int count = 0;

            for (Integer integer : A) {
                if ((integer & (1 << index)) > 0) {
                    count++;
                }
            }

            if(count % 3 != 0) {
                answer = answer | (1 << index);
            }
        }

        return answer;
    }
}
