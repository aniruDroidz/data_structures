package org.anirudroids._3_knapsack.problems.mandatory;

import java.util.Arrays;
import java.util.Comparator;

public class Q1_Fractional_Knapsack {
    /**
     * Problem Description
     * Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.
     *
     * Also given an integer C which represents knapsack capacity.
     *
     * Find out the maximum total value that we can fit in the knapsack. If the maximum total value is ans, then return ⌊ans × 100⌋ , i.e., floor of (ans × 100).
     *
     * NOTE:
     *
     * You can break an item for maximizing the total value of the knapsack
     *
     *
     * Problem Constraints
     * 1 <= N <= 105
     *
     * 1 <= A[i], B[i] <= 103
     *
     * 1 <= C <= 103
     *
     *
     *
     * Input Format
     * First argument is an integer array A of size N denoting the values on N items.
     *
     * Second argument is an integer array B of size N denoting the weights on N items.
     *
     * Third argument is an integer C denoting the knapsack capacity.
     *
     *
     *
     * Output Format
     * Return a single integer denoting the maximum total value of A such that sum of the weights of this subset is smaller than or equal to C.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [60, 100, 120]
     *  B = [10, 20, 30]
     *  C = 50
     * Input 2:
     *
     *  A = [10, 20, 30, 40]
     *  B = [12, 13, 15, 19]
     *  C = 10
     *
     *
     * Example Output
     * Output 1:
     *
     *  24000
     * Output 2:
     *
     *  2105
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     * Taking the full items with weight 10 and 20 and 2/3 of the item with weight 30 will give us
     * the maximum value i.e 60 + 100 + 80 = 240. So we return 24000.
     * Explanation 2:
     *
     * Taking 10/19 the fourth item gives us the maximum value i.e. 21.0526. So we return 2105.
     */

    class Pair {
        int value;
        int weight;
        double ratio;
        public Pair(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.ratio = ((double)value/weight);
        }
    }
    public int solve(int[] A, int[] B, int C) {
        Pair[] pairs = new Pair[A.length];
        for(int index = 0; index < A.length; index++) {
            pairs[index] = new Pair(A[index], B[index]);
        }

        Arrays.sort(pairs, (p1, p2) -> Double.compare(p2.ratio, p1.ratio));

        double result = 0;

        for(int index = 0; index < pairs.length; index++) {
            if(pairs[index].weight <= C) {
                result += pairs[index].value;
                C -= pairs[index].weight;
            } else {
                result += pairs[index].ratio * C;
                break;
            }
        }

        return (int)(result * 1000)/10;
    }
}
