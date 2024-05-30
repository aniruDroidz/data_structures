package `12_stacks`

import java.util.Stack

fun main() {

}

class `49_Implementation_And_Basics_Problems` {

    /**
     * Stack using array
     */
    class StackUsingArray {
        val arr: Array<Int> = Array(5) {0}
        var top = -1
        var size = 0

        fun push(x: Int) {
            if(top+1 == arr.size) return
            arr[++top] = x
            size++
        }

        fun peek(): Int {
            if(top == -1) return Int.MIN_VALUE
            return arr[top]
        }

        fun pop(): Int {
            if(top == -1) return Int.MIN_VALUE
            val x = arr[top]
            top--
            size--
            return x
        }

        fun size() = size

        fun isEmpty() = size == 0
    }



    /**
     * Stack using linked list
     */
    class StackUsingLinkedList<T> {
        inner class Node(val value: T) {
            var next: Node? = null
        }
        var head: Node? = null
        var size = 0
        fun insert(value: T) {
            size++
            if(head == null) {
                head = Node(value)
                return
            }

            val newNode = Node(value)
            newNode.next = head
            head = newNode
        }

        fun peek(): T? {
            if(head == null) {
                return null
            }

            return head?.value
        }

        fun pop(): T? {
            val value = head?.value
            if(value != null) size--
            head = head?.next
            return value
        }

        fun isEmpty() = size == 0
    }

    /**
     * Check whether a given sequence of parenthesis is valid
     */
    fun first(string: String): Boolean {
        val stackUsingLinkedList = StackUsingLinkedList<Char>()
        val map = mutableMapOf<Char, Char>()
        map['}'] = '{'
        map[']'] = '['
        map[')'] = '('
        for(char in string) {
            when(char) {
                '{', '[', '(' -> {
                    stackUsingLinkedList.insert(char)
                }
                ')', ']', '}' -> {
                    if(stackUsingLinkedList.pop() != map[char]) {
                        return false
                    }
                }
            }
        }

        return stackUsingLinkedList.isEmpty()
    }

    /**
     * Given a string, remove a pair of equal consecutive characters
     */
    fun second(string: String): String {
        val stack = Stack<Char>()
        for(char in string) {
            if(stack.peek() == char) {
                stack.pop()
            } else {
                stack.push(char)
            }
        }

        val stringBuilder = StringBuilder()
        while(!stack.isEmpty()) {
            stringBuilder.append(stack.pop())
        }

        return stringBuilder.reverse().toString()
    }

    /**
     * Post fix expressions
     */
    fun third(string: String) {
        var stack = Stack<Char>()

        for(char in string) {

        }
    }
}