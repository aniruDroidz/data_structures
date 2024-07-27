fun main() {
    val comparatorAndProblems = `40_Comparator_and_Problems`()
    comparatorAndProblems.second(arrayOf(9,3,10,6,4))
}

class `40_Comparator_and_Problems` {

    /**
     * Given an array of N integers. Arrange the elements in ascending order based on their number of factors
     */

    fun first(arr: Array<Int>) {
        val sorted = arr.sortedWith(Comparator(::compare))
        print(sorted)
    }

    private fun compare(a: Int, b: Int): Int {
        val factorsA: Int = getFactors(a)
        val factorsB: Int = getFactors(b)

        return if(factorsA < factorsB) {
            -1
        } else if(factorsA > factorsB) {
            1
        } else {
            0
        }
    }

    private fun getFactors(a: Int): Int {
        var count = 2

        for (index in 2..a / 2) {
            if (a % index == 0) {
                count++
            }
        }

        return count
    }

    /**
     * Given an array of N integers. Arrange the elements in ascending order based on their number of factors
     * If the count of factors are equal, sort them on the basis of their actual value
     */
    fun second(arr: Array<Int>) {
        val sorted = arr.sortedWith(Comparator(::compare2))
        print(sorted)
    }

    private fun compare2(a: Int, b: Int): Int {
        val factorsA: Int = getFactors(a)
        val factorsB: Int = getFactors(b)

        if(factorsA < factorsB) {
            return -1
        } else if(factorsA > factorsB) {
            return 1
        } else {
            return a.compareTo(b)
        }
    }

    /**
     * Given an array of points.
     * points[i] = [Xi, Yi]
     * Return B closest points to origin
     */
    fun third(points: Array<Array<Int>>) {

    }

    /**
     * Given a list of non-negative numbers. Arrange them in such a way that they form the largest number
     * Return the number
     */
    fun forth(arr: Array<Int>) {

    }
}