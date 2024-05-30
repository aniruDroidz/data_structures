package `1_intermediate_dsa`

import java.util.*

/**
 * Figure out the function call to sort the array in decreasing order
 */

fun main() {
    // findMinimumCostAfterRemovingAllElements(arrayOf(5,3,1,-3))
    // findTheCountOfNobleIntegersWithDistinctElements(arrayOf(5,3))
    // findTheCountOfNobleIntegers(arrayOf(5,3))
    selectionSort(arrayOf(4,2,1))
}

fun selectionSort(arrayOf: Array<Int>) {
    val N = arrayOf.size
    var end = N - 1
    for(j in 0 until N) {
        var maxElement = Integer.MIN_VALUE
        var maxIndex = -1

        for(i in 0..end) {
            if(arrayOf[i] > maxElement) {
                maxElement = arrayOf[i]
                maxIndex = i
            }
        }

        // swap
        val temp = arrayOf[maxIndex]
        arrayOf[maxIndex] = arrayOf[end]
        arrayOf[end] = temp

        end--
    }
}

/**
 * Here elements are not distinct
 */
fun findTheCountOfNobleIntegers(arrayOf: Array<Int>) {
    var answer = 0
    Arrays.sort(arrayOf)

    if(arrayOf[0] == 0) answer++
    var count = 0
    for(index in 1 until arrayOf.size) {
        if(arrayOf[index] != arrayOf[index-1]) count = index
        if(count == arrayOf[index]) answer++
    }
}

/**
 * Noble Integer = The element is a noble integer if the count of the elements less than arr[i]
 * is equal to arr[i] itself
 */
fun findTheCountOfNobleIntegersWithDistinctElements(arrayOf: Array<Int>) {
    // Brute force
    var answer = 0
    for(i in arrayOf) {
        var count = 0
        for(j in arrayOf) {
            if(j < i) count++
        }
        if(count == answer) answer++
    }

    print(answer)

    // Optimised version
    answer = 0
    Arrays.sort(arrayOf) // it can be any optimised sort
    for(index in 0 until arrayOf.size ) {
        if(index == arrayOf[index]) answer++
    }

    print(answer)
}

/**
    Cost of removing one element = Sum of the values of all the elements present in the array before
    removing the element.
 **/
fun findMinimumCostAfterRemovingAllElements(a: Array<Int>) {
    /*
    * To get minimum cost, sort the elements in descending order
    */
}