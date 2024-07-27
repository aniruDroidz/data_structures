package org.anirudroids._57_lca_morris_inorder_traversal.problems.mandatory;

public class Q2_Kth_Smallest_Element_In_BST {
    /**
     * Problem Description
     * Given a binary search tree represented by root A, write a function to find the Bth smallest element in the tree.
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
     * Return an integer, representing the Bth element.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *
     *             2
     *           /   \
     *          1    3
     * B = 2
     * Input 2:
     *
     *
     *             3
     *            /
     *           2
     *          /
     *         1
     * B = 1
     *
     *
     *
     * Example Output
     * Output 1:
     *
     *  2
     * Output 2:
     *
     *  1
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     * 2nd element is 2.
     * Explanation 2:
     *
     * 1st element is 1.
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

    int count = 0;
    int result = Integer.MIN_VALUE;
    public int kthsmallest(TreeNode A, int B) {

        find(A, B);

        return result;
    }

    private void find(TreeNode A, int B) {
        if(A == null) return;

        find(A.left, B);
        count++;
        if(count == B) {
            result = A.val;
            return;
        }

        if(result == Integer.MIN_VALUE) find(A.right, B);
    }
}
