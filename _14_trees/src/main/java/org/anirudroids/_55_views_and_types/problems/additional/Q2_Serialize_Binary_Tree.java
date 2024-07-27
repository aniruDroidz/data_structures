package org.anirudroids._55_views_and_types.problems.additional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q2_Serialize_Binary_Tree {
    /**
     * Problem Description
     * Given the root node of a Binary Tree denoted by A. You have to Serialize the given Binary Tree in the described format.
     *
     * Serialize means encode it into a integer array denoting the Level Order Traversal of the given Binary Tree.
     *
     * NOTE:
     *
     * In the array, the NULL/None child is denoted by -1.
     * For more clarification check the Example Input.
     *
     *
     * Problem Constraints
     * 1 <= number of nodes <= 105
     *
     *
     *
     * Input Format
     * Only argument is a A denoting the root node of a Binary Tree.
     *
     *
     *
     * Output Format
     * Return an integer array denoting the Level Order Traversal of the given Binary Tree.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *            1
     *          /   \
     *         2     3
     *        / \
     *       4   5
     * Input 2:
     *
     *             1
     *           /   \
     *          2     3
     *         / \     \
     *        4   5     6
     *
     *
     * Example Output
     * Output 1:
     *
     *  [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
     * Output 2:
     *
     *  [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  The Level Order Traversal of the given tree will be [1, 2, 3, 4, 5 , -1, -1, -1, -1, -1, -1].
     *  Since 3, 4 and 5 each has both NULL child we had represented that using -1.
     * Explanation 2:
     *
     *  The Level Order Traversal of the given tree will be [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1].
     *  Since 3 has left child as NULL while 4 and 5 each has both NULL child.
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

    public ArrayList<Integer> solve(TreeNode A) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);

        ArrayList<Integer> list = new ArrayList<>();

        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++){
                TreeNode n = queue.poll();
                list.add(n.val);
                if(n.left != null) { queue.offer(n.left); } else if(n.val != -1 ) { queue.offer(new TreeNode(-1)); }
                if(n.right != null) { queue.offer(n.right); } else if(n.val != -1 ) { queue.offer(new TreeNode(-1)); }
            }
        }

        return list;
    }
}
