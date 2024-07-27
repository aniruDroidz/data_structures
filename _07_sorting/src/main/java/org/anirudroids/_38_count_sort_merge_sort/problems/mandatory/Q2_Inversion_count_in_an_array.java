package org.anirudroids._38_count_sort_merge_sort.problems.mandatory;

public class Q2_Inversion_count_in_an_array {
    /**
     * Problem Description
     * Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).
     *
     *
     *
     * Problem Constraints
     * 1 <= length of the array <= 105
     *
     * 1 <= A[i] <= 109
     *
     *
     *
     * Input Format
     * The only argument given is the integer array A.
     *
     *
     *
     * Output Format
     * Return the number of inversions of A modulo (109 + 7).
     *
     *
     *
     * Example Input
     * Input 1:
     *
     * A = [1, 3, 2]
     * Input 2:
     *
     * A = [3, 4, 1, 2]
     *
     *
     * Example Output
     * Output 1:
     *
     * 1
     * Output 2:
     *
     * 4
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     * The pair (1, 2) is an inversion as 1 < 2 and A[1] > A[2]
     * Explanation 2:
     *
     * The pair (0, 2) is an inversion as 0 < 2 and A[0] > A[2]
     * The pair (0, 3) is an inversion as 0 < 3 and A[0] > A[3]
     * The pair (1, 2) is an inversion as 1 < 2 and A[1] > A[2]
     * The pair (1, 3) is an inversion as 1 < 3 and A[1] > A[3]
     */

    private long count;
    public int solve(int[] A) {
        mergeSort(A, 0, A.length-1);
        return (int)(count%(Math.pow(10, 9) + 7));
    }

    private void mergeSort(int[] A, int s, int e) {
        if(s >= e) {
            return;
        }

        int mid = (s + e)/2;

        mergeSort(A, s, mid);
        mergeSort(A, mid+1, e);

        merge(A, s, mid, e);
    }


    private void merge(int[] A, int s, int mid, int e) {
        int n1 = mid - s + 1;
        int n2 = e-mid;

        int[] A1 = new int[n1];
        int[] A2 = new int[n2];

        int index = 0;

        for(int i = s; i <= mid; i++) {
            A1[index++] = A[i];
        }
        index = 0;
        for(int i = mid+1; i <= e; i++) {
            A2[index++] = A[i];
        }

        index = s;
        int i = 0;
        int j = 0;

        while(i < n1 && j < n2) {
            if(A1[i] <= A2[j]) {
                A[index++] = A1[i++];
            } else {
                A[index++] = A2[j++];
                count += n1 - i;
            }
        }

        if(i < n1) {
            while(i < n1) {
                A[index++] = A1[i++];
            }
        } else {
            while(j < n2) {
                A[index++] = A2[j++];
            }
        }
    }
}
