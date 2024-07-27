package org.anirudroids._56_binary_search_tree.problems.mandatory;

public class Q1_Search_in_BST {
    /**
     * Problem Description
     * Given a Binary Search Tree A. Check whether there exists a node with value B in the BST.
     *
     *
     * Problem Constraints
     * 1 <= Number of nodes in binary tree <= 105
     *
     * 0 <= B <= 106
     *
     *
     *
     * Input Format
     * First argument is a root node of the binary tree, A.
     *
     * Second argument is an integer B.
     *
     *
     *
     * Output Format
     * Return 1 if such a node exist and 0 otherwise
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *             15
     *           /    \
     *         12      20
     *         / \    /  \
     *        10  14  16  27
     *       /
     *      8
     *
     *      B = 16
     * Input 2:
     *
     *             8
     *            / \
     *           6  21
     *          / \
     *         1   7
     *
     *      B = 9
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
     *  Node with value 16 is present.
     * Explanation 2:
     *
     *  There is no node with value 9.
     */

      class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
       val = x;
       left=null;
       right=null;
      }
  }

    int didFound = 0;
    public int solve(TreeNode A, int B) {

        if(search(A, B) != null) {
            didFound = 1;
        }

        return didFound;
    }

    private TreeNode search(TreeNode root, int target) {
        if(root == null) {
            return null;
        }
        if(root.val == target) {
            return root;
        }

        if(target < root.val) {
            return search(root.left, target);
        } else {
            return search(root.right, target);
        }
    }
}
