package org.anirudroids._06_introduction_to_arrays.problems.mandatory;

public class Q3_Array_Rotation {
    /**
     * Problem Description
     * Given an integer array A of size N and an integer B, you have to return the same array after rotating it B times towards the right.
     *
     *
     * Problem Constraints
     * 1 <= N <= 105
     * 1 <= A[i] <=109
     * 1 <= B <= 109
     *
     *
     * Input Format
     * The first argument given is the integer array A.
     * The second argument given is the integer B.
     *
     *
     * Output Format
     * Return the array A after rotating it B times to the right
     *
     *
     * Example Input
     * Input 1:
     *
     * A = [1, 2, 3, 4]
     * B = 2
     * Input 2:
     *
     * A = [2, 5, 6]
     * B = 1
     *
     *
     * Example Output
     * Output 1:
     *
     * [3, 4, 1, 2]
     * Output 2:
     *
     * [6, 2, 5]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     * Rotate towards the right 2 times - [1, 2, 3, 4] => [4, 1, 2, 3] => [3, 4, 1, 2]
     * Explanation 2:
     *
     * Rotate towards the right 1 time - [2, 5, 6] => [6, 2, 5]
     */

    public int[] solve(int[] A, int B) {
        B = B % A.length;
        if(B == 0) return A;
        for(int index = 0; index <= (A.length - 1)/2; index++) {
            int temp = A[index];
            A[index] = A[A.length - 1 - index];
            A[A.length - 1 - index] = temp;
        }

        for(int index = 0; index < B/2; index++) {
            int temp = A[index];
            A[index] = A[B - 1 - index];
            A[B - 1 - index] = temp;
        }

        for(int index = B; index <= (A.length - 1 + B)/2; index++) {
            int temp = A[index];
            A[index] = A[A.length - 1 + B - index];
            A[A.length - 1 + B - index] = temp;
        }

        return A;
    }
}
