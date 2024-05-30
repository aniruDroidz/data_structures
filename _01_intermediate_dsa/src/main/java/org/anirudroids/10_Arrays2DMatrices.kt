fun main() {
    // printSumOfAllElementsRowWise(arrayOf(arrayOf(1,2,3),arrayOf(4,5,6), arrayOf(7,8,9)))
    // printSumOfAllElementsColumnWise(arrayOf(arrayOf(1,2,3),arrayOf(4,5,6), arrayOf(7,8,9)))
    // printAllDiagonalsOfRectangularMatrix(arrayOf(arrayOf(1,2,3,4), arrayOf(5,6,7,8), arrayOf(9,10,11,12)))
    // findATransposeOfSquareMatrix(arrayOf(arrayOf(1,2,3),arrayOf(4,5,6), arrayOf(7,8,9)))
    printAllDiagonalsOfRectangularMatrix(arrayOf(arrayOf(1,2,3),arrayOf(4,5,6), arrayOf(7,8,9)))
}

fun rotateMatrix90DegreeClockWise(arrayOf: Array<Array<Int>>) {
    printSumOfAllElementsRowWise(arrayOf)
    // Take a transpose of matrix
    for(i in arrayOf.indices) {
        for(j in i+1..<arrayOf[i].size) {
            val temp = arrayOf[i][j]
            arrayOf[i][j] = arrayOf[j][i]
            arrayOf[j][i] = temp
        }
    }
    printSumOfAllElementsRowWise(arrayOf)
    // Reverse each row
    for(i in arrayOf.indices) {
        for(j in 0..arrayOf.size/2) {
            val temp = arrayOf[i][arrayOf.size - j - 1]
            arrayOf[i][arrayOf.size - j - 1] = arrayOf[i][j]
            arrayOf[i][j] = temp
        }
    }
    printSumOfAllElementsRowWise(arrayOf)
    print(arrayOf[0][1])
}

fun findATransposeOfSquareMatrix(arrayOf: Array<Array<Int>>) {

    val transpose = Array(arrayOf.size) { Array(arrayOf[0].size) {0} }
    for(i in arrayOf.indices) {
        for(j in 0..<arrayOf[i].size) {
            transpose[j][i] = arrayOf[i][j]
        }
    }

    for(i in arrayOf.indices) {
        for(j in i+1..<arrayOf[i].size) {
            val temp = arrayOf[i][j]
            arrayOf[i][j] = arrayOf[j][i]
            arrayOf[j][i] = temp
        }
    }
}

fun printAllDiagonalsOfRectangularMatrix(arrayOf: Array<Array<Int>>) {
    val N = arrayOf.size
    val M = arrayOf[0].size

    for(i in 0 until M) {
        var r = 0
        var c = i
        while(r < N && c >= 0) {
            print(" ${arrayOf[r][c]}")
            r = r.inc()
            c = c.dec()
        }
        println()
    }

    for(i in 1 until N) {
        var r = i
        var c = M-1
        while(r < N && c >= 0) {
            print(" ${arrayOf[r][c]}")
            r = r.inc()
            c = c.dec()
        }
        println()
    }
}

fun printAllDiagonalElementsLeftToRight(arrayOf: Array<Array<Int>>) {
    val N = arrayOf.size
    // Diagonal
    for(i in 0 until arrayOf.size) {
        print(" ${arrayOf[i][i]}")
    }

    // Anti Diagonal
    var i = N-1
    var j = 0
    while(i >= 0){
        print(" ${arrayOf[i][j]}")
        i--
        j++
    }
}

fun printSumOfAllElementsColumnWise(arrayOf: Array<Array<Int>>) {
    for(i in 0 until arrayOf.size) {
        for(j in 0 until arrayOf[i].size) {
            print(" ${arrayOf[j][i]}")
        }
        println()
    }
}

fun printSumOfAllElementsRowWise(arrayOf: Array<Array<Int>>) {
    for(i in 0 until arrayOf.size) {
        for(j in 0 until arrayOf[i].size) {
            print(" ${arrayOf[i][j]}")
        }
        println()
    }
}
