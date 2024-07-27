package org.anirudroids._57_lca_morris_inorder_traversal.problems.additional;

public class Q1_Common_Nodes_in_Two_BST {
    /**
     * Problem Description
     * Given two BST's A and B, return the (sum of all common nodes in both A and B) % (109 +7) .
     *
     * In case there is no common node, return 0.
     *
     * NOTE:
     *
     * Try to do it one pass through the trees.
     *
     *
     *
     * Problem Constraints
     * 1 <= Number of nodes in the tree A and B <= 105
     *
     * 1 <= Node values <= 106
     *
     *
     *
     * Input Format
     * First argument represents the root of BST A.
     *
     * Second argument represents the root of BST B.
     *
     *
     *
     * Output Format
     * Return an integer denoting the (sum of all common nodes in both BST's A and B) % (109 +7) .
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  Tree A:
     *     5
     *    / \
     *   2   8
     *    \   \
     *     3   15
     *         /
     *         9
     *
     *  Tree B:
     *     7
     *    / \
     *   1  10
     *    \   \
     *     2  15
     *        /
     *       11
     * Input 2:
     *
     *   Tree A:
     *     7
     *    / \
     *   1   10
     *    \   \
     *     2   15
     *         /
     *        11
     *
     *  Tree B:
     *     7
     *    / \
     *   1  10
     *    \   \
     *     2  15
     *        /
     *       11
     *
     *
     * Example Output
     * Output 1:
     *
     *  17
     * Output 2:
     *
     *  46
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  Common Nodes are : 2, 15
     *  So answer is 2 + 15 = 17
     * Explanation 2:
     *
     *  Common Nodes are : 7, 2, 1, 10, 15, 11
     *  So answer is 7 + 2 + 1 + 10 + 15 + 11 = 46
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

    public int solve(TreeNode A, TreeNode B) {
        long ans=0;
        int mod=1000000007;

        TreeNode currentA = getNextNode(A);
        TreeNode currentB = getNextNode(B);
        while(currentA != null && currentB != null){
            if(currentA.val == currentB.val){
                ans = ans+currentA.val;
                ans = ans%mod;
                currentA = getNextNode(currentA.right);
                currentB = getNextNode(currentB.right);
            }
            else if(currentA.val < currentB.val){
                currentA = getNextNode(currentA.right);
            }
            else {
                currentB = getNextNode(currentB.right);
            }
        }
        return (int)(ans%mod);
    }

    public TreeNode getNextNode(TreeNode A){
        TreeNode current = A;
        while(current!=null){
            if(current.left==null){
                return current;
            }
            else{
                TreeNode inorderPredecessor=current.left;
                while(inorderPredecessor.right != null && inorderPredecessor.right != current){
                    inorderPredecessor = inorderPredecessor.right;
                }
                if(inorderPredecessor.right==null){
                    inorderPredecessor.right=current;
                    current=current.left;
                }
                else{
                    inorderPredecessor.right=null;
                    return current;
                }
            }
        }
        return current;
    }
}
