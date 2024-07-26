package org.anirudroids._11_sorting_basics.problems.mandatory;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class Q2_Noble_Integer {
    /**
     * Problem Description
     * Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals p.
     *
     *
     *
     * Problem Constraints
     * 1 <= |A| <= 2*105
     * -108 <= A[i] <= 108
     *
     *
     * Input Format
     * First and only argument is an integer array A.
     *
     *
     *
     * Output Format
     * Return 1 if any such integer p is present else, return -1.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [3, 2, 1, 3]
     * Input 2:
     *
     *  A = [1, 1, 3, 3]
     *
     *
     * Example Output
     * Output 1:
     *
     *  1
     * Output 2:
     *
     *  -1
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  For integer 2, there are 2 greater elements in the array..
     * Explanation 2:
     *
     *  There exist no integer satisfying the required conditions.
     */

    public int solve(int[] A) {
        Integer[] arr = new Integer[A.length];
        for(int index = 0; index < A.length; index++) {
            arr[index] = A[index];
        }

        Arrays.sort(arr, Collections.reverseOrder());

        if(arr[0] == 0) return 1;

        int count = 0;
        for(int index = 1; index < arr.length; index++) {
            if(!Objects.equals(arr[index], arr[index - 1])) count = index;
            if(count == arr[index]) return 1;
        }

        return -1;
    }
}
