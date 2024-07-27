package org.anirudroids._55_views_and_types.problems.additional;

import java.util.*;

public class Q4_Top_View_of_Binary_tree {
    /**
     * Problem Description
     * Given a binary tree of integers denoted by root A. Return an array of integers representing the top view of the Binary tree.
     *
     * The top view of a Binary Tree is a set of nodes visible when the tree is visited from the top.
     *
     * Return the nodes in any order.
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
     * Return an array, representing the top view of the binary tree.
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
     *  [1, 2, 4, 8, 3, 7]
     * Output 2:
     *
     *  [1, 2, 3]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     * Top view is described.
     * Explanation 2:
     *
     * Top view is described.
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

    private class Pair {
        TreeNode node;
        int verticalLevel;
        public Pair(TreeNode node, int verticalLevel) {
            this.node = node;
            this.verticalLevel = verticalLevel;
        }
    }

    public ArrayList<Integer> solve(TreeNode A) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(A, 0));

        int minDistance = 0;
        int maxDistance = 0;
        while(!queue.isEmpty()) {
            Pair removedPair = queue.poll();

            int currentDistance = removedPair.verticalLevel;

            minDistance = Math.min(minDistance, currentDistance);
            maxDistance = Math.max(maxDistance, currentDistance);

            map.computeIfAbsent(removedPair.verticalLevel, k -> removedPair.node.val);

            if(removedPair.node.left != null) {
                queue.offer(new Pair(removedPair.node.left, currentDistance-1));
            }

            if(removedPair.node.right != null) {
                queue.offer(new Pair(removedPair.node.right, currentDistance+1));
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for(int index = minDistance; index <= maxDistance; index++) {
            result.add(map.get(index));
        }

        return result;
    }
}
