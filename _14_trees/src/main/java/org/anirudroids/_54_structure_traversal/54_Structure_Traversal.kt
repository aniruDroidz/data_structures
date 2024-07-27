import java.util.*

fun main() {
    val main = `54_Structure_Traversal`()

}

class `54_Structure_Traversal` {

    class Node(val data: Int) {
        var left: Node? = null
        var right: Node? = null
    }

    /**
     * Pre-order traversal
     */
    fun first(head: Node?) {
        if(head == null) {
            return
        }
        print(head)
        first(head.left)
        first(head.right)
    }

    /**
     * In-order
     */
    fun second(head: Node?) {
        if(head == null) {
            return
        }
        first(head.left)
        print(head)
        first(head.right)
    }

    /**
     * Post-order
     */
    fun third(head: Node?) {
        if(head == null) {
            return
        }
        first(head.left)
        first(head.right)
        print(head)
    }

    /**
     * In-order using iterative manner
     */
    fun forth(head: Node?) {
        val stack = Stack<Node?>()
        var curr = head

        while(curr != null || !stack.isEmpty()) {
            if(curr != null) {
                stack.push(curr)
                curr = curr.left
            } else {
                curr = stack.pop()
                print(curr?.data)
                curr = curr?.right
            }
        }

    }
}