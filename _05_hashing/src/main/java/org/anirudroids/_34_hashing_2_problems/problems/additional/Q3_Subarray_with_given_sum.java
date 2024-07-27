package org.anirudroids._34_hashing_2_problems.problems.additional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Q3_Subarray_with_given_sum {
    /**
     * Problem Description
     * Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
     *
     * If the answer does not exist return an array with a single integer "-1".
     *
     * First sub-array means the sub-array for which starting index in minimum.
     *
     *
     *
     * Problem Constraints
     * 1 <= length of the array <= 100000
     * 1 <= A[i] <= 109
     * 1 <= B <= 109
     *
     *
     *
     * Input Format
     * The first argument given is the integer array A.
     *
     * The second argument given is integer B.
     *
     *
     *
     * Output Format
     * Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single integer "-1".
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [1, 2, 3, 4, 5]
     *  B = 5
     * Input 2:
     *
     *  A = [5, 10, 20, 100, 105]
     *  B = 110
     *
     *
     * Example Output
     * Output 1:
     *
     *  [2, 3]
     * Output 2:
     *
     *  [-1]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  [2, 3] sums up to 5.
     * Explanation 2:
     *
     *  No subarray sums up to required number.
     */

    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        HashSet<Long> hashSet = new HashSet<>();

        int e = -1;
        long sum = 0;

        for(int i = 0; i < A.size(); i++) {
            sum += A.get(i);

            if(sum == B || hashSet.contains(sum-B)) {
                e = i;
                break;
            }

            hashSet.add(sum);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        if(e == -1) {
            ans.add(e);
            return ans;
        }

        int resultSum = 0;
        int x = e;
        for(int i = e; i >= 0; i--) {
            resultSum += A.get(i);
            ans.add(A.get(i));
            if(resultSum == B) {
                break;
            }
        }

        Collections.reverse(ans);
        return ans;
    }
}
