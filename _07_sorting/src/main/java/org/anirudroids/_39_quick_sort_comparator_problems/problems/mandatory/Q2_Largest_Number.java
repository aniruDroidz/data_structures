package org.anirudroids._39_quick_sort_comparator_problems.problems.mandatory;

import java.util.ArrayList;
import java.util.List;

public class Q2_Largest_Number {
    /**
     * Problem Description
     * Given an array A of non-negative integers, arrange them such that they form the largest number.
     *
     * Note: The result may be very large, so you need to return a string instead of an integer.
     *
     *
     *
     * Problem Constraints
     * 1 <= len(A) <= 100000
     * 0 <= A[i] <= 2*109
     *
     *
     *
     * Input Format
     * The first argument is an array of integers.
     *
     *
     *
     * Output Format
     * Return a string representing the largest number.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [3, 30, 34, 5, 9]
     * Input 2:
     *
     *  A = [2, 3, 9, 0]
     *
     *
     * Example Output
     * Output 1:
     *
     *  "9534330"
     * Output 2:
     *
     *  "9320"
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     * Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.
     * Explanation 2:
     *
     * Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320.
     */

    public String largestNumber(int[] A) {
        StringBuilder stringBuilder = new StringBuilder();

        List<String> list = new ArrayList<>();

        for(int element: A) {
            list.add(String.valueOf(element));
        }

        list.sort((s, t1) -> (t1+s).compareTo(s+t1));

        for(String element: list) {
            stringBuilder.append(element);
        }

        int position = 0;
        while(stringBuilder.charAt(position) == 0 && position + 1 < stringBuilder.length()) {
            position++;
        }

        if (stringBuilder.charAt(0) == '0') {
            return "0";
        }

        return stringBuilder.substring(position);
    }
}
