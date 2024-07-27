package org.anirudroids._38_count_sort_merge_sort.problems.mandatory;

public class Q3_Count_Sort {
    /**
     * Problem Description
     * Given an array A. Sort this array using Count Sort Algorithm and return the sorted array.
     *
     *
     * Problem Constraints
     * 1 <= |A| <= 105
     * 1 <= A[i] <= 105
     *
     *
     * Input Format
     * The first argument is an integer array A.
     *
     *
     * Output Format
     * Return an integer array that is the sorted array A.
     *
     *
     * Example Input
     * Input 1:
     * A = [1, 3, 1]
     * Input 2:
     * A = [4, 2, 1, 3]
     *
     *
     * Example Output
     * Output 1:
     * [1, 1, 3]
     * Output 2:
     * [1, 2, 3, 4]
     *
     *
     * Example Explanation
     * For Input 1:
     * The array in sorted order is [1, 1, 3].
     * For Input 2:
     * The array in sorted order is [1, 2, 3, 4].
     */

    public int[] solve(int[] A) {
        int maxElement = 0;

        for (int k : A) {
            if (maxElement < k) {
                maxElement = k;
            }
        }
        int[] countArray = new int[maxElement+1];
        for (int k : A) {
            countArray[k]++;
        }

        int index = 0;
        for(int i = 0; i < countArray.length; i++) {
            for(int j = 0; j < countArray[i]; j++) {
                A[index++] = i;
            }
        }

        return A;
    }
}
