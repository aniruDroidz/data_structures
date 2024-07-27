package org.anirudroids._1_arrays._20_arrays_3_interview_problems.problems.additional;

import java.util.ArrayList;
import java.util.Collections;

public class Q1_Next_Permutation {
    /**
     * Problem Description
     * Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers for a given array A of size N.
     *
     * If such arrangement is not possible, it must be rearranged as the lowest possible order, i.e., sorted in ascending order.
     *
     * NOTE:
     *
     * The replacement must be in-place, do not allocate extra memory.
     * DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION. Use of Library functions will disqualify your submission retroactively and will give you penalty points.
     *
     *
     * Problem Constraints
     * 1 <= N <= 5 * 105
     *
     * 1 <= A[i] <= 109
     *
     *
     *
     * Input Format
     * The first and the only argument of input has an array of integers, A.
     *
     *
     *
     * Output Format
     * Return an array of integers, representing the next permutation of the given array.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [1, 2, 3]
     * Input 2:
     *
     *  A = [3, 2, 1]
     *
     *
     * Example Output
     * Output 1:
     *
     *  [1, 3, 2]
     * Output 2:
     *
     *  [1, 2, 3]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  Next permutaion of [1, 2, 3] will be [1, 3, 2].
     * Explanation 2:
     *
     *  No arrangement is possible such that the number are arranged into the numerically next greater permutation of numbers.
     *  So will rearranges it in the lowest possible order.
     */

    public ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
        int index;
        int jIndex;
        for(index = A.size() - 2; index >= 0; index--) {
            if(A.get(index) < A.get(index + 1)) {
                break;
            }
        }

        if(index < 0) {
            Collections.reverse(A);
        } else {
            for(jIndex = A.size() - 1; jIndex > index; jIndex--) {
                if(A.get(jIndex) > A.get(index)) {
                    break;
                }
            }

            int temp = A.get(index);
            A.set(index, A.get(jIndex));
            A.set(jIndex, temp);

            int start = index + 1;
            int end = A.size() - 1;

            while(start < end) {
                int temp1 = A.get(start);
                A.set(start, A.get(end));
                A.set(end, temp1);

                start++;
                end--;
            }
        }

        return A;
    }
}
