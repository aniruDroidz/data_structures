package org.anirudroids._1_introduction.problems.mandatory;

public class Q3_Build_a_Heap {
    /**
     * Problem Description
     * Given an array A of N integers, convert that array into a min heap and return the array.
     *
     * NOTE: A min heap is a binary tree where every node has a value less than or equal to its children.
     *
     *
     *
     * Problem Constraints
     * 1 ≤ N ≤ 105
     *
     * 0 ≤ A[i] ≤ 109
     *
     *
     *
     * Input Format
     * First and only argument of input contains a single integer array A of length N.
     *
     *
     *
     * Output Format
     * Return the reordered array A such that it forms a min heap.
     *
     *
     *
     * Example Input
     * Input:
     *
     * A = [5, 13, -2, 11, 27, 31, 0, 19]
     *
     *
     * Example Output
     * Output:
     *
     * A = [-2, 5, 0, 13, 11, 19, 27, 31]
     *
     *
     * Example Explanation
     * One possible Heap is
     *
     *                 -2
     *                /    \
     *              5       0
     *             / \    /  \
     *           13  11  19   27
     *           /
     *         31
     *
     * It can be seen that each parent has a value smaller than its children. Hence it is a Valid Heap.
     *
     * The Heap in the Array format is [-2, 5, 0, 13, 11, 19, 27, 31].
     *
     * Some more possible heaps are  [-2, 0, 5, 13, 11, 27, 19, 31], [-2, 5, 0, 11, 27, 13, 19, 31], etc.
     * You can return any possible Valid Heap Structure.
     */

    public int[] buildHeap(int[] A) {
        int[] answer = new int[A.length];

        for(int index = 0; index < A.length; index++) {
            answer[index] = A[index];
            upHeapify(answer, index);
        }
        return answer;
    }

    private void upHeapify(int[] A, int index) {
        int parent = (index -1)/2;
        while(index != 0) {
            if(A[parent] > A[index]) {
                int temp = A[parent];
                A[parent] = A[index];
                A[index] = temp;
            }
            index = parent;
            parent = (index - 1)/2;
        }
    }
}
