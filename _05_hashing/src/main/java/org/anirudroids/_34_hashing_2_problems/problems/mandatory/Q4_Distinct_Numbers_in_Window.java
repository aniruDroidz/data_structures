package org.anirudroids._34_hashing_2_problems.problems.mandatory;

import java.util.HashMap;

public class Q4_Distinct_Numbers_in_Window {
    /**
     * Problem Description
     * You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers in all windows of size B.
     *
     * Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.
     *
     * NOTE: if B > N, return an empty array.
     *
     *
     *
     * Problem Constraints
     * 1 <= N <= 106
     *
     * 1 <= A[i] <= 109
     *
     *
     * Input Format
     * First argument is an integer array A
     * Second argument is an integer B.
     *
     *
     *
     * Output Format
     * Return an integer array.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [1, 2, 1, 3, 4, 3]
     *  B = 3
     * Input 2:
     *
     *  A = [1, 1, 2, 2]
     *  B = 1
     *
     *
     * Example Output
     * Output 1:
     *
     *  [2, 3, 3, 2]
     * Output 2:
     *
     *  [1, 1, 1, 1]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  A=[1, 2, 1, 3, 4, 3] and B = 3
     *  All windows of size B are
     *  [1, 2, 1]
     *  [2, 1, 3]
     *  [1, 3, 4]
     *  [3, 4, 3]
     *  So, we return an array [2, 3, 3, 2].
     * Explanation 2:
     *
     *  Window size is 1, so the output array is [1, 1, 1, 1].
     */

    public int[] dNums(int[] A, int B) {
        int n = A.length;
        if(B > n) {
            return new int[0];
        }

        int[] result = new int[n-B+1];
        int resultIndex = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < B; i++) {
            map.put(A[i], map.containsKey(A[i]) ? map.get(A[i]) + 1 : 1);
        }
        result[resultIndex++] = map.size();

        int s = 0;
        int e = B;
        while (e < n) {
            int left = map.get(A[s]);
            if(left == 1) {
                map.remove(A[s]);
            } else {
                map.put(A[s], left-1);
            }

            map.put(A[e], map.containsKey(A[e]) ? map.get(A[e]) + 1 : 1);

            result[resultIndex++] = map.size();
            s++;
            e++;
        }

        return result;
    }
}
