package `8_searching`

class `42_Binary_Search_Problems` {

    /**
     * Given an integer array of N distinct elements.
     * Find any local minima
     *
     * A[i] < A[i-1]
     * A[i] < A[i+1]
     * e.g. A = [1,2,3,4,5]
     */
    fun first(arr: Array<Int>): Int {
        var s = 0
        var e = arr.size - 1

        while(s <= e) {
            var mid = s + (e-s)/2

            if((mid == 0 || arr[mid-1] < arr[mid]) && (mid == arr.size - 1 || arr[mid+1] > arr[mid])) {
                return mid
            } else if(arr[mid-1] < arr[mid]) {
                // Go to left
                e = mid - 1
            } else {
                // Go to right
                s = mid + 1
            }
        }

        return -1
    }

    /**
     * Search in sorted rotated array
     *
     * Given a sorted rotated array.
     * Find a given element K.
     */
    fun second(arr: Array<Int>) {

    }

    /**
     * Find where the array is rotated. (log(N))
     */
    fun third(arr: Array<Int>) {

    }

    /**
     * Given an integer N.
     * Find the value of square root of N.
     */
    fun forth(n: Int): Int {
        var s = 1
        var e = n

        while(s <= e) {
            val mid = s + (e-s)/2
            if(mid.times(mid) <= n) {
                if((mid+1).times(mid+1) > n) {
                    return mid
                } else {
                    s = mid+1
                }
            } else {
                e = mid-1
            }
        }

        return -1
    }
}