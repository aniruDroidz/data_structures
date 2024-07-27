package org.anirudroids._2_bit_manipulation._22_bit_manipulation_2.problems.mandatory;

import java.util.ArrayList;

public class Q4_Find_Two_Missing_Numbers {
    /**
     * Problem Description
     * Given an array A of length N where all the elements are distinct and are in the range [1, N+2].
     *
     * Two numbers from the range [1, N+2] are missing from the array A. Find the two missing numbers.
     *
     *
     *
     * Problem Constraints
     * 1 <= N <= 105
     *
     * 1 <= A[i] <= N+2
     *
     * The elements of array A are distinct
     *
     *
     *
     * Input Format
     * Only argument A is an array of integers
     *
     *
     *
     * Output Format
     * Return a sorted array of size 2 denoting the missing elements.
     *
     *
     *
     * Example Input
     * Input 1:
     * A = [3, 2, 4]
     * Input 2:
     * A = [5, 1, 3, 6]
     *
     *
     * Example Output
     * Output 1:
     * [1, 5]
     * Output 2:
     * [2, 4]
     *
     *
     * Example Explanation
     * For Input 1:
     * The missing numbers are 1 and 5.
     * For Input 2:
     * The missing numbers are 2 and 4.
     */

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int xor = 0;

        for (Integer integer : A) {
            xor = xor ^ integer;
        }

        for(int index = 1; index <= A.size() + 2; index++) {
            xor = xor ^ index;
        }

        int set_bit_no = xor & -xor;

        int xor1 = 0;
        int xor2 = 0;

        for(int i = 0; i < A.size(); i++) {
            if ((A.get(i) & set_bit_no) > 0)
                xor1 = xor1 ^ A.get(i);
            else
                xor2 = xor2 ^ A.get(i);
        }

        for (int i = 1; i <= A.size() + 2; i++) {
            if ((i & set_bit_no)>0)
                xor1 = xor1 ^ i;
            else
                xor2 = xor2 ^ i;
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(Math.min(xor1, xor2));
        result.add(Math.max(xor1, xor2));

        return result;
    }
}
