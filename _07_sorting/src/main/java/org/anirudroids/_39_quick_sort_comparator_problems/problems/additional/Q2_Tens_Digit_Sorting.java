package org.anirudroids._39_quick_sort_comparator_problems.problems.additional;

import java.util.Arrays;
import java.util.Comparator;

public class Q2_Tens_Digit_Sorting {
    /**
     * Problem Description
     * Given an array A of N integers. Sort the array in increasing order of the value at the tens place digit of every number.
     *
     * If a number has no tens digit, we can assume value to be 0.
     * If 2 numbers have same tens digit, in that case number with max value will come first
     * Solution should be based on comparator.
     *
     *
     * Problem Constraints
     * 1 <= N <= 105
     *
     * 1 <= A[i] <= 109
     *
     *
     *
     * Input Format
     * First argument A is an array of integers.
     *
     *
     *
     * Output Format
     * Return the array after sorting
     *
     *
     *
     * Example Input
     * Input 1:
     * A = [15, 11, 7, 19]
     * Input 2:
     * A = [2, 24, 22, 19]
     *
     *
     * Example Output
     * Output 1:
     * [7, 19, 15, 11]
     * Output 2:
     * [2, 19, 24, 22]
     *
     *
     * Example Explanation
     * For Input 1:
     * The sorted order is [7, 19, 15, 11]. The tens digit of 7 is 0,
     * and that of 19, 15 and 11 is 1.
     * For Input 2:
     * The sorted order is [2, 19, 24, 22]. The tens digit of 2 is 0,
     * that of 19 is 1 and that of 22 and 24 is 2.
     */

    public int[] solve(int[] A) {
        Integer[] source = new Integer[A.length];

        for(int i = 0; i < A.length; i++) {
            source[i] = A[i];
        }

        Arrays.sort(source, (i1, i2) -> {
            String str1 = String.valueOf(i1);
            String str2 = String.valueOf(i2);

            int ch1 = '0';
            if(str1.length() > 1) {
                ch1 = str1.charAt(str1.length()-2);
            }

            int ch2 = '0';
            if(str2.length() > 1) {
                ch2 = str2.charAt(str2.length()-2);
            }

            if(ch1 == ch2) {
                return Integer.compare(i2,i1);
            }
            if(ch1 < ch2) {
                return -1;
            } else {
                return 1;
            }
        });

        for(int i = 0; i < A.length; i++) {
            A[i] = source[i];
        }
        return A;
    }
}
