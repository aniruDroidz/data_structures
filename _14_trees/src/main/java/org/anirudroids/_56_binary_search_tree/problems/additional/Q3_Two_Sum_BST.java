package org.anirudroids._56_binary_search_tree.problems.additional;

import java.util.Stack;

public class Q3_Two_Sum_BST {
    /**
     * Problem Description
     * Given a binary search tree A, where each node contains a positive integer, and an integer B, you have to find whether or not there exist two different nodes X and Y such that X.value + Y.value = B.
     *
     * Return 1 to denote that two such nodes exist. Return 0, otherwise.
     *
     *
     *
     * Problem Constraints
     * 1 <= size of tree <= 100000
     *
     * 1 <= B <= 109
     *
     *
     *
     * Input Format
     * First argument is the head of the tree A.
     *
     * Second argument is the integer B.
     *
     *
     *
     * Output Format
     * Return 1 if such a pair can be found, 0 otherwise.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *          10
     *          / \
     *         9   20
     *
     * B = 19
     * Input 2:
     *
     *
     *           10
     *          / \
     *         9   20
     *
     * B = 40
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
     *  10 + 9 = 19. Hence 1 is returned.
     * Explanation 2:
     *
     *  No such pair exists.
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

    public int t2Sum(TreeNode A, int B) {
        return find(A, B);
    }

    private int find(TreeNode A, int B) {

        Stack<TreeNode> forwardIterator = new Stack<>();
        Stack<TreeNode> backwardIterator = new Stack<>();

        TreeNode current = A;
        while(current != null) {
            forwardIterator.push(current);
            current = current.left;
        }

        current = A;
        while(current != null) {
            backwardIterator.push(current);
            current = current.right;
        }

        TreeNode forwardIteratorNode = forwardIterator.pop();
        TreeNode backwardIteratorNode = backwardIterator.pop();

        while(forwardIteratorNode.val < backwardIteratorNode.val) {

            if(forwardIteratorNode.val + backwardIteratorNode.val == B) {
                return 1;
            } else if(forwardIteratorNode.val + backwardIteratorNode.val > B) {
                current = backwardIteratorNode.left;
                while(current != null) {
                    backwardIterator.push(current);
                    current = current.right;
                }
                backwardIteratorNode = backwardIterator.pop();
            } else {
                current = forwardIteratorNode.right;
                while(current != null) {
                    forwardIterator.push(current);
                    current = current.left;
                }
                forwardIteratorNode = forwardIterator.pop();
            }
        }

        return 0;
    }
}
