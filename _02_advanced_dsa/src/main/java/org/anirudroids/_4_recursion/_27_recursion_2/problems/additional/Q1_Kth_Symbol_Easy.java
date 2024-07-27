package org.anirudroids._4_recursion._27_recursion_2.problems.additional;

import java.util.ArrayList;
import java.util.List;

public class Q1_Kth_Symbol_Easy {
    /**
     * Problem Description
     * On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
     *
     * Given row number A and index B, return the Bth indexed symbol in row A. (The values of B are 0-indexed.).
     *
     *
     *
     * Problem Constraints
     * 1 <= A <= 20
     *
     * 0 <= B < 2A - 1
     *
     *
     *
     * Input Format
     * First argument is an integer A.
     *
     * Second argument is an integer B.
     *
     *
     *
     * Output Format
     * Return an integer denoting the Bth indexed symbol in row A.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = 3
     *  B = 0
     * Input 2:
     *
     *  A = 4
     *  B = 4
     *
     *
     * Example Output
     * Output 1:
     *
     *  0
     * Output 2:
     *
     *  1
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  Row 1: 0
     *  Row 2: 01
     *  Row 3: 0110
     * Explanation 2:
     *
     *  Row 1: 0
     *  Row 2: 01
     *  Row 3: 0110
     *  Row 4: 01101001
     */

    public int solve(int A, int B) {
        List<Integer> arr = generateRows(A);
        return arr.get(B);
    }

    List<Integer> generateRows(int A){
        if(A == 1) {
            List<Integer> current = new ArrayList<>();
            current.add(0);
            return current;
        }

        List<Integer> arr = generateRows(A-1);
        List<Integer> current = new ArrayList<>();
        for(int index = 0; index < Math.pow(2, A-2); index++) {
            if(arr.get(index) == 0) {
                current.add(0);
                current.add(1);
            } else {
                current.add(1);
                current.add(0);
            }
        }

        return current;
    }
}
