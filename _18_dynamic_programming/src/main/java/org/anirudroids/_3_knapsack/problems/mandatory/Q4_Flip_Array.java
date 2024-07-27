package org.anirudroids._3_knapsack.problems.mandatory;

public class Q4_Flip_Array {
    /**
     * Problem Description
     *
     * Given an array A of positive elements, you have to flip the sign of some of its elements such that the resultant sum of the elements of array should be minimum non-negative(as close to zero as possible).
     *
     * Return the minimum number of elements whose sign needs to be flipped such that the resultant sum is minimum non-negative.
     *
     *
     *
     * Problem Constraints
     *
     * 1 <= length of(A) <= 100
     *
     * Sum of all the elements will not exceed 10,000.
     *
     *
     *
     * Input Format
     *
     * First and only argument is an integer array A.
     *
     *
     *
     * Output Format
     *
     * Return an integer denoting the minimum number of elements whose sign needs to be flipped.
     *
     *
     *
     * Example Input
     *
     * Input 1:
     *
     *  A = [15, 10, 6]
     * Input 2:
     *
     *  A = [14, 10, 4]
     *
     *
     * Example Output
     *
     * Output 1:
     *
     *  1
     * Output 2:
     *
     *  1
     *
     *
     * Example Explanation
     *
     * Explanation 1:
     *
     *  Here, we will flip the sign of 15 and the resultant sum will be 1.
     * Explanation 2:
     *
     *  Here, we will flip the sign of 14 and the resultant sum will be 0.
     *  Note that flipping the sign of 10 and 4 also gives the resultant sum 0 but flippings there sign are not minimum.
     */

    public int solve(final int[] A) {
        if (A.length == 1) return 0;
        if (A.length == 2) return 1;
        int sum = 0;
        for(int item: A) {
            sum += item;
        }
        sum /= 2;

        int[][] dp = new int[A.length + 1][sum + 1];

        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - A[i - 1] == 0) dp[i][j] = 1;
                else if (j - A[i - 1] > 0 && dp[i - 1][j - A[i - 1]] > 0) {
                    if (dp[i - 1][j] > 0) dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i - 1][j - A[i - 1]]);
                    else dp[i][j] = 1 + dp[i - 1][j - A[i - 1]];
                } else dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[A.length][sum];
    }
}
