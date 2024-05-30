package `14_trees`


fun main() {
    val obj = `58_Trees_Follow-up`()
}

class `58_Trees_Follow-up`
{
    class TreeNode(val value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    /**
     * Given a binary tree, check if it is a binary search tree.
     */
    fun first(root: TreeNode) {
        // approach 1 - check if inorder traversal is sorted
        // approach 2 - for all nodes
        //              1. node.data >= x.data in left sub tree
        //              2. node.data < y.data in right sub tree
        // approach 3 - Post Order
        // approach 4 - Optimal Pre-Order

        isBSTApproach4(root, Int.MAX_VALUE, Int.MIN_VALUE)
    }

    fun isBSTApproach4(a: TreeNode?, maxValue: Int, minValue: Int): Boolean {
        if(a == null) {
            return true
        }

        if(a.value !in minValue..maxValue) {
            return false
        }

        return isBSTApproach4(a.left, a.value, minValue) && isBSTApproach4(a.right, maxValue, a.value)
    }

    /**
     * LCA - lowest common ancestor
     */
    fun second(root: TreeNode) {

    }

    /**
     * Given 2 nodes u & v
     * find the path,
     * 1. root to u
     * 2. root to v
     *
     * find the common node between both the paths
     */
    fun findLCA(root: TreeNode?, u: TreeNode, v: TreeNode): TreeNode? {
        if(root == null) {
            return null
        }

        var curr = root

        while(curr != null) {
            curr = if(u.value < curr.value && v.value < curr.value)
                curr.left
            else if(u.value > curr.value && v.value > curr.value) {
                curr.right
            } else {
                return curr
            }
        }

        return null
    }

    class InTimeOutTimeNode(val value: Int) {
        var inTime: Int = -1
        var outTime: Int = -1
        var left: InTimeOutTimeNode? = null
        var right: InTimeOutTimeNode? = null
    }

    private var time: Int = 0
    /**
     * In-time Out-time
     */
    fun forth(root: InTimeOutTimeNode?) {
        if(root == null) {
            return
        }

        root.inTime = time++
        forth(root.left)
        forth(root.right)
        root.outTime = time++
    }
}