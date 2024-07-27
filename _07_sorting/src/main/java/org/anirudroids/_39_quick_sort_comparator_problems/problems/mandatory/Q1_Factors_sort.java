package org.anirudroids._39_quick_sort_comparator_problems.problems.mandatory;

import java.util.Arrays;
import java.util.Comparator;

public class Q1_Factors_sort {
    /**
     * Problem Description
     * You are given an array A of N elements. Sort the given array in increasing order of number of distinct factors of each element, i.e., element having the least number of factors should be the first to be displayed and the number having highest number of factors should be the last one. If 2 elements have same number of factors, then number with less value should come first.
     *
     * Note: You cannot use any extra space
     *
     *
     * Problem Constraints
     * 1 <= N <= 104
     * 1 <= A[i] <= 104
     *
     *
     * Input Format
     * First argument A is an array of integers.
     *
     *
     * Output Format
     * Return an array of integers.
     *
     *
     * Example Input
     * Input 1:
     * A = [6, 8, 9]
     * Input 2:
     * A = [2, 4, 7]
     *
     *
     * Example Output
     * Output 1:
     * [9, 6, 8]
     * Output 2:
     * [2, 7, 4]
     *
     *
     * Example Explanation
     * For Input 1:
     * The number 9 has 3 factors, 6 has 4 factors and 8 has 4 factors.
     * For Input 2:
     * The number 2 has 2 factors, 7 has 2 factors and 4 has 3 factors.
     */

    private int getFactors(int a) {
        int count = 2;
        for(int i = 2; i <= a/2; i++) {
            if(a%i == 0) {
                count++;
            }
        }

        return count;
    }

    public int[] solve(int[] A) {
        Integer[] source = new Integer[A.length];
        for(int i = 0; i < A.length; i++) {
            source[i] = A[i];
        }

        Arrays.sort(source, (integer, t1) -> {
            int factorsA = getFactors(integer);
            int factorsB = getFactors(t1);

            if (factorsA > factorsB) {
                return 1;
            } else if (factorsA < factorsB) {
                return -1;
            } else {
                return Integer.compare(integer, t1);
            }
        });

        for(int i = 0; i < A.length; i++) {
            A[i] = source[i];
        }

        return A;
    }
}
