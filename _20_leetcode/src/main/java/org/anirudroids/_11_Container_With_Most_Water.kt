package org.anirudroids

fun main() {

    for(i in 1..n) {
        
    }

    println(maxWater(intArrayOf(1,8,6,2,5,4,8,3,7)))
}

fun maxWater(height: IntArray): Int {
    var i = 0
    var j = height.size-1

    var maxWater = 0

    while(i < j && i < height.size && j >= 0) {
        maxWater = maxWater.coerceAtLeast(height[i].coerceAtMost(height[j]) * (j-i))
        if(height[i] < height[j]) {
            i = i.inc()
        } else {
            j = j.dec()
        }
    }

    return maxWater
}
