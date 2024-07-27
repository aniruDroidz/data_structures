package org.anirudroids._2_bit_manipulation._22_bit_manipulation_2.problems.additional;

import java.util.ArrayList;

public class Q4_Sum_of_Xor_of_all_Pairs {
    /**
     * Problem Description
     * Given an array A of N integers. Find the sum of bitwise XOR all pairs of numbers in the array.
     *
     * Since the answer can be large, return the remainder after the dividing the answer by 109+7.
     *
     *
     *
     * Problem Constraints
     * 1 <= N <= 105
     *
     * 1 <= A[i] < 109
     *
     *
     *
     * Input Format
     * Only argument A is an array of integers
     *
     *
     *
     * Output Format
     * Return an integer denoting the sum of xor of all pairs of number in the array.
     *
     *
     *
     * Example Input
     * Input 1:
     * A = [1, 2, 3]
     * Input 2:
     * A = [3, 4, 2]
     *
     *
     * Example Output
     * Output 1:
     * 6
     * Output 2:
     * 14
     *
     *
     * Example Explanation
     * For Input 1:
     * Pair    Xor
     * {1, 2}  3
     * {1, 3}  2
     * {2, 3}  1
     * Sum of xor of all pairs = 3 + 2 + 1 = 6.
     * For Input 2:
     * Pair    Xor
     * {3, 4}  7
     * {3, 2}  1
     * {4, 2}  6
     * Sum of xor of all pairs = 7 + 1 + 6 = 14.
     */

    public int solve(ArrayList<Integer> A) {
        long sum = 0;

        for(int index = 0; index < 32; index++) {
            long x = 0;
            long y = 0;
            long innerSum = 0;
            for(int j = 0; j < A.size(); j++) {
                if(A.get(j)%2 == 0) {
                    y++;
                } else {
                    x++;
                }

                A.set(j, A.get(j) >> 1);
            }

            innerSum = (x * y) * (1 << index);

            sum += innerSum;
        }

        return (int)(sum%( (int)Math.pow(10, 9) + 7));
    }
}
