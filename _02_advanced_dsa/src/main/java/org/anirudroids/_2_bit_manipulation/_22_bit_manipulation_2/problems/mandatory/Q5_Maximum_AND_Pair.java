package org.anirudroids._2_bit_manipulation._22_bit_manipulation_2.problems.mandatory;

import java.util.ArrayList;

public class Q5_Maximum_AND_Pair {
    /**
     * Problem Description
     * Given an array A. For every pair of indices i and j (i != j), find the maximum A[i] & A[j].
     *
     *
     * Problem Constraints
     * 1 <= len(A) <= 105
     * 1 <= A[i] <= 109
     *
     *
     * Input Format
     * The first argument is an integer array A.
     *
     *
     * Output Format
     * Return a single integer that is the maximum A[i] & A[j].
     *
     *
     * Example Input
     * Input 1:-
     * A = [53, 39, 88]
     * Input 2:-
     * A = [38, 44, 84, 12]
     *
     *
     * Example Output
     * Output 1:-
     * 37
     * Output 2:-
     * 36
     *
     *
     * Example Explanation
     * Explanation 1:-
     * 53 & 39 = 37
     * 39 & 88 = 0
     * 53 & 88 = 16
     * Maximum among all these pairs is 37
     * Explanation 2:-
     * Maximum bitwise and among all pairs is (38, 44) = 36
     */

    public int solve(ArrayList<Integer> A) {
        for(int index = 31; index >=0; index--) {
            int count = 0;

            for (Integer integer : A) {
                if ((integer & (1 << index)) > 0) {
                    count++;
                }
            }
            if(count >= 2) {
                for(int j = 0; j < A.size(); j++) {
                    if((A.get(j) & (1 << index)) == 0) {
                        A.set(j, 0);
                    }
                }
            }
        }

        int x = -1;
        int y = -1;
        for (int element : A) {
            if (element != 0 && x == -1) {
                x = element;
            } else if (element != 0 && y == -1) {
                y = element;
            }
        }

        return x & y;
    }
}
