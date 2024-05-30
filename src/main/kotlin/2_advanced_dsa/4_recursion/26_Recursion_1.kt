package `2_advanced_dsa`.`4_recursion`

class Recursion_1 {

    /**
     * Find sum of N numbers
     */

    fun first(number: Int): Int {
        if(number == 1) {
            return number
        }
        return first(number - 1) + number
    }

    fun factorial(n: Int): Int {
        if(n == 0) {
            return 1;
        }

        return factorial(n-1)*n;
    }

    /**
     * Given a + integer, we need to print nth term of fibonacci sequence
     */

    fun third(n: Int): Int {
        if(n == 0 || n == 1) {
            return n
        }

        return third(n-1) + third(n-2)
    }

    /**
     * Given two integers A & N, Calculate A^N
     */

    fun forth(a: Int, n: Int): Int {
        if(n == 0) {
            return 1
        }
        return forth(a, n - 1) * a
    }

    fun forth_second_apparch(a: Int, n: Int): Int {
        if(n == 0) {
            return 1
        } else if(n%2 == 0) {
            return forth(a, n/2) + forth(a, n/2) // as an optimisation, we can store returned value forth(a, n/2) and multiply it twice
        } else {
            return a * forth(a, n/2) + forth(a, n/2) // as an optimisation, we can store returned value forth(a, n/2) and multiply it twice
        }
    }


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(`2_advanced_dsa`.`4_recursion`.Recursion_1().forth(3, 3))
        }
    }
}
