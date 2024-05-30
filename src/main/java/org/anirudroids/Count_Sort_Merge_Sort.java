package org.anirudroids;

import java.util.Arrays;

public class Count_Sort_Merge_Sort {

    /**
     * Given two sorted integer arrays A and B, merge B and A as one sorted array and return it
     * as an output.
     *
     * Note: A linear time complexity is expected and you should avoid use of any library function.
     *
     * Example Input
     * Input 1:
     *
     * A = [4, 7, 9]
     * B = [2, 11, 19]
     * Input 2:
     *
     * A = [1]
     * B = [2]
     *
     *
     * Example Output
     * Output 1:
     *
     * [2, 4, 7, 9, 11, 19]
     * Output 2:
     *
     * [1, 2]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     * Merging A and B produces the output as described above.
     * Explanation 2:
     *
     *  Merging A and B produces the output as described above.
     */
    private int[] mergeTwoSortedArrays(final int[] A, final int[] B) {
        int[] result = new int[A.length + B.length];

        int i = 0;
        int j = 0;

        int index = 0;

        while(i < A.length && j < B.length) {
            if(A[i] < B[j]) {
                result[index++] = A[i++];
            } else {
                result[index++] = B[j++];
            }
        }


        while(i < A.length) {
            result[index++] = A[i++];
        }

        while(j < B.length) {
            result[index++] = B[j++];
        }

        return result;
    }


    /**
     * Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an
     * inversion of A. Find the total number of inversions of A modulo (109 + 7).
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
    public int inversionCountInAnArray(int[] A) {
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

    /**
     * Given an array A. Sort this array using Count Sort Algorithm and return the sorted array.
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

    public int[] countSort(int[] A) {
        int maxElement = 0;

        for(int i = 0; i < A.length; i++) {
            if(maxElement < A[i]) {
                maxElement = A[i];
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

    /**
     * Given an array of integers A, find and return the minimum value of | A [ i ] - A [ j ] |
     * where i != j and |x| denotes the absolute value of x.
     *
     * Input Format
     * The only argument given is the integer array A.
     *
     *
     *
     * Output Format
     * Return the minimum value of | A[i] - A[j] |.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [1, 2, 3, 4, 5]
     * Input 2:
     *
     *  A = [5, 17, 100, 11]
     *
     *
     * Example Output
     * Output 1:
     *
     *  1
     * Output 2:
     *
     *  6
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  The absolute difference between any two adjacent elements is 1, which is the minimum value.
     * Explanation 2:
     *
     *  The minimum value is 6 (|11 - 5| or |17 - 11|).
     */

    private int minimumAbsoluteDifference(int[] A) {
        Arrays.sort(A);

        int min = Integer.MAX_VALUE;
        for(int i = 1; i < A.length; i++) {
            if(min > A[i] - A[i-1]) {
                min = A[i] - A[i-1];
            }
        }

        return min;
    }

    /**
     * Problem Description
     * Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)], if we
     * split the array into some number of "chunks" (partitions), and individually sort each chunk.
     * After concatenating them in order of splitting, the result equals the sorted array.
     *
     * What is the most number of chunks we could have made?
     *
     * Example Input
     * Input 1:
     *
     *  A = [1, 2, 3, 4, 0]
     * Input 2:
     *
     *  A = [2, 0, 1, 3]
     *
     *
     * Example Output
     * Output 1:
     *
     *  1
     * Output 2:
     *
     *  2
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  A = [1, 2, 3, 4, 0]
     *  To get the 0 in the first index, we have to take all elements in a single chunk.
     * Explanation 2:
     *
     *  A = [2, 0, 1, 3]
     *  We can divide the array into 2 chunks.
     *  First chunk is [2, 0, 1] and second chunk is [3].
     */

    public int maxChunksToMakeSorted(int[] A) {
        int count = 0;
        int max = 0;
        int i = 0;

        for(int j = 0; j < A.length; j++) {
            max = Math.max(A[j], max);
            if(max == i) {
                count++;
            }
            i++;
        }

        return count;
    }
}
