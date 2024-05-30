class Modular_Arithmetic_and_GCD {

    /**
     * Given an integer array, find count of pairs (i, j) such that (A[i] + A[j]) % M = 0 (i, j) is same as (j, i)
     */
    fun first(a: Array<Int>, m: Int) {
        // brute force - For all i,j check and count if(A[i] + A[j])%m == 0 - TC O(N^2) SC O(N)

    }

    /**
     * GCD
     */
    fun second(a: Int, b: Int): Int {
        if(b == 0) return a
        return second(b, a%b)
    }

    /**
     * GCD of all the numbers
     */
    fun third(a: Array<Int>) {

    }
}