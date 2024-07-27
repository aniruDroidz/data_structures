package org.anirudroids._2_bit_manipulation._22_bit_manipulation_2.problems.mandatory;

import java.util.ArrayList;

public class Q3_Single_Number_III {
    /**
     * Problem Description
     * Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
     * Find the two integers that appear only once.
     *
     * Note: Return the two numbers in ascending order.
     *
     *
     * Problem Constraints
     * 2 <= |A| <= 100000
     * 1 <= A[i] <= 109
     *
     *
     *
     * Input Format
     * The first argument is an array of integers of size N.
     *
     *
     *
     * Output Format
     * Return an array of two integers that appear only once.
     *
     *
     *
     * Example Input
     * Input 1:
     * A = [1, 2, 3, 1, 2, 4]
     * Input 2:
     *
     * A = [1, 2]
     *
     *
     * Example Output
     * Output 1:
     * [3, 4]
     * Output 2:
     *
     * [1, 2]
     *
     *
     * Example Explanation
     * Explanation 1:
     * 3 and 4 appear only once.
     * Explanation 2:
     *
     * 1 and 2 appear only once.
     */

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int xor = 0;

        for (Integer value : A) {
            xor = xor ^ value;
        }

        int index = 0;

        while(index < 32) {
            if((xor & (1 << index)) > 0) {
                break;
            } else {
                index++;
            }
        }

        int xor1 = 0;
        int xor2 = 0;

        for (Integer integer : A) {
            if ((integer & (1 << index)) == 0) {
                xor2 = xor2 ^ integer;
            } else {
                xor1 = xor1 ^ integer;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(Math.min(xor1, xor2));
        result.add(Math.max(xor1, xor2));

        return result;
    }
}
