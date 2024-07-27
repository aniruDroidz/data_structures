fun main() {

}

class `45_Two_Pointers` {
    /**
     * Given a sorted integer array A of size N. Find any pair (i,j) such that
     * A[i] + A[j] = K
     * Note - unique elements
     */
    fun first(arr: Array<Int>, k: Int): Pair<Int, Int> {
        var i = 0
        var j = arr.size - 1

        while(i < j) {
            var sum = arr[i] + arr[j]

            if(sum > k) {
                j--
            } else if(sum < k) {
                i++
            } else {
                return Pair(i,j)
            }
        }

        return Pair(-1,-1)
    }

    /**
     * Given a sorted integer array A of size N. Find count of pair (i, j) s.t. A[i]+A[j] = K
     * Note - unique elements
     */
    fun second(arr: Array<Int>, k: Int): Int {
        var i = 0
        var j = arr.size - 1
        var count = 0
        while(i < j) {
            var sum = arr[i] + arr[j]

            if(sum > k) {
                j--
            } else if(sum < k) {
                i++
            } else {
                count++
                i++
                j--
            }
        }

        return count
    }

    /**
     * Given a sorted integer array A of size N. Find count of pair (i, j) s.t. A[i]+A[j] = K
     * Note - duplicate elements
     */
    fun third(arr: Array<Int>, k: Int): Int {
        var i = 0
        var j = arr.size - 1
        var count = 0
        while(i < j) {
            var sum = arr[i] + arr[j]

            if(sum > k) {
                j--
            } else if(sum < k) {
                i++
            } else {
                count++
                val a = arr[i]
                var aCount = 1
                while(a == arr[i]) {
                    i++
                    aCount++
                }
                val b = arr[j]
                var bCount = 1
                while(b == arr[j]) {
                    j--
                    bCount--
                }

                /*if(arr[i] == arr[j]) {

                    var sum = 1.0

                    // Calculate the value of n choose r using the
                    // binomial coefficient formula
                    for (i in 1..r) {
                        sum = sum * (n - r + i) / i
                    }
                }*/

            }
        }

        return count
    }

    /**
     * Given a sorted array of size N & an integer (k>0).
     * Find any pair (i,j) s.t. (A[j]-A[i] == k)
     */
    fun forth(arr: Array<Int>, k: Int): Pair<Int, Int> {
        var i = 0
        var j = 1

        while(j < arr.size) {
            val target = arr[j]-arr[i]

            if(target == k) {
                return Pair(i,j)
            } else if(target > k) {
                i++
            } else {
                j++
            }
        }

        return Pair(-1,-1)
    }

    /**
     * Given an integer array of +ve elements, check if a sub-array
     * with sum = k is present
     */
    fun fifth(arr: Array<Int>, k: Int): Boolean {
        val prefixSum = Array(arr.size) {0}

        prefixSum[0] = arr[0]
        for(i in 1..<arr.size) {
            prefixSum[i] = arr[i] + prefixSum[i-1]
        }
        var i = 0
        var j = 1
        // previous question solution
        while(j < arr.size) {
            val target = prefixSum[j]-prefixSum[i]

            if(target == k) {
                return true
            } else if(target > k) {
                i++
            } else {
                j++
            }
        }

        return false
    }

    /**
     * Given an integer array of size N representing the height of N walls.
     * Find any two walls that can form a container to store maximum amount of water.
     * 1. Volume = Area
     * 2.
     */
}