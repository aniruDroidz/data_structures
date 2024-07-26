package org.anirudroids._1_arrays._17_arrays_1_one_diamentional

/**
 * Rain water trapping
 * Kadane's subarray
 */

fun main() {

}

fun findSubArrayWithMaximumSum(arrayOf: Array<Int>) {
    var ans = arrayOf[0]

    for(index in arrayOf.indices) {
        for(j in index..<arrayOf.size) {
            var sum = 0

            for(k in index..j) {
                sum += arrayOf[k]
            }

            if(sum > ans) {
                ans = sum
            }
        }
    }

    print(ans)
    //2nd approach
    //Prefix sum - N^2

    //3rd approach
    //Carry forward
    var ans3 = arrayOf[0]

    for(index in arrayOf.indices) {
        var sum = 0
        for(j in index..<arrayOf.size) {
            sum += arrayOf[j]
            if (sum > ans) {
                ans3 = sum
            }
        }
    }

    print(ans3)
    // Relation - Kadane's subarray
    var ans4 = arrayOf[0]
    var curSum = 0
    for(index in arrayOf.indices) {
        curSum += arrayOf[index]
        if(curSum > ans) {
            ans4 = curSum
        }

        if(curSum < 0) {
            curSum = 0
        }
    }

    print(ans4)

    // Get subarray as well - track s and e
}

fun findMinimumSubArraySum() {
    // Multiply -1 to all elements
}

/**
 * Given an array A where every element is 0 return a final array after performing multiple queries
 * Query(i, x): add x to all the numbers from index i to N-1
 * Lazy sum array
 */
fun function(arrayOf: Array<Int>, queries: Array<Array<Int>>) {
    // mark queries and only go once in the end to update array
    // prefix sum
    for(i in queries.indices) {
        val index = queries[i][0]
        val value = queries[i][1]
        arrayOf[index] += value
    }

    for(index in arrayOf.indices) {
        arrayOf[index] = arrayOf[index] + arrayOf[index - 1]
    }

    print(arrayOf)
}

/**
 * Given an integer array A where every element is 0, return a final array after performing multiple queries
 * Quer(i, j, x): Add x to all the elements from index i to j
 */

fun function1(arrayOf: Array<Int>, queries: Array<Array<Int>>) {
    // brute force - for each query iterate i to j and add x

    // mark queries and only go once in the end to update array
    // prefix sum
    for(i in queries.indices) {
        val index = queries[i][0]
        val j = queries[i][1]
        val value = queries[i][2]
        arrayOf[index] += value
        if(j < arrayOf.size) arrayOf[j+1] -= value
    }

    for(index in arrayOf.indices) {
        arrayOf[index] = arrayOf[index] + arrayOf[index - 1]
    }

    print(arrayOf)
}

/**
 * Rain water trapping
 * Given N buildings with height of each building, find the rain water trapped between the buildings.
 */
/*
fun function2(arrayOf: Array<Int>) {
    // Look at tallest building on my left and right

    // brute force - for every building loop over and find left max and right max and calculate water

    var ans1 = 0
    for(index in arrayOf.indices) {
        val maxL = max(0 to index-1) // loop
        val maxR = max(index+1 to arrayOf.size) // loop

        val water = min(maxL, maxR) - arrayOf[index]
        if(water > 0) {
            ans1 += water
        }
    }
    // - TC: O(N^2) SC: O(1)
    print(ans1)

    // Optimise TC: Use prefix and suffix max array
    var ans2 = 0
    val lMax = arrayOfNulls<Int>(arrayOf.size)

    for(index in 1..<arrayOf.size) {

    }

    val rMax = Array(arrayOf.size) {0}
    rMax[arrayOf.size - 1] = arrayOf[arrayOf.size - 1]
    for(index in arrayOf.size - 2..0) {
        rMax[index] = max(rMax[index+1], arrayOf[index])
    }

    for(index in 1..<arrayOf) {
        val water = max()
        if(water < 0) {
            ans2 += water
        }
    }

    // TC: O(N), SC: O(N)

    //3rd approach
    // Carry forward: We can carry forward one side and either remove prefix or suffix array. Other
    //
    val n: Int = arrayOf.size
    var i = 0
    var j = n - 1

    var lMax3: Int = arrayOf.get(i)
    var rMax3: Int = arrayOf.get(j)
    var ans3 = 0
    while (i < j) {
        var water = 0
        if (lMax3 < rMax3) {
            i++
            water = lMax3 - arrayOf.get(i)
            lMax3 = max(lMax3.toDouble(), arrayOf.get(i).toDouble()).toInt()
        } else {
            j--
            water = rMax3 - arrayOf.get(j)
            rMax3 = max(rMax3.toDouble(), arrayOf.get(j).toDouble()).toInt()
        }
        if (water > 0) ans3 += water
    }

    print(ans3)
}*/
