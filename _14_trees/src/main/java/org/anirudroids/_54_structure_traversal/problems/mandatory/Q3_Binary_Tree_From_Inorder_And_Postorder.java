package org.anirudroids._54_structure_traversal.problems.mandatory;

import java.util.ArrayList;
import java.util.HashMap;

public class Q3_Binary_Tree_From_Inorder_And_Postorder {
    /**
     * Problem Description
     * Given the inorder and postorder traversal of a tree, construct the binary tree.
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
     * First argument is an integer array A denoting the inorder traversal of the tree.
     *
     * Second argument is an integer array B denoting the postorder traversal of the tree.
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
     *  A = [2, 1, 3]
     *  B = [2, 3, 1]
     * Input 2:
     *
     *  A = [6, 1, 3, 2]
     *  B = [6, 3, 2, 1]
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

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<A.size(); i++){
            map.put(A.get(i), i);
        }
        return buildTree(A, 0, A.size()-1, B, 0, B.size()-1, map);
    }

    public TreeNode buildTree(ArrayList<Integer> A, int inorderStart, int inorderEnd,
                              ArrayList<Integer> B, int postorderStart, int postorderEnd, HashMap<Integer, Integer> map)
    {
        if(postorderStart > postorderEnd || inorderStart > inorderEnd){
            return null;
        }

        TreeNode root = new TreeNode(B.get(postorderEnd));
        int index = map.get(root.val);
        int numsLeft = index - inorderStart;

        root.left = buildTree(A, inorderStart, index-1, B, postorderStart, postorderStart + numsLeft - 1, map);
        root.right = buildTree(A, index+1, inorderEnd, B, postorderStart + numsLeft, postorderEnd - 1, map);

        return root;
    }
}
