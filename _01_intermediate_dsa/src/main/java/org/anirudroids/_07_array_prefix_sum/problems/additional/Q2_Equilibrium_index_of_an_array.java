package org.anirudroids._07_array_prefix_sum.problems.additional;

public class Q2_Equilibrium_index_of_an_array {
    /**
     * Problem Description
     * You are given an array A of integers of size N.
     *
     * Your task is to find the equilibrium index of the given array
     *
     * The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of 
     * elements at higher indexes.
     *
     * If there are no elements that are at lower indexes or at higher indexes, then the corresponding sum of elements is 
     * considered as 0.
     *
     * Note:
     *
     * Array indexing starts from 0.
     * If there is no equilibrium index then return -1.
     * If there are more than one equilibrium indexes then return the minimum index.
     *
     *
     * Problem Constraints
     * 1 <= N <= 105
     * -105 <= A[i] <= 105
     *
     *
     * Input Format
     * First arugment is an array A .
     *
     *
     * Output Format
     * Return the equilibrium index of the given array. If no such index is found then return -1.
     *
     *
     * Example Input
     * Input 1:
     * A = [-7, 1, 5, 2, -4, 3, 0]
     * Input 2:
     *
     * A = [1, 2, 3]
     *
     *
     * Example Output
     * Output 1:
     * 3
     * Output 2:
     *
     * -1
     *
     *
     * Example Explanation
     * Explanation 1:
     * i   Sum of elements at lower indexes    Sum of elements at higher indexes
     * 0                   0                                   7
     * 1                  -7                                   6
     * 2                  -6                                   1
     * 3                  -1                                  -1
     * 4                   1                                   3
     * 5                  -3                                   0
     * 6                   0                                   0
     *
     * 3 is an equilibrium index, because:
     * A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
     * Explanation 1:
     *
     * i   Sum of elements at lower indexes    Sum of elements at higher indexes
     * 0                   0                                   5
     * 1                   1                                   3
     * 2                   3                                   0
     * Thus, there is no such index.
     */

    public int solve(int[] A) {
        long sum1 = 0;
        for(int i = 0; i < A.length ; i++)
            sum1 += A[i];
        long sum2 = 0;  // sum of elements at lower indexes
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < A.length ; i++){
            sum1 -= A[i];   // sum of elements at higher indexes
            if(sum1 == sum2){
                ans = i;
                break;
            }
            sum2 += A[i];
        }
        if(ans == Integer.MAX_VALUE)
            ans =- 1;   // If no equilibrium index found, then return -1
        return ans;
    }
}
