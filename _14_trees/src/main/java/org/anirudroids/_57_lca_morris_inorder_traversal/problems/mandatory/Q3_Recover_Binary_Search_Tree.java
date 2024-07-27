package org.anirudroids._57_lca_morris_inorder_traversal.problems.mandatory;

import java.util.ArrayList;
import java.util.Collections;

public class Q3_Recover_Binary_Search_Tree {
    /**
     * Problem Description
     * Two elements of a Binary Search Tree (BST), represented by root A are swapped by mistake. Tell us the 2 values, when swapped, will restore the Binary Search Tree (BST).
     *
     * A solution using O(n) space is pretty straightforward. Could you devise a constant space solution?
     *
     * Note: The 2 values must be returned in ascending order
     *
     *
     *
     * Problem Constraints
     * 1 <= size of tree <= 100000
     *
     *
     *
     * Input Format
     * First and only argument is the head of the tree,A
     *
     *
     *
     * Output Format
     * Return the 2 elements which need to be swapped.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *          1
     *         / \
     *        2   3
     * Input 2:
     *
     *
     *          2
     *         / \
     *        3   1
     *
     *
     *
     * Example Output
     * Output 1:
     *
     *  [2, 1]
     * Output 2:
     *
     *  [3, 1]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     * Swapping 1 and 2 will change the BST to be
     *          2
     *         / \
     *        1   3
     * which is a valid BST
     * Explanation 2:
     *
     * Swapping 1 and 3 will change the BST to be
     *          2
     *         / \
     *        1   3
     * which is a valid BST
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

    public ArrayList<Integer> recoverTree(TreeNode A) {

        ArrayList<Integer> result = new ArrayList<>();

        int previous = Integer.MIN_VALUE;
        TreeNode current = A;

        while(current != null) {
            if(current.left == null) {
                if(previous < current.val) {
                    previous = current.val;
                } else if(previous > current.val) {
                    if(result.isEmpty()) {
                        result.add(previous);
                        result.add(current.val);
                    } else {
                        result.set(1, current.val);
                    }
                    previous = current.val;
                }

                current = current.right;
            } else {

                TreeNode inorderPredecessor = current.left;
                while(inorderPredecessor.right != null && inorderPredecessor.right != current) {
                    inorderPredecessor = inorderPredecessor.right;
                }

                if(inorderPredecessor.right == null) {
                    inorderPredecessor.right = current;
                    current = current.left;
                } else {
                    if(previous > current.val) {
                        if(result.size() == 0) {
                            result.add(previous);
                            result.add(current.val);
                        } else {
                            result.set(1, current.val);
                        }
                        previous = current.val;
                    } else {
                        previous = current.val;
                    }
                    inorderPredecessor.right = null;
                    current = current.right;
                }
            }
        }

        Collections.sort(result);
        return result;
    }
}
