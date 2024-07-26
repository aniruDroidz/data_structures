package org.anirudroids._08_arrays_carry_forward_subarrays.problems.mandatory;

public class Q6_Generate_all_subarrays {
    /**
     * Problem Description
     * You are given an array A of N integers.
     * Return a 2D array consisting of all the subarrays of the array
     *
     * Note : The order of the subarrays in the resulting 2D array does not matter.
     *
     *
     * Problem Constraints
     * 1 <= N <= 100
     * 1 <= A[i] <= 105
     *
     *
     * Input Format
     * First argument A is an array of integers.
     *
     *
     * Output Format
     * Return a 2D array of integers in any order.
     *
     *
     * Example Input
     * Input 1:
     * A = [1, 2, 3]
     * Input 2:
     * A = [5, 2, 1, 4]
     *
     *
     * Example Output
     * Output 1:
     * [[1], [1, 2], [1, 2, 3], [2], [2, 3], [3]]
     * Output 2:
     * [[1 ], [1 4 ], [2 ], [2 1 ], [2 1 4 ], [4 ], [5 ], [5 2 ], [5 2 1 ], [5 2 1 4 ] ]
     *
     *
     * Example Explanation
     * For Input 1:
     * All the subarrays of the array are returned. There are a total of 6 subarrays.
     * For Input 2:
     * All the subarrays of the array are returned. There are a total of 10 subarrays.
     */

    public int[][] solve(int[] A) {
        int n = A.length;
        int[][] result = new int[(n*(n+1))/2][];
        int index = 0;
        for(int start = 0; start < n; start++) {

            for(int end = start; end < n; end++) {
                int arrIndex = 0;
                int[] arr = new int[end - start + 1];
                for(int kIndex = start; kIndex <= end; kIndex++) {

                    arr[arrIndex++] = A[kIndex];
                }
                result[index++] = arr;
            }
        }
        return result;
    }
}
