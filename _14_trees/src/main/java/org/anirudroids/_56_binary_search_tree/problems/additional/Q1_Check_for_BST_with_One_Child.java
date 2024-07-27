package org.anirudroids._56_binary_search_tree.problems.additional;

public class Q1_Check_for_BST_with_One_Child {
    /**
     * Problem Description
     *
     * Given preorder traversal of a binary tree, check if it is possible that it is also a preorder traversal of a Binary Search Tree (BST), where each internal node (non-leaf nodes) have exactly one child.
     *
     *
     *
     * Problem Constraints
     *
     * 1 <= number of nodes <= 100000
     *
     *
     *
     * Input Format
     *
     * First and only argument is an integer array denoting the preorder traversal of binary tree.
     *
     *
     *
     * Output Format
     *
     * Return a string "YES" if true else "NO".
     *
     *
     *
     * Example Input
     *
     * Input 1:
     *
     *  A : [4, 10, 5, 8]
     * Input 2:
     *
     *  A : [1, 5, 6, 4]
     *
     *
     * Example Output
     *
     * Output 1:
     *
     *  "YES"
     * Output 2:
     *
     *  "NO"
     *
     *
     * Example Explanation
     *
     * Explanation 1:
     *
     *  The possible BST is:
     *             4
     *              \
     *              10
     *              /
     *              5
     *               \
     *               8
     * Explanation 2:
     *
     *  There is no possible BST which have the above preorder traversal.
     */

    public String solve(int[] A) {
        return isPossible(A, 0, Integer.MIN_VALUE, Integer.MAX_VALUE) ? "YES" : "NO";
    }

    private boolean isPossible(int[] A, int index, int min, int max) {
        if(A[index] < min || A[index] > max) return false;

        if(index+1 > A.length-1) return true;

        if(A[index+1] > A[index]) {
            return isPossible(A, index+1, A[index]+1, max);
        } else {
            return isPossible(A, index+1, min, A[index]-1);
        }
    }
}
