package `2_advanced_dsa`.`1_arrays`

fun main() {

}

/**
 * Given a row-wise & column wise sorted matrix. Find whether a give element K is present or not
 */
fun first(matrix: Array<Array<Int>>, k: Int) {
    var i = 0
    var j = matrix[0].size - 1

    while (i < matrix.size && j >= 0) {
        if(matrix[i][j] == k) {
            print(true)
        }
        if(k < matrix[i][j]) {
            j--
        } else {
            i++
        }
    }

    print(false)
}

/**
 * Given a binary matrix (matrix[i][j] = {0/1}), Row-wise sorted
 * Find the row with maximum number of 1s\
 * In case of multiple rows, return the one with lower index
 */

fun second(matrix: Array<Array<Int>>) {
    var i = 0
    var j = matrix[0].size - 1

    var ansRowNumber = 0
    while (i < matrix.size && j >= 0) {
        if (matrix[i][j] == 0) {
            i++
        } else {
            j--
            ansRowNumber = i
        }
    }

    print(ansRowNumber)
}

/**
 * Given a matrix of size N x N.
 * Print the boundary elements in a clock-wise direction starting from (0,0)
 */

fun third(matrix: Array<Array<Int>>) {
    val n = matrix.size
    val m = matrix[0].size

    // 1st approach need to check
    var i = 0
    var j = 0

    print(matrix[i][j++])

    while (!(i == 0 && j == 0)) {
        if(j == m-1) {
            i++
        } else if(i == n -1) {
            j--
        } else if(j == 0) {
            i--
        } else {
            j++
        }

        print(matrix[i][j])
    }

    // 2nd approach

    var index = 0
    var jIndex = 0

    for(count in 0..<m-1) {
        print(matrix[index][jIndex])
        jIndex++
    }
    for(count in 0..<n-1) {
        print(matrix[index][jIndex])
        index++
    }
    for(count in 0..<m-1) {
        print(matrix[index][jIndex])
        jIndex--
    }
    for(count in 0..<n-1) {
        print(matrix[index][jIndex])
        index--
    }
}

/**
 * Spiral Order Matrix
 */

fun forth(matrix: Array<Array<Int>>) {
    var n = matrix.size
    var i = 0
    var j = 0
    while (n >= 2) {
        iterate(matrix, n, i, j)
        i++
        j++
        n -= 2
    }
    if(n == 1) {
        print(matrix[i][j])
    }
}

fun iterate(matrix: Array<Array<Int>>, n: Int, i: Int, j: Int) {
    var index = i
    var jIndex = j

    for(count in 0..<n-1) {
        print(matrix[index][jIndex])
        jIndex++
    }
    for(count in 0..<n-1) {
        print(matrix[index][jIndex])
        index++
    }
    for(count in 0..<n-1) {
        print(matrix[index][jIndex])
        jIndex--
    }
    for(count in 0..<n-1) {
        print(matrix[index][jIndex])
        index--
    }
}

/**
 * Sum of all sub-matrices
 */