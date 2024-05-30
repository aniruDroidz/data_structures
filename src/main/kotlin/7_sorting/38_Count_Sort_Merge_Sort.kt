package `7_sorting`

import kotlinx.coroutines.flow.merge

fun main() {
    val countSortMergeSort = `38_Count_Sort_Merge_Sort`()

    countSortMergeSort.second(arrayOf(2,3,4,6,8,5,7,9))
}

class `38_Count_Sort_Merge_Sort` {

    /**
     * Return the smallest number that can be formed using the digits given in the array
     */
    fun first(arr: Array<Int>) {
        val frequencyArray = intArrayOf(0,0,0,0,0,0,0,0,0,0)

        for(element in arr) {
            frequencyArray[element]++
        }

        var index = 0
        for(i in frequencyArray.indices) {
            for(j in 0..<frequencyArray[i]) {
                arr[index++] = i
            }
        }
        for(element in arr) {
            print(" $element")
        }

        // See how to implement count sort for -ve numbers - ans. using range, and shifting the indices
    }

    /**
     * Given an integer array where the odd valued elements are relatively sorted and even valued elements
     * are relatively sorted.
     * Sort the entire array.
     */
    fun second(arr: Array<Int>) {
        // 1st approach - Use the default sorting algo. - T.C. = O(N log(N))
        // But see if there's any hidden information in the problem statement, like here, odd are relatively sorted
        // and even are relatively sorted

        var oddCount = 0
        var evenCount = 0
        for(element in arr) {
            if(element % 2 == 0) {
                evenCount++
            } else {
                oddCount++
            }
        }

        val oddArray = Array(oddCount) { 0 }
        val evenArray = Array(evenCount) { 0 }

        var oddIndex = 0
        var evenIndex = 0

        for(element in arr) {
            if(element % 2 == 0) {
                evenArray[evenIndex++] = element
            } else {
                oddArray[oddIndex++] = element
            }
        }

        oddIndex = 0
        evenIndex = 0

        var index = 0
        while(oddIndex < oddCount && evenIndex < evenCount) {
            if(oddArray[oddIndex] < evenArray[evenIndex]) {
                arr[index++] = oddArray[oddIndex++]
            } else {
                arr[index++] = evenArray[evenIndex++]
            }
        }

        while(oddIndex < oddCount) {
            arr[index++] = oddArray[oddIndex++]
        }
        while(evenIndex < evenCount) {
            arr[index++] = evenArray[evenIndex++]
        }

        for(element in arr) {
            print(" $element")
        }
    }

    /**
     * Merge sort
     */
    fun mergeSort(arr: Array<Int>, s: Int, e: Int) {
        if(s >= e) {
            return
        }

        val mid = (s + e)/2

        mergeSort(arr, s, mid)
        mergeSort(arr, mid+1, e)

        merge(arr, s, mid, e)
    }

    private fun merge(arr: Array<Int>, s: Int, mid: Int, e: Int) {
        val n1 = mid - s + 1
        val n2 = e - mid

        val a1 = Array(n1) {0}
        val a2 = Array(n2) {0}

        var index = 0

        for(i in s..mid) {
            a1[index++] = arr[i]
        }
        index = 0
        for(i in mid+1..e) {
            a2[index++] = arr[i]
        }

        index = s
        // TODO
    }
}