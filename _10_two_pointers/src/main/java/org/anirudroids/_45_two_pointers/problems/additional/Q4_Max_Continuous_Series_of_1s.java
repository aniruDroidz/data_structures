package org.anirudroids._45_two_pointers.problems.additional;

public class Q4_Max_Continuous_Series_of_1s {
    /**
     * Problem Description
     * Given a binary array A, find the maximum sequence of continuous 1's that can be formed by replacing at-most B zeroes.
     *
     * For this problem, return the indices of maximum continuous series of 1s in order.
     *
     * If there are multiple possible solutions, return the sequence which has the minimum start index.
     *
     *
     *
     * Problem Constraints
     * 0 <= B <= 105
     *
     * 1 <= size(A) <= 105
     *
     * 0 <= A[i] <= 1
     *
     *
     *
     * Input Format
     * First argument is an binary array A.
     *
     * Second argument is an integer B.
     *
     *
     *
     * Output Format
     * Return an array of integers denoting the indices(0-based) of 1's in the maximum continuous series.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [1, 1, 0, 1, 1, 0, 0, 1, 1, 1]
     *  B = 1
     * Input 2:
     *
     *  A = [1, 0, 0, 0, 1, 0, 1]
     *  B = 2
     *
     *
     * Example Output
     * Output 1:
     *
     *  [0, 1, 2, 3, 4]
     * Output 2:
     *
     *  [3, 4, 5, 6]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  Flipping 0 present at index 2 gives us the longest continous series of 1's i.e subarray [0:4].
     * Explanation 2:
     *
     *  Flipping 0 present at index 3 and index 5 gives us the longest continous series of 1's i.e subarray [3:6].
     */

    public int[] maxone(int[] A, int B) {
        int i = 0;
        int j = 0;

        int numberOfZerosInCurrentRange = 0;
        int s = 0;
        int e = 0;
        int resultWindow = 0;
        while(j < A.length) {
            if(A[j] == 0) {
                numberOfZerosInCurrentRange++;
            }

            if(numberOfZerosInCurrentRange > B) {
                while(numberOfZerosInCurrentRange > B) {
                    if(A[i] == 0) {
                        numberOfZerosInCurrentRange--;
                    }
                    i++;
                }
            }
            int currentWindow = j-i;

            if(currentWindow > resultWindow) {
                s = i;
                e = j;
                resultWindow = e-s;
            }
            j++;
        }

        int[] ans = new int[e-s+1];
        for(i = s; i <= e; i++) {
            ans[i-s] = i;
        }

        return ans;
    }
}
