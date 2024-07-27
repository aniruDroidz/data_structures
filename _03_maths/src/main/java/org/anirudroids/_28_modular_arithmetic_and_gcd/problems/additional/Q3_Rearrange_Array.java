package org.anirudroids._28_modular_arithmetic_and_gcd.problems.additional;

import java.util.ArrayList;

public class Q3_Rearrange_Array {
    /**
     * Given an array A of size N. Rearrange the given array so that A[i] becomes A[A[i]] with O(1) extra space.
     *
     * Constraints:
     *
     * 1 <= N <= 5×104
     *
     * 0 <= A[i] <= N - 1
     *
     * The elements of A are distinct
     *
     * Input Format
     *
     * The argument A is an array of integers
     *
     * Example 1:
     *
     * Input : [1, 0]
     * Return : [0, 1]
     * Example 2:
     *
     * Input : [0, 2, 1, 3]
     * Return : [0, 1, 2, 3]
     */

    public void arrange(ArrayList<Integer> a) {
        int n = a.size();
        for(int index = 0; index < n; index++) {
            a.set(index, index);
        }
    }
}
