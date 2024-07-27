package org.anirudroids._59_problems_on_trees.problems.additional;

public class Q2_Identical_Binary_Trees {
    /**
     * Problem Description
     * Given two binary trees, check if they are equal or not.
     *
     * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
     *
     *
     *
     * Problem Constraints
     * 1 <= number of nodes <= 105
     *
     *
     *
     * Input Format
     * The first argument is a root node of the first tree, A.
     *
     * The second argument is a root node of the second tree, B.
     *
     *
     *
     * Output Format
     * Return 0 / 1 ( 0 for false, 1 for true ) for this problem.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *    1       1
     *   / \     / \
     *  2   3   2   3
     * Input 2:
     *
     *    1       1
     *   / \     / \
     *  2   3   3   3
     *
     *
     * Example Output
     * Output 1:
     *
     *  1
     * Output 2:
     *
     *  0
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  Both trees are structurally identical and the nodes have the same value.
     * Explanation 2:
     *
     *  Values of the left child of the root node of the trees are different.
     */

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public int isSameTree(TreeNode A, TreeNode B) {

        return checkTrees(A, B) ? 1 : 0;
    }

    public boolean checkTrees(TreeNode A, TreeNode B) {
        if(A == null && B == null) return true;

        if(A == null || B == null || A.val != B.val) return false;

        return checkTrees(A.left, B.left) && checkTrees(A.right, B.right);
    }
}
