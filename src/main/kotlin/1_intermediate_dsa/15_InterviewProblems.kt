package `1_intermediate_dsa`

fun main() {

}




fun `make all the elements in a row or column zero if A of i & j = 0`(mat: Array<Array<Int>>) {

    // 1st approach
    for(i in mat.indices) {
        for(j in mat[i].indices) {
            if(mat[i][j] == 0) {
                for(k in 0 until j) {
                    if(mat[i][k] != 0) {
                        mat[i][k] = -1
                    }
                }
            }
        }
    }

    //2nd approach
    for(i in mat.indices) {
        var flag = 0

        for(j in mat[i].indices) {
            if(mat[i][j] == 0) {
                flag = 1
                break
            }
        }

        if(flag == 1) {
            for(j in mat[i].indices) {
                if(mat[i][j] != 0) {
                    mat[i][j] = -1
                }
            }
        }
    }
}

/**
 * Majority element
 *
 */
fun `return if there exists an element with frequency more than N by 2`(arr: Array<Int>) {
    // Delete 2 distinct elements everytime, remaining one is the candidate

    // Moore's Voting Algorithm - candidate and the count

    // 4 4 4 4 1 2 4 3 6
}

fun `count max consecutive 1s after swapping at most one 0 with 1`(arr: Array<Int>): Int {
    // 110110011 = answer = 5
    var totalOnes = 0
    for(element in arr) {
        if(element == 1) {
            totalOnes++
        }
    }

    if(totalOnes == arr.size) return totalOnes

    var answer = 0

    for(i in arr.indices) {
        if(arr[i] == 0) {
            var l = 0
            for(j in i-1..0) {
                if(arr[j] == 0) {
                    break
                }
                l++
            }

            var r = 0
            for(j in i+1..<arr.size) {
                if(arr[j] == 0) {
                    break
                }
                r++
            }
            var count = 0
            if(l + r == totalOnes) {
                count = l + r
            } else if(l + r < totalOnes) {
                count = l + r + 1
            }

            if(answer < count) {
                answer = count
            }
        }
    }

    return answer
}

/**
 * If you can replace only one occurrence of 0 to 1
 */
fun `count max consecutive 1s after replacing one 0 with 1`(arr: Array<Int>): Int {
    // 110110011 = answer = 5

    var answer = 0
    for(element in arr) {
        if(element == 0) {
            break
        }
        answer++
    }

    if(answer == arr.size) return answer

    answer = 0

    for(i in arr.indices) {
        if(arr[i] == 0) {
            var l = 0
            for(j in i-1..0) {
                if(arr[i] == 0) {
                    break
                }
                l++
            }

            var r = 0
            for(j in i+1..<arr.size) {
                if(arr[i] == 0) {
                    break
                }
                r++
            }

            if(answer < l + r + 1) {
                answer = l + r + 1
            }
        }
    }

    return answer
}