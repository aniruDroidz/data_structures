package `11_linked_lists`

class `47_Sorting_and_Detecting_Loop` {
    class Node(val data: Int) {
        var next: Node? = null
    }
    /**
     * Given a linked list. Find and return middle node of linked list.
     */
    fun first(head: Node): Node? {
        var slow: Node? = head
        var fast: Node? = head
        while (fast?.next != null && fast.next?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        return slow
    }

    /**
     * Given a linked lists. Merge them & return the head.
     */
    fun merge(_head1: Node?, _head2: Node?): Node? {
        var head1: Node? = _head1
        var head2: Node? = _head2
        var result: Node
        if(head1!!.data <= head2!!.data) {
            result = head1
            head1 = head1.next
        } else {
            result = head2
            head2 = head2.next
        }

        var temp: Node? = result
        while (head1 != null && head2 != null) {
            if(head1.data <= head2.data) {
                temp?.next = head1
                head1 = head1.next
            } else {
                temp?.next = head2
                head2 = head2.next
            }
            temp = temp?.next
        }

        if(head1 == null) {
            temp?.next = head2
        } else {
            temp?.next = head1
        }

        return result
    }

    /**
     * Given a linked list. Sort it using merge sort.
     */
    fun mergeSort(head: Node?): Node? {
        // find the mid
        // recursively call 0-m & m+1 to n

        if(head?.next == null) {
            return head
        }

        var slow: Node? = head
        var fast: Node? = head
        while (fast?.next != null && fast.next?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }
        val mid = slow

        var h2 = mid?.next
        mid?.next = null

        val h1 = mergeSort(head)
        h2 = mergeSort(h2)

        return merge(h1, h2)
    }

    /**
     * Given a linked list. Check if it is circular
     */
    fun second(head: Node): Boolean {
        var slow: Node? = head
        var fast: Node? = head

        while(fast != null || fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
            if(slow == fast) {
                return true
            }
        }
        return false
    }

    /**
     * Given a linked list. Return the fist (start) node of the cycle
     */
    fun third(head: Node): Node? {
        var slow: Node? = head
        var fast: Node? = head

        while(fast != null || fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
            if(slow == fast) {
                slow = head

                while(slow != fast) {
                    slow = slow?.next
                    fast = fast?.next
                }
                return slow
            }
        }
        return null
    }
}