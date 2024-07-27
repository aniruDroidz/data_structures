package org.anirudroids._48_problems_doubly_linked_list

class `48_Problems_Doubly_Linked_List` {
    class Node(val data: Int) {
        var previous: Node? = null
        var next: Node? = null
    }

    class LinkedListUsingHashMap(val capacity: Int) {
        var head: Node? = null
        var tail: Node? = null
        var map = mutableMapOf<Int, Node>()
        var size = 0
        fun insert(x: Int) {
            if(map.containsKey(x)) {
                val temp = map[x]
                if(temp == head) {
                    return
                }
                temp?.previous?.let {
                    it.next = temp.next
                }
                temp?.next?.let {
                    it.previous = temp.previous
                }
                // here somewhere we need to update the tail pointer
                temp?.next = head
                head?.previous = temp
                temp?.previous = null
                head = temp
            }
            if(size == capacity) {
                val temp = tail?.previous
                temp?.next = null
                tail = temp
                size--
                map.remove(temp?.data)
            }
            val newNode = Node(x)
            newNode.next = head
            head?.let {
                it.previous = newNode
            }
            head = newNode
            size++
            map[x] = newNode
        }
    }

    /**
     * Given the head node of a doubly linked list. Insert a node with data X at position K.
     */
    fun first(head: Node?, x: Int, k: Int): Node {
        val newNode = Node(x)
        head ?: kotlin.run { return newNode }

        if(k == 0) {
            newNode.next = head
            head.previous = newNode
            return newNode
        }

        var i = 0
        var curr: Node? = head.next
        var pre: Node? = head
        while(i < k-1) {
            curr = curr?.next
            pre = pre?.next
            i++
        }
        pre?.next = newNode
        newNode.previous = pre
        newNode.next = curr

        if(curr != null) {
            curr.previous = newNode
        }

        return head
    }

    /**
     * Given a doubly linked list of length N. Delete the first occurrence of data X in the linked list.
     */
    fun second(head: Node?, x: Int): Node? {
        if(head == null) {
            return head
        }

        if(head.data == x) {
            val newHead = head.next
            newHead?.previous = null
            return newHead
        }

        var curr: Node? = head.next
        while(curr != null) {
            if(curr.data == x) {
                break
            }
            curr = curr.next
        }

        val next = curr?.next
        val previous = curr?.previous
        previous?.next = next
        next?.previous = previous

        return head
    }

    /**
     * Implement a linked list using hashmap
     */
    fun third(head: Node) {
        val map = mutableMapOf<Int, Node>()

        var current: Node? = head
        while(current != null) {
            map[current.data] = current
            current = current.next
        }
    }

    /**
     * H.W. Figure out, how to update tail
     */
}
