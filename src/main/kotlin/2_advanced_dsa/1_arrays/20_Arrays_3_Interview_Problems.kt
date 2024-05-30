package `2_advanced_dsa`.`1_arrays`

import kotlin.math.max
import kotlin.math.min

fun main() {
    third(arrayOf(2,5,3,4,6))
}

/**
 *
 */
fun first(starts: Array<Int>, ends: Array<Int>) {
    val intervals = mutableListOf<Interval>()
    var currentStart = starts[0]
    var currentEnd = ends[0]
    for(i in 1..starts.size) {
        if(starts[i] <= currentEnd) {
            currentStart = min(currentStart, starts[i])
            currentEnd = max(currentEnd, ends[i])
        } else {
            val interval = Interval(currentStart, currentEnd)
            intervals.add(interval)

            currentStart = starts[i]
            currentEnd = ends[i]
        }
    }

    val interval = Interval(currentStart, currentEnd)
    intervals.add(interval)
}

data class Interval(var start: Int, var end: Int)

/**
 * Given a sorted list of non-overlapping intervals sorted on the start time.
 * Insert a new given interval such that the final list of intervals is also sorted and non-overlapping.
 * Print the intervals
 */

fun second(intervals: List<Interval>, new: Interval) {
    if(new.end < intervals[0].start) {
        print(new)
    }

    for(i in intervals.indices) {
        val l = intervals[i].start
        val r = intervals[i].end

        if(new.start > r) {
            print("$l, $r")
        } else if(l > new.end) {
            print("${new.start}, ${new.end}")
            for(j in i..<intervals.size) {
                print("${intervals[j].start}, ${intervals[j].end}")
            }
            return
        } else {
            new.start = min(l, new.start)
            new.end = max(r, new.end)
        }
    }
    print("${new.start}, ${new.end}")
}

/**
 * Given an unsorted array of integers. Find the first missing natural number
 */
fun third(integers: Array<Int>) {
    // brute force
/*
    var isFound = false

    for(i in 1..integers.size+1) {
        for(j in integers.indices) {
            if(integers[j] == i) {
                isFound = true
                break
            }
        }
        if(!isFound) {
           print(i)
           break
        }
    }
*/

    // use hashset - but space complexity would increase to O(N)

    // H.W. how to do it - check pdf

    for(i in integers.indices) {
        if(integers[i] <= integers.size && integers[i] > 0) {
            val temp = integers[integers[i] - 1]
            integers[integers[i]-1] = integers[i]
            integers[i] = temp
        } else {
            integers[i] = 0;
        }
    }

    for(element in integers) {
        print("$element, ")
    }
}