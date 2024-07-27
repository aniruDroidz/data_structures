package org.anirudroids._60_internal_implementation_problems.problems.additional;

import java.util.HashSet;

public class Q3_Count_Subarrays {
    /**
     * Problem Description
     *
     * Misha likes finding all Subarrays of an Array. Now she gives you an array A of N elements and told you to find the number of subarrays of A, that have unique elements.
     *
     * Since the number of subarrays could be large, return value % 109 +7.
     *
     *
     *
     * Problem Constraints
     *
     * 1 <= N <= 105
     *
     * 1 <= A[i] <= 106
     *
     *
     *
     * Input Format
     *
     * The only argument given is an Array A, having N integers.
     *
     *
     *
     * Output Format
     *
     * Return the number of subarrays of A, that have unique elements.
     *
     *
     *
     * Example Input
     *
     * Input 1:
     *
     *  A = [1, 1, 3]
     * Input 2:
     *
     *  A = [2, 1, 2]
     *
     *
     * Example Output
     *
     * Output 1:
     *
     *  4
     * Output 1:
     *
     *  5
     *
     *
     * Example Explanation
     *
     * Explanation 1:
     *
     *  Subarrays of A that have unique elements only:
     *  [1], [1], [1, 3], [3]
     * Explanation 2:
     *
     *  Subarrays of A that have unique elements only:
     *  [2], [1], [2, 1], [1, 2], [2]
     */

    public int solve(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        int result = 0;
        int l = 0;
        int r = 0;

        while(r < A.length) {
            if(set.contains(A[r])) {
                while(set.contains(A[r])) {
                    set.remove(A[l++]);
                }
            }

            set.add(A[r++]);
            result = (result + set.size())%1000000007;
        }

        return result;
    }
}
