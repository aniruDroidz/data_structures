package org.anirudroids._55_views_and_types.problems.mandatory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q2_Right_View_of_Binary_tree {
    /**
     * Problem Description
     * Given a binary tree of integers denoted by root A. Return an array of integers representing the right view of the Binary tree.
     *
     * Right view of a Binary Tree is a set of nodes visible when the tree is visited from Right side.
     *
     *
     *
     * Problem Constraints
     * 1 <= Number of nodes in binary tree <= 100000
     *
     * 0 <= node values <= 10^9
     *
     *
     *
     * Input Format
     * First and only argument is head of the binary tree A.
     *
     *
     *
     * Output Format
     * Return an array, representing the right view of the binary tree.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *
     *             1
     *           /   \
     *          2    3
     *         / \  / \
     *        4   5 6  7
     *       /
     *      8
     * Input 2:
     *
     *
     *             1
     *            /  \
     *           2    3
     *            \
     *             4
     *              \
     *               5
     *
     *
     * Example Output
     * Output 1:
     *
     *  [1, 3, 7, 8]
     * Output 2:
     *
     *  [1, 3, 4, 5]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     * Right view is described.
     * Explanation 2:
     *
     * Right view is described.
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

    public ArrayList<Integer> solve(TreeNode A) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(A);
        ArrayList<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int index = 0; index < size; index++) {
                TreeNode node = queue.poll();

                if(index == size-1) {
                    assert node != null;
                    result.add(node.val);
                }
                assert node != null;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }

        return result;
    }
}
