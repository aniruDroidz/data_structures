package org.anirudroids._55_views_and_types.problems.mandatory;

import java.util.*;

public class Q3_Vertical_Order_traversal {
    /**
     * Problem Description
     * Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example and image for more details.
     *
     *
     * NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.
     *
     *
     *
     * Problem Constraints
     * 0 <= number of nodes <= 105
     *
     *
     *
     * Input Format
     * First and only arument is a pointer to the root node of binary tree, A.
     *
     *
     *
     * Output Format
     * Return a 2D array denoting the vertical order traversal of tree as shown.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *       6
     *     /   \
     *    3     7
     *   / \     \
     *  2   5     9
     * Input 2:
     *
     *       1
     *     /   \
     *    3     7
     *   /       \
     *  2         9
     *
     *
     * Example Output
     * Output 1:
     *
     *  [
     *     [2],
     *     [3],
     *     [6, 5],
     *     [7],
     *     [9]
     *  ]
     * Output 2:
     *
     *  [
     *     [2],
     *     [3],
     *     [1],
     *     [7],
     *     [9]
     *  ]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  First row represent the verical line 1 and so on.
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

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(A, 0));

        int minDistance = 0;
        int maxDistance = 0;
        while(!queue.isEmpty()) {
            Pair removedPair = queue.poll();

            int currentDistance = removedPair.verticalLevel;

            minDistance = Math.min(minDistance, currentDistance);
            maxDistance = Math.max(maxDistance, currentDistance);
            if(map.get(removedPair.verticalLevel) == null) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(removedPair.node.val);
                map.put(removedPair.verticalLevel, list);
            } else {
                map.get(removedPair.verticalLevel).add(removedPair.node.val);
            }

            if(removedPair.node.left != null) {
                queue.offer(new Pair(removedPair.node.left, currentDistance-1));
            }

            if(removedPair.node.right != null) {
                queue.offer(new Pair(removedPair.node.right, currentDistance+1));
            }
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int index = minDistance; index <= maxDistance; index++) {
            result.add(map.get(index));
        }

        return result;
    }
}
