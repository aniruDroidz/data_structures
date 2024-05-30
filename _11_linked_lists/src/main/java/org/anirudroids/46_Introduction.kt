fun main() {
    val introduction = `46_Introduction`()
}

class `46_Introduction` {
    class Node(val data: Int) {
        var next: Node? = null
    }
    /**
     * Given an integer array of size N. Create a linked list and return its head.
     */

    fun first(arr: Array<Int>): Node {
        val head = Node(arr[0])
        var currentNode: Node? = head
        for(i in 1..<arr.size) {
            currentNode?.next = Node(arr[i])
            currentNode = currentNode?.next
        }

        return head
    }

    /**
     * Given the head node of a linked list. Return the element on kth index
     */
    fun second(head: Node, k: Int): Int? {
        var ans: Node? = head
        for(i in 0..<k) {
            ans = ans?.next
        }
        
        return ans?.data
    }

    /**
     * Given a linked list. Return true if there is a data k present in any node of linked list.
     */
    fun third(head: Node, k: Int): Boolean {
        var ans: Node? = head
        while(ans != null) {
            if(ans.data == k) {
                return true
            }
            ans = ans.next
        }

        return false
    }

    /**
     * Given a linked list. Return its size.
     */
    fun forth(head: Node) : Int {
        var size = 0
        var ans: Node? = head
        while(ans != null) {
            size++
            ans = ans.next
        }

        return size
    }

    /**
     * Given a linked list. Insert a new node with data k at the index p
     */
    fun fifth(head: Node, k: Int, p: Int): Node {
        val newNode = Node(k)
        if(p == 0) {
            newNode.next = head
            return newNode
        }

        var currentNode: Node? = head

        for(i in 0..<p-1) {
            currentNode = currentNode?.next
        }


        newNode.next = currentNode?.next
        currentNode?.next = newNode

        return head
    }

    /**
     * Given a linked list. Delete the first occurrence of k in the linked list.
     */
    fun sixth(_head: Node?, k: Int): Node? {
        var head = _head
        if(head == null) {
            return head
        }

        if(head.data == k) {
            val temp = head.next
            head.next = null
            head = temp
            return head
        }
        var temp = head

        while(temp?.next != null) {
            if(temp.next?.data == k) {
                temp.next = temp.next?.next
                return head
            }
            temp = temp.next
        }

        return head
    }

    /**
     * Given a linked list, reverse & return the new head
     */
    fun seventh(_head: Node?): Node? {
        if(_head == null) {
            return _head
        }
        var head = _head
        var previous: Node? = head
        var current: Node? = head.next

        while(current != null) {
            val next = current.next
            current.next = previous
            previous = current
            current = next
        }

        head.next = null
        head = previous
        return head
    }

    /**
     * Given a linked list. Return true if it is a palindrome
     */
    fun eightth(_head: Node?) {
        if (_head == null) {
            return
        }
    }
}
