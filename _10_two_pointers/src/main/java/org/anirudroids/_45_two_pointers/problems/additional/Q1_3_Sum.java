package org.anirudroids._45_two_pointers.problems.additional;

import java.util.Arrays;

public class Q1_3_Sum {
    /**
     * Problem Description
     * Given an array A of N integers, find three integers in A such that the sum is closest to a given number B. Return the sum of those three integers.
     *
     * Assume that there will only be one solution.
     *
     *
     *
     * Problem Constraints
     * -108 <= B <= 108
     * 1 <= N <= 104
     * -108 <= A[i] <= 108
     *
     *
     * Input Format
     * First argument is an integer array A of size N.
     *
     * Second argument is an integer B denoting the sum you need to get close to.
     *
     *
     *
     * Output Format
     * Return a single integer denoting the sum of three integers which is closest to B.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     * A = [-1, 2, 1, -4]
     * B = 1
     * Input 2:
     *
     *
     * A = [1, 2, 3]
     * B = 6
     *
     *
     * Example Output
     * Output 1:
     *
     * 2
     * Output 2:
     *
     * 6
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
     * Explanation 2:
     *
     *  Take all elements to get exactly 6.
     */

    public int threeSumClosest(int[] A, int B) {

        if(A.length < 3) {
            return -1;
        }
        Arrays.sort(A);
        long result = Integer.MAX_VALUE;

        for(int i = 0; i < A.length-2; i++) {
            int first = A[i];

            int j = i+1;
            int k = A.length-1;

            while(j < k) {
                int second = A[j];
                int third = A[k];

                long sum = (long)first + second + third;
                if(Math.abs(sum - B) < Math.abs(result - B)) {
                    result = sum;
                }

                if(sum < B) {
                    j++;
                } else if(sum > B) {
                    k--;
                } else {
                    return B;
                }
            }
        }

        return (int)result;
    }
}
