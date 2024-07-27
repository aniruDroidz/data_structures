package org.anirudroids._42_binary_search_problems.problems.mandatory;

import java.util.List;

public class Q2_Median_of_Array {
    /**
     * Problem Description
     * There are two sorted arrays A and B of sizes N and M respectively.
     *
     * Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).
     *
     * NOTE:
     *
     * The overall run time complexity should be O(log(m+n)).
     * IF the number of elements in the merged array is even, then the median is the average of (n/2)th and (n/2+1)th element. For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5.
     *
     *
     * Problem Constraints
     * 1 <= N + M <= 2*106
     *
     *
     *
     * Input Format
     * The first argument is an integer array A of size N.
     * The second argument is an integer array B of size M.
     *
     *
     *
     * Output Format
     * Return a decimal value denoting the median of two sorted arrays.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [1, 4, 5]
     *  B = [2, 3]
     * Input 2:
     *
     *  A = [1, 2, 3]
     *  B = [4]
     *
     *
     * Example Output
     * Output 1:
     *
     *  3.0
     * Output 2:
     *
     *  2.5
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  The median of both the sorted arrays will be 3.0.
     * Explanation 2:
     *
     *  The median of both the sorted arrays will be (2+3)/2 = 2.5.
     */

    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        int m = a.size();
        int n = b.size();
        if (m > n) {
            return findMedianSortedArrays(b, a);
        }
        int partition = (m + n + 1) / 2;
        int s = 0, e = m;
        while (s <= e) {
            int mid1 = (s + e) / 2;
            int mid2 = partition - mid1;
            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : a.get(mid1 - 1);
            int r1 = (mid1 == m) ? Integer.MAX_VALUE : a.get(mid1);
            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : b.get(mid2 - 1);
            int r2 = (mid2 == n) ? Integer.MAX_VALUE : b.get(mid2);
            if (l1 <= r2 && l2 <= r1) {
                int total = m + n;
                int maxLeft = Math.max(l1, l2);
                int minRight = Math.min(r1, r2);
                if (total % 2 == 0)
                    return 0.5 * (maxLeft + minRight);
                return maxLeft;
            } else if (l1 > r2) {
                e = mid1 - 1;
            } else {
                s = mid1 + 1;
            }
        }
        return (double) 0.0;
    }
}
