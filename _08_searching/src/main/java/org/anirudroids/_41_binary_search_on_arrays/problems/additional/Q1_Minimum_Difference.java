package org.anirudroids._41_binary_search_on_arrays.problems.additional;

import java.util.Arrays;

public class Q1_Minimum_Difference {
    /**
     * Problem Description
     * You are given a 2-D matrix C of size A × B.
     * You need to build a new 1-D array of size A by taking one element from each row of the 2-D matrix in such a way that the cost of the newly built array is minimized.
     *
     * The cost of an array is the minimum possible value of the absolute difference between any two adjacent elements of the array.
     *
     * So if the newly built array is X, the element picked from row 1 will become X[1], element picked from row 2 will become X[2], and so on.
     *
     * Determine the minimum cost of the newly built array.
     *
     *
     *
     * Problem Constraints
     * 2 <= A <= 1000
     * 2 <= B <= 1000
     * 1 <= C[i][j] <= 106
     *
     *
     *
     * Input Format
     * The first argument is an integer A denoting number of rows in the 2-D array.
     * The second argument is an integer B denoting number of columns in the 2-D array.
     * The third argument is a 2-D array C of size A x B.
     *
     *
     *
     * Output Format
     * Return an integer denoting the minimum cost of the newly build array.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = 2
     *  B = 2
     *  C = [ [8, 4]
     *       [6, 8] ]
     * Input 2:
     *
     *  A = 3
     *  B = 2
     *  C = [ [7, 3]
     *        [2, 1]
     *        [4, 9] ]
     *
     *
     * Example Output
     * Output 1:
     *
     *  0
     * Output 2:
     *
     *  1
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  Newly build array : [8, 8]. The minimum cost will be 0 since the absolute difference will be 0(8-8).
     * Explanation 2:
     *
     *  Newly build array : [3, 2, 4]. The minimum cost will be 1 since the minimum absolute difference will be 1(3 - 2).
     */

    public int solve(int A, int B, int[][] C) {
        for(int i = 0; i < A; i++) {
            Arrays.sort(C[i]);
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < A-1; i++) {
            for(int j = 0; j < B; j++) {
                int element = C[i][j];
                int s = 0;
                int e = B-1;

                int lower_bound = C[i+1][s];
                int upper_bound = C[i+1][e];
                while(s <= e) {
                    int mid = (e-s)/2 + s;

                    if(C[i+1][mid] == element) {
                        return 0;
                    } else if(C[i+1][mid] < element) {
                        lower_bound = C[i+1][mid];
                        s = mid + 1;
                    } else {
                        upper_bound = C[i+1][mid];
                        e = mid - 1;
                    }
                }
                ans = Math.min(ans, Math.min(Math.abs(lower_bound-element), Math.abs(element-upper_bound)));

                if(ans == 0) {
                    return 0;
                }
            }
        }
        return ans;
    }
}
