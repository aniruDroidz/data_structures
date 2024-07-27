import java.util.LinkedList
import java.util.Queue
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min


fun main() {
    val viewAndTypes = `55_Views_And_Types`()

}

class `55_Views_And_Types` {

    class TreeNode(val value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    /**
     * Level order traversal
     */
    fun first(root: TreeNode) {
        var queue: Queue<TreeNode> = LinkedList()
        queue.offer(root)

        while (queue.isNotEmpty()) {
            val remove = queue.poll()
            print(remove.value)
            if(remove.left != null) queue.offer(remove.left)
            if(remove.right != null) queue.offer(remove.right)
        }

        // T.C. = O(n)
        // S.C. = O(n)

        // Left View
        queue = LinkedList()
        queue.offer(root)

        while (queue.isNotEmpty()) {
            val size = queue.size
            for(i in 1..size) {
                val remove = queue.poll()
                if(i==1) print(remove.value)
                if (remove.left != null) queue.offer(remove.left)
                if (remove.right != null) queue.offer(remove.right)
            }
        }

        // Right View
        queue = LinkedList()
        queue.offer(root)

        while (queue.isNotEmpty()) {
            val size = queue.size
            for(i in 1..size) {
                val remove = queue.poll()
                if(i==size) print(remove.value)
                if (remove.left != null) queue.offer(remove.left)
                if (remove.right != null) queue.offer(remove.right)
            }
        }
    }

    /**
     * Vertical Order Traversal (Asked in companies like microsoft)
     */
    class Pair1(val node: TreeNode?, val verticalLevel: Int)
    fun second(root: TreeNode) {
        val q: Queue<Pair1> = LinkedList()
        val rPair = Pair1(root, 0)

        val map = mutableMapOf<Int, ArrayList<TreeNode>>()

        q.offer(rPair)

        var minVl = 0
        var maxVl = 0

        while(q.isNotEmpty()) {
            val removePair = q.poll()
            minVl = min(minVl, removePair.verticalLevel)
            maxVl = max(maxVl, removePair.verticalLevel)
            removePair.node?.let {
                map.get(removePair.verticalLevel)?.add(it)
            }

            if(removePair.node?.left != null) {
                q.offer(Pair1(removePair.node?.left, removePair.verticalLevel-1))
            }

            if(removePair.node?.right != null) {
                q.offer(Pair1(removePair.node?.right, removePair.verticalLevel+1))
            }
        }

        // for loop
    }

    /**
     *
     */
    var isBalanced = true
    fun height(root: TreeNode?): Int {
        if(root == null) return -1
        val lh = height(root.left)
        val rh = height(root.right)

        if(abs(lh-rh) > 1) {
            isBalanced = false
        }
        return max(lh, rh) + 1
    }

    /**
     * Check if given binary search tree is balanced
     */
    fun isHeightBal(root: TreeNode?): Boolean {
        if(root == null) return true
        val lh = height(root.left)
        val rh = height(root.right)
        if(abs(lh-rh) > 1) {
            return false
        }

        return isHeightBal(root.left) && isHeightBal(root.right)
    }
}