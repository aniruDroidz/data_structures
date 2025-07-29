package org.anirudroids._3_knapsack.problems.mandatory;

import java.util.Arrays;

public class Q1_Fractional_Knapsack {
    /**
     * Problem Description
     * Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.
     * <p>
     * Also given an integer C which represents knapsack capacity.
     * <p>
     * Find out the maximum total value that we can fit in the knapsack. If the maximum total value is ans, then return ⌊ans × 100⌋ , i.e., floor of (ans × 100).
     * <p>
     * NOTE:
     * <p>
     * You can break an item for maximizing the total value of the knapsack
     * <p>
     * <p>
     * Problem Constraints
     * 1 <= N <= 105
     * <p>
     * 1 <= A[i], B[i] <= 103
     * <p>
     * 1 <= C <= 103
     * <p>
     * <p>
     * <p>
     * Input Format
     * First argument is an integer array A of size N denoting the values on N items.
     * <p>
     * Second argument is an integer array B of size N denoting the weights on N items.
     * <p>
     * Third argument is an integer C denoting the knapsack capacity.
     * <p>
     * <p>
     * <p>
     * Output Format
     * Return a single integer denoting the maximum total value of A such that sum of the weights of this subset is smaller than or equal to C.
     * <p>
     * <p>
     * <p>
     * Example Input
     * Input 1:
     * <p>
     * A = [60, 100, 120]
     * B = [10, 20, 30]
     * C = 50
     * Input 2:
     * <p>
     * A = [10, 20, 30, 40]
     * B = [12, 13, 15, 19]
     * C = 10
     * <p>
     * <p>
     * Example Output
     * Output 1:
     * <p>
     * 24000
     * Output 2:
     * <p>
     * 2105
     * <p>
     * <p>
     * Example Explanation
     * Explanation 1:
     * <p>
     * Taking the full items with weight 10 and 20 and 2/3 of the item with weight 30 will give us
     * the maximum value i.e 60 + 100 + 80 = 240. So we return 24000.
     * Explanation 2:
     * <p>
     * Taking 10/19 the fourth item gives us the maximum value i.e. 21.0526. So we return 2105.
     */

    class Pair {
        int value;
        int weight;
        double ratio;

        public Pair(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.ratio = ((double) value / weight);
        }
    }

    public int solve(int[] A, int[] B, int C) {
        Pair[] pairs = new Pair[A.length];
        for (int index = 0; index < A.length; index++) {
            pairs[index] = new Pair(A[index], B[index]);
        }

        Arrays.sort(pairs, (p1, p2) -> Double.compare(p2.ratio, p1.ratio));

        double result = 0;

        for (Pair pair : pairs) {
            if (pair.weight <= C) {
                result += pair.value;
                C -= pair.weight;
            } else {
                result += pair.ratio * C;
                break;
            }
        }

        return (int) (result * 1000) / 10;
    }
}
