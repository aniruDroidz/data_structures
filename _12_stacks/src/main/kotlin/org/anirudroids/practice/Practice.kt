package org.anirudroids.practice

import java.util.Stack

class Practice {

    fun nextGreaterElement(arr: Array<Int>): Array<Int?> {
        val result = arrayOfNulls<Int>(arr.size)
        val stack = Stack<Int>()

        for(i in arr.size-1 downTo 0) {
            while(stack.isNotEmpty() && arr[i] >= stack.peek()) stack.pop()
            result[i] = if(stack.isEmpty()) -1 else stack.peek()
            stack.push(arr[i])
        }

        return result
    }
}