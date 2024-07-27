package org.anirudroids._1_arrays._19_arrays_2_follow_up

fun main() {

}

/**
 * Given a matrix of size N x M, print a given submatrix from (r1,c1) and (r2,c2)
 */
fun first(matrix: Array<Array<Int>>, r1: Int, c1: Int, r2: Int, c2: Int) {
    for(r in r1..r2) {
        for(c in c1..c2) {
            print(matrix[r][c])
        }
    }
}

/**
 * Given a matrix of size N x M, return the sum of all the elements in
 * given submatrix from (r1,c1) and (r2,c2)
 */
fun second_2(matrix: Array<Array<Int>>, r1: Int, c1: Int, r2: Int, c2: Int): Int {
    var sum = 0
    for(r in r1..r2) {
        for(c in c1..c2) {
            sum += matrix[r][c]
        }
    }
    return  sum
}

/**
 * Given a matrix of size N x M
 * find the sum of all the submatrices
 */

fun third_2(matrix: Array<Array<Int>>): Int {
    var sum = 0
    for(r1 in matrix.indices) { // top left
        for(c1 in matrix[r1].indices) {
            for(r2 in r1..<matrix.size) { //bottom right
                for(c2 in c1..<matrix[r2].size) {
                    sum += second_2(matrix, r1, c1, r2, c2)
                }
            }
        }
    }

    // another approach
    sum = 0
    // contribution of M[i][j] element = (number of submmatrix M[i][j] is a part of) x (M[i][j])
    //

    for(i in matrix.indices) {
        for(j in matrix[i].indices) {
            val count = (i + 1) * (matrix.size-1) * (j + 1) * (matrix[i].size - j)
            val contribution = count * matrix[i][j]
            sum += contribution
        }
    }
    return sum
}
