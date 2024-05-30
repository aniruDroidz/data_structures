package `2_advanced_dsa`.`4_recursion`

class Recursion_2 {

    fun first(n: Int) {
        if(n == 0) {
            return
        }

        first(n-1)
        print(n)
    }

    fun second(n: Int) {
        if(n == 0) {
            return
        }

        print(n)
        second(n-1)
    }

    /**
     * Tower of hanoi
     */
    fun third(n: Int, src: String, dest: String, intermediate: String) {
        if(n == 0) {
            return
        }
        third(n-1, src, intermediate, dest)
        print("Moving ring from $src to $dest")
        third(n-1, intermediate, dest, src)
    }

    /**
     * Print all valid parenthesis of length 2n for a given value n
     */
    fun forth(n: Int) {
        
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val recursion2 = `2_advanced_dsa`.`4_recursion`.Recursion_2()
            recursion2.first(3)
        }
    }
}