package org.anirudroids._15_interview_problems.problems.additional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Q3_Colorful_Number {
    /**
     * Problem Description
     * Given a number A, find if it is COLORFUL number or not.
     *
     * If number A is a COLORFUL number return 1 else, return 0.
     *
     * What is a COLORFUL Number:
     *
     * A number can be broken into different consecutive sequence of digits.
     * The number 3245 can be broken into sequences like 3, 2, 4, 5, 32, 24, 45, 324, 245 and 3245.
     * This number is a COLORFUL number, since the product of every consecutive sequence of digits is different
     *
     *
     * Problem Constraints
     * 1 <= A <= 2 * 109
     *
     *
     *
     * Input Format
     * The first and only argument is an integer A.
     *
     *
     *
     * Output Format
     * Return 1 if integer A is COLORFUL else return 0.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = 23
     * Input 2:
     *
     *  A = 236
     *
     *
     * Example Output
     * Output 1:
     *
     *  1
     * Output 2:
     *
     *  0
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  Possible Sub-sequences: [2, 3, 23] where
     *  2 -> 2
     *  3 -> 3
     *  23 -> 6  (product of digits)
     *  This number is a COLORFUL number since product of every digit of a sub-sequence are different.
     * Explanation 2:
     *
     *  Possible Sub-sequences: [2, 3, 6, 23, 36, 236] where
     *  2 -> 2
     *  3 -> 3
     *  6 -> 6
     *  23 -> 6  (product of digits)
     *  36 -> 18  (product of digits)
     *  236 -> 36  (product of digits)
     *  This number is not a COLORFUL number since the product sequence 23  and sequence 6 is same.
     */

    public int colorful(int A) {
        List<Integer> numbers = new ArrayList<>();
        while(A != 0) {
            int num = A%10;
            numbers.add(num);
            A = A/10;
        }

        Collections.reverse(numbers);

        HashSet<Integer> hashSet = new HashSet<>();

        int n = numbers.size();

        for(int index =0; index < n; index++){
            int prod = 1;
            for(int j = index; j < n; j++) {
                prod = prod * numbers.get(j);
                if(hashSet.contains(prod)) {
                    return 0;
                }
                hashSet.add(prod);
            }
        }

        return 1;
    }
}
