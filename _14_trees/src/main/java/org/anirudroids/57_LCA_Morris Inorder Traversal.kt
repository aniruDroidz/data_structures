import java.util.*
import kotlin.math.max
import kotlin.math.min

fun main() {
    val obj = `LCA_Morris Inorder Traversal`()
}
class `LCA_Morris Inorder Traversal` {

    class TreeNode(val value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
    class TreeNodeResult(val min: Int, val max: Int, val isBST: Boolean)
    /**
     * check if BT is valid BST
     */
    fun first(root: TreeNode?) : TreeNodeResult{
        if(root == null) {
            return TreeNodeResult(Int.MAX_VALUE, Int.MIN_VALUE, true)
        }

        val l = first(root.left)
        val r = first(root.right)

        if(l.isBST && r.isBST && root.value >= l.max && root.value < r.min)
            return TreeNodeResult(max(r.max, root.value), min(l.min, root.value), true)

        return TreeNodeResult(0, 0, false)
    }

    /**
     * Given a BST, return a kth smallest element
     */
    var count: Int = 0
    var ans: Int = Int.MIN_VALUE
    fun second(root: TreeNode?, k: Int) {
        // inorder
        if(root == null) {
            return
        }

        second(root.left, k)
        count++
        if(count == k) {
            ans = root.value
            return
        }
        second(root.right, k)
    }

    /**
     * Inorder traversal without recursion
     */
    fun third(root: TreeNode?) {
        if(root == null)
            return

        var current = root

        while(current != null) {
            if(current.left == null) {
                print(current.value)
                current = current.right
            } else {
                var inOrderPredecessor = current.left
                while (inOrderPredecessor?.right != null && inOrderPredecessor.right != current) {
                    inOrderPredecessor = inOrderPredecessor.right
                }

                if(inOrderPredecessor?.right == null) {
                    inOrderPredecessor?.right = current
                    current = current.left
                } else {
                    inOrderPredecessor.right = null
                    print(current.value)
                    current = current.right
                }
            }
        }
    }

    /**
     * Efficient search
     */
    fun forth(root: TreeNode?, k: Int): Boolean {
        if(root == null) {
            return false
        }

        if(root.value == k) {
            return true
        }

        return forth(root.left, k) || forth(root.right, k)
    }

    /**
     * Given a binary tree, find a path from root to a given node
     */
    var stack: Stack<Int> = Stack()
    fun fifth(root: TreeNode?, node: TreeNode?): Stack<Int> {
        if(root == null || root.value == node?.value) {
            return stack
        }

        stack.push(root.value)
        first(root.left)
        stack.pop()
        first(root.right)
        stack.pop()

        return stack
    }

    fun createPath(root: TreeNode?, queue: Deque<Int>, node: TreeNode?): Boolean {
        if(root == null) return false

        if(root.value == node?.value) return true

        var l = createPath(root.left, queue, node)
        if(l == true)
            return true
        var r = createPath(root.right, queue, node)
        if (r == true)
            return true

        queue.pollLast()
        return false
    }
}