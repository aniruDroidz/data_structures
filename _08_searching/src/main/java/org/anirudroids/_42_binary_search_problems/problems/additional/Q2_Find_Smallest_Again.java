package org.anirudroids._42_binary_search_problems.problems.additional;

import java.util.Arrays;

public class Q2_Find_Smallest_Again {
    /**
     * Problem Description
     * Given an integer array A of size N.
     *
     * If we store the sum of each triplet of the array A in a new list, then find the Bth smallest element among the list.
     *
     * NOTE: A triplet consists of three elements from the array. Let's say if A[i], A[j], A[k] are the elements of the triplet then i < j < k.
     *
     *
     *
     * Problem Constraints
     * 3 <= N <= 500
     * 1 <= A[i] <= 108
     * 1 <= B <= (N*(N-1)*(N-2))/6
     *
     *
     *
     * Input Format
     * The first argument is an integer array A.
     * The second argument is an integer B.
     *
     *
     *
     * Output Format
     * Return an integer denoting the Bth element of the list.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [2, 4, 3, 2]
     *  B = 3
     * Input 2:
     *
     *  A = [1, 5, 7, 3, 2]
     *  B = 9
     *
     *
     * Example Output
     * Output 1:
     *
     *  9
     * Output 2:
     *
     *  14
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  All the triplets of the array A are:
     *
     *  (2, 4, 3) = 9
     *  (2, 4, 2) = 8
     *  (2, 3, 2) = 7
     *  (4, 3, 2) = 9
     *
     *  So the 3rd smallest element is 9.
     */

    public int solve(int[] A, int B) {
        Arrays.sort(A);
        int s = 1;
        int e = A[A.length - 1] + A[A.length - 2] + A[A.length - 3];

        int ans = 0;
        while(s <= e) {
            int mid = (e-s)/2 + s;

            if(check(A, mid, B)) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return ans;
    }

    private boolean check(int[] A, int mid, int B) {
        int count = 0;
        for(int i = 0; i < A.length; i++) {
            int p1 = i+1;
            int p2 = A.length - 1;
            while(p1 < p2) {
                if(A[i] + A[p1] + A[p2] <= mid) {
                    count += p2 - p1;
                    p1++;
                } else {
                    p2--;
                }
            }
        }

        if(count >= B) {
            return true;
        }

        return false;
    }
}
