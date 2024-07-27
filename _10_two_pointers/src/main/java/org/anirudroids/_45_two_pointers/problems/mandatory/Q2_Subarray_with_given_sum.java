package org.anirudroids._45_two_pointers.problems.mandatory;

public class Q2_Subarray_with_given_sum {
    /**
     * Problem Description
     * Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
     *
     * If the answer does not exist return an array with a single integer "-1".
     *
     * First sub-array means the sub-array for which starting index in minimum.
     *
     *
     *
     * Problem Constraints
     * 1 <= length of the array <= 100000
     * 1 <= A[i] <= 109
     * 1 <= B <= 109
     *
     *
     *
     * Input Format
     * The first argument given is the integer array A.
     *
     * The second argument given is integer B.
     *
     *
     *
     * Output Format
     * Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single integer "-1".
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [1, 2, 3, 4, 5]
     *  B = 5
     * Input 2:
     *
     *  A = [5, 10, 20, 100, 105]
     *  B = 110
     *
     *
     * Example Output
     * Output 1:
     *
     *  [2, 3]
     * Output 2:
     *
     *  [-1]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  [2, 3] sums up to 5.
     * Explanation 2:
     *
     *  No subarray sums up to required number.
     */

    public int[] solve(int[] A, int B) {
        int[] prefixSum = new int[A.length];

        prefixSum[0] = A[0];
        for(int i = 1; i < A.length; i++) {
            prefixSum[i] = A[i] + prefixSum[i-1];
        }

        for(int i=0;i<A.length;i++)
        {
            if(prefixSum[i]==B)
            {
                int index=i;
                int[] result = new int[index+1];
                for(i=0;i<=index;i++)
                {
                    result[i] = A[i];
                }
                return result;
            }
        }

        int i = 0;
        int j = 1;

        while(j < A.length) {
            int target = prefixSum[j]-prefixSum[i];

            if(target == B) {
                int[] result = new int[j-i];

                for(int index = i+1; index <= j; index++) {
                    result[index-(i+1)] = A[index];
                }
                return result;
            } else if(target > B) {
                i++;
            } else {
                j++;
            }
        }

        return new int[] {-1};
    }
}
