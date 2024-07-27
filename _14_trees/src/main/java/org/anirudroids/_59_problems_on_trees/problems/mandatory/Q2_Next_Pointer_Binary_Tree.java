package org.anirudroids._59_problems_on_trees.problems.mandatory;

public class Q2_Next_Pointer_Binary_Tree {
    /**
     * Problem Description
     * Given a binary tree,
     *
     * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
     *
     * Initially, all next pointers are set to NULL.
     *
     * Assume perfect binary tree.
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
     * Return the head of the binary tree after the changes are made.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *
     *      1
     *     /  \
     *    2    3
     * Input 2:
     *
     *
     *         1
     *        /  \
     *       2    5
     *      / \  / \
     *     3  4  6  7
     *
     *
     * Example Output
     * Output 1:
     *
     *
     *         1 -> NULL
     *        /  \
     *       2 -> 3 -> NULL
     * Output 2:
     *
     *
     *          1 -> NULL
     *        /  \
     *       2 -> 5 -> NULL
     *      / \  / \
     *     3->4->6->7 -> NULL
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     * Next pointers are set as given in the output.
     * Explanation 2:
     *
     * Next pointers are set as given in the output.
     */

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        TreeLinkNode parent = root;
        while(parent.left != null) {
            TreeLinkNode next = parent.left;

            while(parent != null) {
                parent.left.next = parent.right;

                if(parent.next != null) {
                    parent.right.next = parent.next.left;
                }
                parent = parent.next;
            }
            parent = next;
        }
    }
}
