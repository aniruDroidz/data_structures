package org.anirudroids._1_arrays._17_arrays_1_one_diamentional.problems.mandatory;

public class Q3_Rain_Water_Trapped {
    /**
     * Problem Description
     * Imagine a histogram where the bars' heights are given by the array A. Each bar is of uniform width, which is 1 unit. When it rains, water will accumulate in the valleys between the bars.
     *
     * Your task is to calculate the total amount of water that can be trapped in these valleys.
     *
     * Example:
     *
     * The Array A = [5, 4, 1, 4, 3, 2, 7] is visualized as below. The total amount of rain water trapped in A is 11.
     *
     *
     * Rain Water Trapped
     *
     *
     *
     *
     * Problem Constraints
     * 1 <= |A| <= 105
     * 0 <= A[i] <= 105
     *
     *
     *
     * Input Format
     * First and only argument is the Integer Array, A.
     *
     *
     *
     * Output Format
     * Return an Integer, denoting the total amount of water that can be trapped in these valleys
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [0, 1, 0, 2]
     * Input 2:
     *
     * A = [1, 2]
     *
     *
     * Example Output
     * Output 1:
     *
     * 1
     * Output 2:
     *
     * 0
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     * 1 unit is trapped on top of the 3rd element.
     * Rain Water Histogram
     * Explanation 2:
     *
     * No water is trapped.
     */

    public int trap(final int[] A) {
        int n = A.length;
        int i = 0;
        int j = n - 1;

        int lMax = A[i]; int rMax = A[j];
        int ans = 0;
        while(i < j) {
            int water = 0;
            if(lMax < rMax) {
                i++;
                water = lMax - A[i];
                lMax = Math.max(lMax, A[i]);
            } else {
                j--;
                water = rMax - A[j];
                rMax = Math.max(rMax, A[j]);
            }

            if(water > 0) ans += water;
        }

        return ans;
    }
}
