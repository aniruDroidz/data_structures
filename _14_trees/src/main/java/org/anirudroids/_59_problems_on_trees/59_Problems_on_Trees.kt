package org.anirudroids._59_problems_on_trees

import java.util.LinkedList
import java.util.Queue

class `59_Problems_on_Trees` {
    class TreeNode(val value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
        var next: TreeNode? = null
    }
    /**
     * Given a binary tree, write a function to invert the tree
     */
    fun first(root: TreeNode?) {
        if(root == null) {
            return
        }

        first(root.left)
        first(root.right)
        val temp = root.left
        root.left = root.right
        root.right = temp
    }

    /**
     * Given the root node of a binary tree. Return true if the tree can be split into two non-empty
     * subtrees with equal sums, false otherwise.
     */

    var totalSum = 0 // this needs to be calculated
    var ans = false
    fun sum(root: TreeNode?) : Int {
        if(root == null) {
            return 0
        }

        val sumOfLeftSubtree = sum(root.left)
        val sumOfRightSubtree = sum(root.right)

        if(sumOfLeftSubtree == totalSum/2 || sumOfRightSubtree == totalSum/2) {
            ans = true
        }

        return sumOfLeftSubtree + sumOfRightSubtree + root.value
    }

    /**
     * GIven a binary tree with all next pointers set to null, modify the tree in-place to the next
     * node in the same level from left to right
     */
    fun third(root: TreeNode?): TreeNode? {
        if(root == null) {
            return null
        }
        // Approach 1 - Using level order traversal
        val queue: Queue<TreeNode> = LinkedList()
        queue.offer(root)
        while(queue.isNotEmpty()) {
            val levelSize = queue.size
            for(i in 0..<levelSize) {
                val temp = queue.poll()
                if(i < levelSize-1) {
                    temp.next = queue.peek()
                }
                if(temp.left != null) {
                    queue.offer(temp.left)
                }
                if(temp.right != null) {
                    temp.right
                }
            }
        }
        // return root

        // Approach 2 - without extra space
        var curr = root

        while(curr != null) {
            var temp = curr
            while(temp != null) {
                temp.left?.next = temp.right
                temp.right?.next = temp.next?.left
                temp = temp.next
            }
            curr = curr.left
        }

        return root
    }

    /**
     * Given a binary tree, check if there exists a path from root to the leaf by adding all node values
     * along the path has sum = K.
     */
    fun forth(root: TreeNode?, k: Int) : Boolean{
        if(root == null) return false

        if(root.left == null && root.right == null) {
            return (k == root.value)
        }

        return forth(root.left, k - root.value) || forth(root.right, k - root.value)
    }

    /**
     * Given a binary tree. Find the length of the longest path between any two nodes (diameter of binary tree)
     */
    fun fifth(root: TreeNode?): Int {
        if(root == null) {
            return 0
        }

        // H.W. - Use post order

        return 0
    }
}