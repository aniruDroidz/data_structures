package org.anirudroids

fun main() {
    val arr = Array<IntArray>(3) { intArrayOf() }

    arr[0] = intArrayOf(3,2,1)
    arr[1] = intArrayOf(1,7,6)
    arr[2] = intArrayOf(2,7,7)

    print(equalPairs(arr))
}

fun equalPairs(grid: Array<IntArray>): Int {
    val rowsMap = mutableMapOf<List<Int>, Int>()

    for(intArray in grid) {
        rowsMap[intArray.toList()] = (rowsMap[intArray.toList()] ?: 0) + 1
    }

    var output = 0
    for(columnIndex in grid.first().indices) {
        val array = IntArray(grid.size) {0}
        for(rowIndex in grid.indices) {
            array[rowIndex] = grid[columnIndex][rowIndex]
        }

        rowsMap[array.toList()]?.let {
            output += it
        }
    }

    return output
}

fun closeStrings(word1: String, word2: String): Boolean {
    if(word1.length != word2.length) return false

    val map1 = mutableMapOf<Char, Int>()

    for(ch in word1.toCharArray()) {
        map1[ch] = (map1[ch] ?: 0) + 1
    }

    val map2 = mutableMapOf<Char, Int>()

    for(ch in word2.toCharArray()) {
        if(!map1.containsKey(ch)) return false
        map2[ch] = (map2[ch] ?: 0) + 1
    }

    return map1.values.sorted() == map2.values.sorted()
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