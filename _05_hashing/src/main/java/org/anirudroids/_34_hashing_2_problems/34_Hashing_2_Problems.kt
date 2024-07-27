fun main() {
    val obj = `34_Hashing_2_Problems`()
    obj.second(arrayOf(2,5,2,5,8,5,2,8), 10)
}

class `34_Hashing_2_Problems` {
    /**
     * Given an integer array of size N & an integer K. Check if there exist a pair (i, j) such that,
     * 1. A[i] + A[j] = K
     * 2. i != j
     */

    fun first(arr: Array<Int>, k: Int): Boolean {
        val set = HashSet<Int>()

        for (element in arr) {
            if (set.contains(k - element)) {
                return true
            }
            set.add(element)
        }
        return false
    }

    /**
     * Given an integer array of size N & an integer K.
     * Find count of pairs (i, j) such that (i != j) & (A[i] + A[j] == K)
     */
    fun second(arr: Array<Int>, k: Int) {
        val map = HashMap<Int, Int>()
        var ans = 0
        for (i in arr.size-1 downTo 0) {
            val element = arr[i]
            map[k-element]?.let {
                ans = ans.plus(it)
            }
            map[element]?.let {
                map[element] = it.inc()
            } ?: kotlin.run { map[element] = 1 }
        }
        println(ans)
    }

    /**
     *
     */
    fun third(arr: Array<Int>, k: Int) {}

    /**
     * Given an integer array of size N & an integer K
     * Find the count of distinct elements in every sliding window of size K.
     */
    fun forth(arr: Array<Int>, k: Int) {

    }
}