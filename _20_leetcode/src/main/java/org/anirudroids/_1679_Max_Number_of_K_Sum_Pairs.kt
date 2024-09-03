package org.anirudroids

fun main() {
    val set = intArrayOf(1,2,3).toSet()
}

fun maxOperations(nums: IntArray, k: Int): Int {
    nums.sort()

    var i = 0
    var j = nums.size-1

    var count = 0
    while(i < j) {
        val sum = nums[i] + nums[j]

        if (sum == k) {
            count = count.inc()
            i = i.inc()
            j = j.dec()
        } else if(sum < k) {
            i = i.inc()
        } else {
            j = j.dec()
        }
    }


    return count
}