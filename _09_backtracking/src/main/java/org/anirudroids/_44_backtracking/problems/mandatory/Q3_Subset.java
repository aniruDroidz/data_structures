package org.anirudroids._44_backtracking.problems.mandatory;

import java.util.ArrayList;

public class Q3_Subset {
    /**
     * Problem Description
     * Given a set of distinct integers A, return all possible subsets.
     *
     * NOTE:
     *
     * Elements in a subset must be in non-descending order.
     * The solution set must not contain duplicate subsets.
     * Also, the subsets should be sorted in ascending ( lexicographic ) order.
     * The initial list is not necessarily sorted.
     *
     *
     * Problem Constraints
     * 1 <= |A| <= 16
     * INTMIN <= A[i] <= INTMAX
     *
     *
     * Input Format
     * First and only argument of input contains a single integer array A.
     *
     *
     *
     * Output Format
     * Return a vector of vectors denoting the answer.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     * A = [1]
     * Input 2:
     *
     * A = [1, 2, 3]
     *
     *
     * Example Output
     * Output 1:
     *
     * [
     *     []
     *     [1]
     * ]
     * Output 2:
     *
     * [
     *  []
     *  [1]
     *  [1, 2]
     *  [1, 2, 3]
     *  [1, 3]
     *  [2]
     *  [2, 3]
     *  [3]
     * ]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  You can see that these are all possible subsets.
     * Explanation 2:
     *
     * You can see that these are all possible subsets.
     */

    int[][] result;
    int index;
    public int[][] subsets(int[] A) {
        result = new int[(int)Math.pow(2, A.length)][];

        generate(A, 0, new ArrayList<>());

        return result;
    }

    private void generate(int[] A, int index, ArrayList<Integer> res) {
        if(index == A.length) {
            int[] temp = new int[res.size()];
            for(int i = 0; i < temp.length; i++) {
                temp[i] = res.get(i);
            }
            result[index] = temp;
            return;
        }

        res.add(A[index]);
        generate(A, index + 1, res);
        res.remove(res.size() - 1);
        generate(A, index + 1, res);
    }
}
