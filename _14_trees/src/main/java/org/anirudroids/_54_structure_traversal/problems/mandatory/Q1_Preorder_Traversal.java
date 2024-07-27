package org.anirudroids._54_structure_traversal.problems.mandatory;

import java.util.ArrayList;

public class Q1_Preorder_Traversal {
    /**
     * Problem Description
     * Given a binary tree, return the preorder traversal of its nodes values.
     *
     *
     *
     * Problem Constraints
     * 1 <= number of nodes <= 105
     *
     *
     *
     * Input Format
     * First and only argument is root node of the binary tree, A.
     *
     *
     *
     * Output Format
     * Return an integer array denoting the preorder traversal of the given binary tree.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *    1
     *     \
     *      2
     *     /
     *    3
     * Input 2:
     *
     *    1
     *   / \
     *  6   2
     *     /
     *    3
     *
     *
     * Example Output
     * Output 1:
     *
     *  [1, 2, 3]
     * Output 2:
     *
     *  [1, 6, 2, 3]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  The Preoder Traversal of the given tree is [1, 2, 3].
     * Explanation 2:
     *
     *  The Preoder Traversal of the given tree is [1, 6, 2, 3].
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

    private ArrayList<Integer> arrayList = new ArrayList<>();
    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        preorder(A);

        return arrayList;
    }

    private void preorder(TreeNode A) {
        if(A == null) {
            return;
        }

        arrayList.add(A.val);
        preorder(A.left);
        preorder(A.right);
    }
}
