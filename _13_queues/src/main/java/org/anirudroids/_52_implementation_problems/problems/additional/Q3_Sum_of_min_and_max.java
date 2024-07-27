package org.anirudroids._52_implementation_problems.problems.additional;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Q3_Sum_of_min_and_max {
    /**
     * Problem Description
     * Given an array A of both positive and negative integers.
     *
     * Your task is to compute the sum of minimum and maximum elements of all sub-array of size B.
     *
     * NOTE: Since the answer can be very large, you are required to return the sum modulo 109 + 7.
     *
     *
     *
     * Problem Constraints
     * 1 <= size of array A <= 105
     *
     * -109 <= A[i] <= 109
     *
     * 1 <= B <= size of array
     *
     *
     *
     * Input Format
     * The first argument denotes the integer array A.
     * The second argument denotes the value B
     *
     *
     *
     * Output Format
     * Return an integer that denotes the required value.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [2, 5, -1, 7, -3, -1, -2]
     *  B = 4
     * Input 2:
     *
     *  A = [2, -1, 3]
     *  B = 2
     *
     *
     * Example Output
     * Output 1:
     *
     *  18
     * Output 2:
     *
     *  3
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  Subarrays of size 4 are :
     *     [2, 5, -1, 7],   min + max = -1 + 7 = 6
     *     [5, -1, 7, -3],  min + max = -3 + 7 = 4
     *     [-1, 7, -3, -1], min + max = -3 + 7 = 4
     *     [7, -3, -1, -2], min + max = -3 + 7 = 4
     *     Sum of all min & max = 6 + 4 + 4 + 4 = 18
     * Explanation 2:
     *
     *  Subarrays of size 2 are :
     *     [2, -1],   min + max = -1 + 2 = 1
     *     [-1, 3],   min + max = -1 + 3 = 2
     *     Sum of all min & max = 1 + 2 = 3
     */

    public int solve(ArrayList<Integer> A, int B) {
        if(A.size() < B) {
            return 0;
        }

        Deque<Integer> dequeDec = new LinkedList<>();
        Deque<Integer> dequeInc = new LinkedList<>();

        for(int i = 0; i < B; i++) {
            while(!dequeDec.isEmpty() && A.get(i) >= A.get(dequeDec.peekLast())) {
                dequeDec.pollLast();
            }
            dequeDec.offerLast(i);

            while(!dequeInc.isEmpty() && A.get(i) <= A.get(dequeInc.peekLast())) {
                dequeInc.pollLast();
            }
            dequeInc.offerLast(i);
        }

        long result = A.get(dequeDec.peekFirst()) + A.get(dequeInc.peekFirst());

        int s = 1;
        int e = B;

        while(e < A.size()) {
            if(s-1 == dequeDec.peekFirst()) {
                dequeDec.pollFirst();
            }

            while(!dequeDec.isEmpty() && A.get(e) >= A.get(dequeDec.peekLast())) {
                dequeDec.pollLast();
            }
            dequeDec.offerLast(e);

            if(s-1 == dequeInc.peekFirst()) {
                dequeInc.pollFirst();
            }

            while(!dequeInc.isEmpty() && A.get(e) <= A.get(dequeInc.peekLast())) {
                dequeInc.pollLast();
            }
            dequeInc.offerLast(e);

            result += A.get(dequeDec.peekFirst()) + A.get(dequeInc.peekFirst());
            s++;
            e++;
        }

        return (int)((result%1000000007)+1000000007)%1000000007;
    }
}
