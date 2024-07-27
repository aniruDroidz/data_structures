package org.anirudroids._55_views_and_types.problems.additional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q1_ZigZag_Level_Order_Traversal_BT {
    /**
     * Problem Description
     * Given a binary tree, return the zigzag level order traversal of its nodes values. (ie, from left to right, then right to left for the next level and alternate between).
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
     * Return a 2D integer array denoting the zigzag level order traversal of the given binary tree.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
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
     *  [
     *    [3],
     *    [20, 9],
     *    [15, 7]
     *  ]
     * Output 2:
     *
     *  [
     *    [1]
     *    [2, 6]
     *    [3]
     *  ]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  Return the 2D array. Each row denotes the zigzag traversal of each level.
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

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        if(A == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();


        boolean ltr = true;
        while(!queue.isEmpty()) {
            int levelSize = queue.size();

            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0 ; i < levelSize; i++) {
                list.add(-1);
            }

            for(int i = 0 ; i < levelSize; i++) {
                TreeNode current = queue.poll();

                if(ltr) {
                    list.set(i, current.val);
                } else {
                    list.set(levelSize-i-1, current.val);
                }

                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
            }
            result.add(list);
            ltr = !ltr;
        }

        return result;
    }
}
