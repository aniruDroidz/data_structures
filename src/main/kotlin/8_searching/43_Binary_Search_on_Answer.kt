package `8_searching`

import kotlin.math.min


fun main() {
    val obj = `43_Binary_Search_on_Answer`()
}

class `43_Binary_Search_on_Answer` {
    /**
     * Given an integer A. Find the Ath magical number.
     * Magical number - A number which is divisible by B or C or both
     */
    fun first() {

    }

    fun first_2nd_approach(A:Int, B: Int, C: Int): Int {
        val lcm = lcm(B,C)
        var s = 1
        var e = min(B,C)*A
        var ans = 0
        while(s <= e) {
            val mid = s + (e-s)/2

            // Count of magical numbers from 1 to x.
            val count = (mid/B + mid/C - mid/lcm)
            if(count == A) {
                if(mid % B == 0 || mid % C == 0) {
                    ans = mid
                } else {
                    e = mid - 1
                }
            } else if(count > A) {
                e = mid - 1
            } else {
                s = mid + 1
            }
        }

        return ans
    }

    fun lcm(n1 : Int, n2: Int) : Int{
        var gcd = 1

        var i = 1
        while (i <= n1 && i <= n2) {
            // Checks if i is factor of both integers
            if (n1 % i == 0 && n2 % i == 0) gcd = i
            ++i
        }

        val lcm = (n1 * n2) / gcd
        return lcm
    }

    /**
     * Given N boards with their lengths.
     * A = [L0, L1, L2, L3, L4...LN-1]
     * Given K painters & each painter takes 1 unit of time to paint 1 unit length of board.
     *
     * Calculate min amount of time in which all the boards can be painted.
     *
     * Constraints:
     * 1. Two painters can not share a board
     * 2. A painter will only paint contiguous boards
     */
    fun second(arr: Array<Int>) {

    }
}