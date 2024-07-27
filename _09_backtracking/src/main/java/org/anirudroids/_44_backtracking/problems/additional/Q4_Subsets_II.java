package org.anirudroids._44_backtracking.problems.additional;

import java.util.ArrayList;
import java.util.Collections;

public class Q4_Subsets_II {
    /**
     * Problem Description
     * Given a collection of integers denoted by array A of size N that might contain duplicates, return all possible subsets.
     *
     * NOTE:
     *
     * Elements in a subset must be in non-descending order.
     * The solution set must not contain duplicate subsets.
     * The subsets must be sorted lexicographically.
     *
     *
     * Problem Constraints
     * 0 <= N <= 16
     *
     *
     *
     * Input Format
     * Only argument is an integer array A of size N.
     *
     *
     *
     * Output Format
     * Return a 2-D vector denoting all the possible subsets.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [1, 2, 2]
     * Input 2:
     *
     *  A = [1, 1]
     *
     *
     * Example Output
     * Output 1:
     *
     *  [
     *     [],
     *     [1],
     *     [1, 2],
     *     [1, 2, 2],
     *     [2],
     *     [2, 2]
     *  ]
     * Output 2:
     *
     *  [
     *     [],
     *     [1],
     *     [1, 1]
     *  ]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     * All the subsets of the array [1, 2, 2] in lexicographically sorted order.
     */

    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        Collections.sort(A);
        result.add(new ArrayList<>());
        generate(A, 0, new ArrayList<>());

        return result;
    }

    private void generate(ArrayList<Integer> A, int index, ArrayList<Integer> res) {
        if(index == A.size()) {
            return;
        }

        res.add(A.get(index));
        if(!result.contains(res)) {
            result.add(new ArrayList<>(res));
        }
        generate(A, index + 1, res);
        res.remove(res.size() - 1);
        generate(A, index + 1, res);
    }
}
