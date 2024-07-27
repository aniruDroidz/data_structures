package org.anirudroids._55_views_and_types.problems.mandatory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q1_Level_Order {
    /**
     * Problem Description
     * Given a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
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
     * Return a 2D integer array denoting the level order traversal of the given binary tree.
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
     *    [9, 20],
     *    [15, 7]
     *  ]
     * Output 2:
     *
     *  [
     *    [1]
     *    [6, 2]
     *    [3]
     *  ]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  Return the 2D array. Each row denotes the traversal of each level.
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

    public ArrayList<ArrayList<Integer>> solve(TreeNode A) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        while(!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> internalList = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode n = queue.poll();
                internalList.add(n.val);
                if(n.left != null) queue.offer(n.left);
                if(n.right != null) queue.offer(n.right);
            }
            list.add(internalList);
        }

        return list;
    }
}
