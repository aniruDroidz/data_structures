import java.util.*

class `53_Implementation_Problems` {
    /**
     *
     */
    class QueueUsingArray(val size: Int) {
        val arr = Array(size) {0}
        var rear = -1
        var front = 0

        fun enqueue(value: Int) {
            rear++
            arr[rear] = value
        }

        fun dequeue(): Int {
            if(isEmpty()) return -1
            front++

            return arr[front-1]
        }

        fun front(): Int {
            if(isEmpty()) return -1

            return arr[front]
        }

        fun isEmpty() = front > rear
    }

    class QueueUsingLinkedList() {
        class Node (val value: Int) {
            var next: Node? = null
        }

        val head: Node? = null
        var tail: Node? = null
        var rear = -1
        var front = 0

        fun enqueue(value: Int) {

        }

        fun dequeue(): Int {
            return 0
        }

        fun front(): Int? {
            return head?.value
        }

        fun rear() : Int? {
            return tail?.value
        }

        fun isEmpty(): Boolean {
            return tail == null
        }
    }

    class QueueUsingStack {
        val stack1 = Stack<Int>()
        val stack2 = Stack<Int>()
        fun enqueue(value: Int) {
            stack1.push(value)
        }

        fun dequeue() {
            if(isEmpty()) {

            }
        }

        fun isEmpty(): Boolean {
            return false
        }
    }

    fun first() {

    }

    /**
     * Given an integer array & an integer k. Find the max element for all
     * subarray of size k.
     */
    fun third(arr: Array<Int>, k: Int) {

    }
}