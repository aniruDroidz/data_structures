import java.util.Stack

class `52_Nearest_Smaller_Greater_Element` {

    /**
     * Given an integer array A.
     * For all the elements, find the index of the nearest smaller element on the left of i.
     */
    fun first(arr: Array<Int>) {
        // Brute force

        val result1 = Array(arr.size) {-1}

        for(i in 1..<arr.size) {
            for(j in i-1..0) {
                if(arr[j] < arr[i]) {
                    result1[i] = arr[j]
                }
            }
        }

        // Optimised approach
        val result2 = Array(arr.size) {-1}
        val stack = Stack<Int>()

        for(i in arr.indices) {
            if(stack.isNotEmpty()) {
                while(stack.isNotEmpty() && arr[stack.peek()] >= arr[i]) {
                    stack.pop()
                }
                if(stack.isEmpty()) {
                    result2[i] = -1
                } else {
                    result2[i] = stack.peek()
                }
            }

            stack.push(i)
        }
    }

    /**
     * Largest rectangle histogram
     * Given an integer array A where A[i] => Height of the ith bar in the histogram
     * width of each bar is 1
     * Find the area of the largest rectangle formed by continuous bars
     */
    fun second(arr: Array<Int>) {
        // Brute force approach
        var max1 = Int.MIN_VALUE
        for(i in arr.indices) {
            var min = Int.MAX_VALUE
            for(j in i..<arr.size) {
                min = min.coerceAtMost(arr[j])
                max1 = max1.coerceAtLeast(min * j - i + 1)
            }
        }

        // Optimised approach
        // Notes
    }

    /**
     * Given an integer array of size N. For all subarrays we need to find max-min & return the sum of all.
     */
    fun third(arr: Array<Int>) {

    }
}