package org.anirudroids._44_backtracking.problems.additional;

import java.util.*;

public class Q3_Number_of_Squareful_Arrays {
    /**
     * Problem Description
     * Given an array of integers A, the array is squareful if for every pair of adjacent elements, their sum is a perfect square.
     *
     * Find and return the number of permutations of A that are squareful. Two permutations A1 and A2 differ if and only if there is some index i such that A1[i] != A2[i].
     *
     *
     *
     * Problem Constraints
     * 1 <= length of the array <= 12
     *
     * 1 <= A[i] <= 109
     *
     *
     *
     * Input Format
     * The only argument given is the integer array A.
     *
     *
     *
     * Output Format
     * Return the number of permutations of A that are squareful.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [2, 2, 2]
     * Input 2:
     *
     *  A = [1, 17, 8]
     *
     *
     * Example Output
     * Output 1:
     *
     *  1
     * Output 2:
     *
     *  2
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  Only permutation is [2, 2, 2], the sum of adjacent element is 4 and 4 and both are perfect square.
     * Explanation 2:
     *
     *  Permutation are [1, 8, 17] and [17, 8, 1].
     */

    boolean isPerfectSquare(int n) {
        int m = (int) Math.sqrt(n) - 2;
        while (1L * m * m < n) m++;
        return m * m == n;
    }
    public int solve(int[] A) {
        HashMap< Integer, Integer > count = new HashMap < > ();
        int N = A.length;
        for (int i = 0; i < N; i++) {
            count.put(A[i], count.getOrDefault(A[i], 0) + 1);
        }
        HashMap < Integer, HashSet< Integer >> graph = new HashMap < > ();
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isPerfectSquare(A[i] + A[j])) {
                    // add an edge from i to j and j to i
                    HashSet < Integer > set = graph.getOrDefault(A[i], new HashSet < Integer > ());
                    if (!set.contains(A[j])) {
                        set.add(A[j]);
                        graph.put(A[i], set);
                    }
                    set = graph.getOrDefault(A[j], new HashSet < Integer > ());
                    if (!set.contains(A[i])) {
                        set.add(A[i]);
                        graph.put(A[j], set);
                    }
                }
            }
        }
        ArrayList <ArrayList< Integer >> res = new ArrayList < > ();
        for (int i: count.keySet()) {
            backtrack(graph, count, N, i, new ArrayList <> (), res);
        }
        return res.size();
    }

    public void backtrack(HashMap < Integer, HashSet < Integer >> graph, Map< Integer, Integer > count, int N, int value,
                          List< Integer > temp, ArrayList < ArrayList < Integer >> res) {
        if (count.get(value) == 0)
            return;
        if (!graph.containsKey(value))
            return;
        count.put(value, count.get(value) - 1);
        temp.add(value);
        if (temp.size() == N) {
            res.add(new ArrayList <> (temp));
        } else {
            for (int i: graph.get(value)) {
                // traverse all adjacent vertices
                backtrack(graph, count, N, i, temp, res);
            }
        }
        temp.remove(temp.size() - 1);
        count.put(value, count.get(value) + 1);
    }
}
