package org.anirudroids._52_implementation_problems.problems.additional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Q2_N_integers_containing_only_1_2_and_3 {
    /**
     * Problem Description
     * Given an integer, A. Find and Return first positive A integers in ascending order containing only digits 1, 2, and 3.
     *
     * NOTE: All the A integers will fit in 32-bit integers.
     *
     *
     *
     * Problem Constraints
     * 1 <= A <= 29500
     *
     *
     *
     * Input Format
     * The only argument given is integer A.
     *
     *
     *
     * Output Format
     * Return an integer array denoting the first positive A integers in ascending order containing only digits 1, 2 and 3.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = 3
     * Input 2:
     *
     *  A = 7
     *
     *
     * Example Output
     * Output 1:
     *
     *  [1, 2, 3]
     * Output 2:
     *
     *  [1, 2, 3, 11, 12, 13, 21]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  Output denotes the first 3 integers that contains only digits 1, 2 and 3.
     * Explanation 2:
     *
     *  Output denotes the first 7 integers that contains only digits 1, 2 and 3.
     */

    public ArrayList<Integer> solve(int A) {
        Queue<String> q =new LinkedList<>();
        q.offer("1");
        q.offer("2");
        q.offer("3");

        ArrayList<Integer> result = new ArrayList<>();

        for( int i=0; i < A; i++) {
            String element = q.peek();
            q.offer(element + "1");
            q.offer(element + "2");
            q.offer(element + "3");
            result.add(Integer.parseInt(Objects.requireNonNull(q.poll())));
        }
        return result;
    }
}
