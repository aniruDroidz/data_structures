/*
1. Total no. of sub-arrays = N (N+1)/2
2. Consider all sub-arrays = T.C can not be reduced from O(N^2)
3. T.C. of printing all the sub-arrays = O(n^3)
4. Calculate sum of all sub-arrays
    N^3 & O(1) - BF -> N^2 & O(N) - Prefix sum -> N^2 & O(1) - Carry forward
5. Contribution technique
    Total sum of all sub-arrays
    T.C -> O(N)
    S.C.-> O(1)
6. Sliding Window
    When size of sub-array is fixed
 */

fun main() {
    // printSumOfAllSubArrays(arrayOf(1,2,3))
    // findTotalSumOfAllSubArraySums(arrayOf(1,2,3))
    // findTotalNumOfSubArraysOfLengthK(arrayOf(3,  -2, 4, -1, 2, 6), 4)
    findMaximumSubArraySumOfSubArrayLengthK(arrayOf(3,  -2, 4, -1, 2, 6), 4)
}

fun findMaximumSubArraySumOfSubArrayLengthK(arrayOf: Array<Int>, k: Int) {

    // 1st approach
    var start = 0
    var end = k-1
    var max = Integer.MIN_VALUE
    while(end < arrayOf.size) {
        var sum = 0
        for(i in start..end) {
            sum += arrayOf[i]
        }
        if(max < sum) {
            max = sum
        }
        start = start.inc()
        end = end.inc()
    }
    println(max)

    // 2nd approach
    val prefixSum = arrayOfNulls<Int>(arrayOf.size)

    prefixSum[0] = arrayOf[0]
    for(i in 1 until arrayOf.size) {
        prefixSum[i] = prefixSum[i-1]?.plus(arrayOf[i])
    }

    var start1 = 0
    var end1 = k-1
    var max1 = Integer.MIN_VALUE
    while(end1 < arrayOf.size) {
        var sum1 = prefixSum[start1+1]?.let {
            prefixSum[end1]?.minus(it)
        } ?: 0

        if(max < sum1) {
            max = sum1
        }
        start1 = start1.inc()
        end1 = end1.inc()
    }
    println(max1)

    // 3rd approach - Carry forward (sliding window)
    var sum = 0
    for(i in 0 until k) {
        sum += arrayOf[i]
    }

    var ans = sum
    for(j in k until arrayOf.size) {
        sum += arrayOf[j]
        sum -= arrayOf[j-k]
        if(sum > ans) {
            ans = sum
        }
    }

    println(ans)
}

fun findTotalNumOfSubArraysOfLengthK(arr: Array<Int>, k: Int) {
    // 1st approach
    print(arr.size-k+1)
}

fun findTotalSumOfAllSubArraySums(arr: Array<Int>) {

    // 1st approach
    var answer1 = 0
    for(i in 0 until arr.size) {
        var sum = 0
        for(j in i until arr.size) {
            sum += arr[i]
            answer1 += sum
        }
    }
    println(answer1)

    // 2nd approach
    // from 0 to n-1 - A[i] x No. of sub arrays in which A[i] is contributing
    var answer2 = 0

    for(i in 0 until arr.size) {
        answer2 += arr[i] * (i+1) * (arr.size-i)
    }

    println(answer2)
}

fun printSumOfAllSubArrays(arr: Array<Int>) {

    for(i in 0 until arr.size) {
        var sum = 0
        for(j in i until arr.size) {
            sum += arr[j]
            println(sum)
        }
    }
}

