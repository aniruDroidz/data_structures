package org.anirudroids._39_quick_sort_comparator_problems.problems.additional;

public class Q3_Sort_by_Color {
    /**
     * Problem Description
     * Given an array with N objects colored red, white, or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
     *
     * We will represent the colors as,
     *
     * red -> 0
     * white -> 1
     * blue -> 2
     *
     * Note: Using the library sort function is not allowed.
     *
     *
     *
     * Problem Constraints
     * 1 <= N <= 1000000
     * 0 <= A[i] <= 2
     *
     *
     * Input Format
     * First and only argument of input contains an integer array A.
     *
     *
     * Output Format
     * Return an integer array in asked order
     *
     *
     * Example Input
     * Input 1 :
     *     A = [0, 1, 2, 0, 1, 2]
     * Input 2:
     *
     *     A = [0]
     *
     *
     * Example Output
     * Output 1:
     *     [0, 0, 1, 1, 2, 2]
     * Output 2:
     *
     *     [0]
     *
     *
     * Example Explanation
     * Explanation 1:
     *     [0, 0, 1, 1, 2, 2] is the required order.
     * Explanation 2:
     *     [0] is the required order
     */

    public int[] sortColors(int[] A) {
        int reds = 0;
        int whites = 0;

        for(int element: A) {
            switch(element) {
                case 0:
                    reds++;
                    break;
                case 1:
                    whites++;
                    break;
                default:
                    break;
            }
        }

        for(int i = 0; i < A.length; i++) {
            if(i < reds) {
                A[i] = 0;
            } else if(i < reds+whites) {
                A[i] = 1;
            } else {
                A[i] = 2;
            }
        }

        return A;
    }
}
