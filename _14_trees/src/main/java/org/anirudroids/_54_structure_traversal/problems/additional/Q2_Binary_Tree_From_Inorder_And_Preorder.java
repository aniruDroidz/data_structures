package org.anirudroids._54_structure_traversal.problems.additional;

import java.util.ArrayList;

public class Q2_Binary_Tree_From_Inorder_And_Preorder {
    /**
     *Problem Description
     * Given preorder and inorder traversal of a tree, construct the binary tree.
     *
     * NOTE: You may assume that duplicates do not exist in the tree.
     *
     *
     *
     * Problem Constraints
     * 1 <= number of nodes <= 105
     *
     *
     *
     * Input Format
     * First argument is an integer array A denoting the preorder traversal of the tree.
     *
     * Second argument is an integer array B denoting the inorder traversal of the tree.
     *
     *
     *
     * Output Format
     * Return the root node of the binary tree.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [1, 2, 3]
     *  B = [2, 1, 3]
     * Input 2:
     *
     *  A = [1, 6, 2, 3]
     *  B = [6, 1, 3, 2]
     *
     *
     * Example Output
     * Output 1:
     *
     *    1
     *   / \
     *  2   3
     * Output 2:
     *
     *    1
     *   / \
     *  6   2
     *     /
     *    3
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  Create the binary tree and return the root node of the tree.
     */

      static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
      val = x;
       left=null;
       right=null;
      }
 }

    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        if(A.isEmpty() || A.size() != B.size()) {
            return null;
        }
        return buildTree(A, B, 0, A.size()-1, 0, B.size()-1);
    }

    private static TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B, int preorderStart, int preorderEnd, int inorderStart, int inorderEnd) {
        if(preorderStart > preorderEnd || inorderStart > inorderEnd) {
            return null;
        }
        TreeNode root = new TreeNode(A.get(preorderStart));

        int i;
        for(i = inorderStart; i <= inorderEnd; i++) {
            if(B.get(i) == root.val) {
                break;
            }
        }

        int count = i - inorderStart;
        root.left = buildTree(A, B, preorderStart+1, preorderStart+count, inorderStart, i - 1);
        root.right = buildTree(A, B, preorderStart+count+1, preorderEnd, i+1, inorderEnd);

        return root;
    }
}
