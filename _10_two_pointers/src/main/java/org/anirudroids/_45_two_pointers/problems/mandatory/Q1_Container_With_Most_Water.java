package org.anirudroids._45_two_pointers.problems.mandatory;

public class Q1_Container_With_Most_Water {
    /**
     * Problem Description
     * Given N non-negative integers A[0], A[1], ..., A[N-1] , where each represents a point at coordinate (i, A[i]).
     *
     * N vertical lines are drawn such that the two endpoints of line i is at (i, A[i]) and (i, 0).
     *
     * Find two lines, which together with x-axis forms a container, such that the container contains the most water. You need to return this maximum area.
     *
     * Note: You may not slant the container. It is guaranteed that the answer will fit in integer limits.
     *
     *
     *
     * Problem Constraints
     * 1 <= N <= 105
     *
     * 1 <= A[i] <= 105
     *
     *
     *
     * Input Format
     * Single Argument representing a 1-D array A.
     *
     *
     *
     * Output Format
     * Return single Integer denoting the maximum area you can obtain.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     * A = [1, 5, 4, 3]
     * Input 2:
     *
     * A = [1]
     *
     *
     * Example Output
     * Output 1:
     *
     *  6
     * Output 2:
     *
     *  0
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     * 5 and 3 are distance 2 apart. So size of the base = 2. Height of container = min(5, 3) = 3.
     * So total area = 3 * 2 = 6
     * Explanation 2:
     *
     * No container is formed.
     */

    public int maxArea(int[] A) {
        int i = 0;
        int j = A.length-1;

        int water = 0;
        while(i < j) {
            int amount = Math.min(A[i], A[j]) * (j-i);
            water = Math.max(water, amount);

            if(A[i] <= A[j]) {
                i++;
            } else {
                j--;
            }
        }

        return water;
    }
}
