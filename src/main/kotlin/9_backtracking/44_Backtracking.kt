package `9_backtracking`

fun main() {
    val backtracking = `44_Backtracking`()

}

class `44_Backtracking` {

    /**
     * Given A[n] of distinct integers print all subsets using recursion.
     */
    fun first(arr: Array<Int>, index: Int, res: ArrayList<Int>) {
        if(index == arr.size) {
            println(res)
            return
        }

        res.add(arr[index])
        first(arr, index.inc(), res)
        res.removeAt(res.size - 1)
        first(arr, index.inc(), res)
    }

    /**
     * Given a character array with distinct elements. Print all permutations of it without modifying it.
     */
    fun second(arr: CharArray, index: Int, ans: CharArray, visited: BooleanArray) {
        if(index == arr.size) {
            println(ans)
            return
        }

        for(i in arr.indices) {
            if(!visited[i]) {
                visited[i] = true
                ans[index] = arr[i]
                second(arr, index+1, ans, visited)
                visited[i] = false
            }
        }
    }
}