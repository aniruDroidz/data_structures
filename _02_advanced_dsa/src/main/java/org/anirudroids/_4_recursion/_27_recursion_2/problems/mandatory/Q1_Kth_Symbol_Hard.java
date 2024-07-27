package org.anirudroids._4_recursion._27_recursion_2.problems.mandatory;

public class Q1_Kth_Symbol_Hard {
    /**
     * Problem Description
     * On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
     *
     * Given row number A and index B, return the Bth indexed symbol in row A. (The values of B are 0-indexed.).
     *
     *
     *
     * Problem Constraints
     * 1 <= A <= 105
     *
     * 0 <= B <= min(2A - 1 - 1 , 1018)
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

    public int solve(int A, long B) {
        if (A == 1) return 0;
        if ((B-1) % 2 == 0) return solve(A - 1, (B-1) / 2) == 0 ? 1 : 0;
        return solve(A - 1, (B) / 2);
    }
}
