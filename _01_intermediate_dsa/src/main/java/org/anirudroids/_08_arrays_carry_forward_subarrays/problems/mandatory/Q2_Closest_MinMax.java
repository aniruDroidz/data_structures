package org.anirudroids._08_arrays_carry_forward_subarrays.problems.mandatory;

public class Q2_Closest_MinMax {
    /**
     * Problem Description
     * Given an array A, find the size of the smallest subarray such that it contains at least one occurrence of the maximum value of the array
     *
     * and at least one occurrence of the minimum value of the array.
     *
     *
     *
     * Problem Constraints
     * 1 <= |A| <= 2000
     *
     *
     *
     * Input Format
     * First and only argument is vector A
     *
     *
     *
     * Output Format
     * Return the length of the smallest subarray which has at least one occurrence of minimum and maximum element of the array
     *
     *
     *
     * Example Input
     * Input 1:
     *
     * A = [1, 3, 2]
     * Input 2:
     *
     * A = [2, 6, 1, 6, 9]
     *
     *
     * Example Output
     * Output 1:
     *
     *  2
     * Output 2:
     *
     *  3
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  Take the 1st and 2nd elements as they are the minimum and maximum elements respectievly.
     * Explanation 2:
     *
     *  Take the last 3 elements of the array.
     */

    public int solve(int[] A) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int smallestDistance = Integer.MAX_VALUE;
        int n = A.length;
        for(int index = 0; index < n; index++) {
            int element = A[index];
            if(element > max) {
                max = element;
            }
        }

        for(int index = 0; index < n; index++) {
            int element = A[index];
            if(element < min) {
                min = element;
            }
        }

        int minIndex = -1;
        int maxIndex = -1;
        for(int index = 0; index < n; index++) {
            int element = A[index];
            if(element == min) {
                minIndex = index;

            }
            if(element == max) {
                maxIndex = index;
            }
            int currentSmallestDistance;
            if(maxIndex > minIndex) {
                currentSmallestDistance = maxIndex - minIndex + 1;
            } else {
                currentSmallestDistance = minIndex - maxIndex + 1;
            }
            if(minIndex != -1 && maxIndex != -1 && smallestDistance > currentSmallestDistance) {
                smallestDistance = currentSmallestDistance;
            }
        }

        return smallestDistance;
    }
}
