package `2_advanced_dsa`.`2_bit_manipulation`


class BitManipulation2 {
    fun main() {

    }

    /**
     * Given an array of size N, where every number occurs twice except 1, find that unique number.
     */
    fun first(A: Array<Int>) {
        var ans = 0

        for(e in A) {
            ans = ans xor e
        }

        print(ans)

        ans = 0
        // approach 2
        for(i in 0..<32) {
            var count = 0

            for(j in A.indices) {
                if(A[j] and (1 shl  i) > 0) {
                    count++
                }
            }

            if((count and 1) == 1) {
                ans = ans or (1 shl i)
            }
        }
    }

    /**
     * Given an integer array of size N. All the numbers occurs thrice except one which occurs only once, find the unique numbers
     */
    fun second(A: Array<Int>) {
        var ans = 0

        for(i in 0..<32) {
            var count = 0

            for(j in A.indices) {
                if(A[j] and (1 shl  i) > 0) {
                    count++
                }
            }

            if(count%3 != 0) {
                ans = ans or (1 shl i)
            }
        }
    }

    /**
     * Given an integer array of size N where every no. occurs twice except two elements, find those two unique elements
     */

    fun third(A: Array<Int>) {
        // approach 1
        // 1. XOR of all the numbers
        // 2. We identify the position of any set bit in the resultant XOR
        // 3. We divide all the numbers into two groups according to the set bit  identified in the step 2
        // 4. both the unique elements will be a part of different group
        // 5. each group now becomes Q1 of today's class
        // 6. We take XOR of each group individually to find the 2 unique elements

        var xor = 0

        for(e in A) {
            xor = xor xor e
        }

        var index = 0

        while (index < 32) {
            if((xor and (1 shl index)) > 0) {
                break
            } else {
                index++
            }
        }

        var xor1 = 0
        var xor2 = 0

        for(e in A) {
            if(e and (1 shl index) == 0) {
                xor2 = xor2 xor e
            } else {
                xor1 = xor1 xor e
            }
        }
    }

    /**
     * Given an array of size N.
     * Find the two indices (i, j) such that
     * 1. i != j
     * 2. A[i] & A[j] is maximum
     */

    fun forth(A: Array<Int>) {
            var ans = 0

            for(i in 31 downTo 0) {
                var count = 0
                for(e in A) {
                    if(e and (1 shl  i) > 0) {
                        count++
                    }
                }
                if(count >= 2) {
                    for(j in A.indices) {
                        if(A[j] and (1 shl i) == 0) {
                            A[j] = 0
                        }
                    }
                }
            }

        var i: Int = -1
        var j: Int = -1

        for(e in A) {
            if(e != 0 && i == -1) {
                i = e
            } else if(e != 0 && j == -1) {
                j = e
            }
        }
    }
}
