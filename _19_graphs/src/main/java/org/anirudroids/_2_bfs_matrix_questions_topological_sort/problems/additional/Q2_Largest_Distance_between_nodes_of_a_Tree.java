package org.anirudroids._2_bfs_matrix_questions_topological_sort.problems.additional;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q2_Largest_Distance_between_nodes_of_a_Tree {
    /**
     * Problem Description
     * Find largest distance Given an arbitrary unweighted rooted tree which consists of N (2 <= N <= 40000) nodes.
     *
     * The goal of the problem is to find largest distance between two nodes in a tree. Distance between two nodes is a number of edges on a path between the nodes (there will be a unique path between any pair of nodes since it is a tree).
     *
     * The nodes will be numbered 0 through N - 1.
     *
     * The tree is given as an array A, there is an edge between nodes A[i] and i (0 <= i < N). Exactly one of the i's will have A[i] equal to -1, it will be root node.
     *
     *
     *
     * Problem Constraints
     * 2 <= |A| <= 40000
     *
     *
     *
     * Input Format
     * First and only argument is vector A
     *
     *
     *
     * Output Format
     * Return the length of the longest path
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *
     * A = [-1, 0]
     * Input 2:
     *
     *
     * A = [-1, 0, 0]
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
     *  Path is 0 -> 1.
     * Explanation 2:
     *
     *  Path is 1 -> 0 -> 2.
     */

    int result = 0;
    public int solve(int[] A) {
        List<List<Integer>> adjucencyList = new ArrayList<>();

        for(int i = 0; i < A.length; i++) {
            adjucencyList.add(new ArrayList<>());
        }

        int root = -1;

        for(int i = 0; i < A.length; i++) {
            if(A[i] == -1) {
                root = i;
            } else {
                adjucencyList.get(A[i]).add(i);
            }
        }

        dfs(adjucencyList, root);

        return result;
    }

    private int dfs(List<List<Integer>> adj, int i) {
        int maxDistance = 0;
        Queue<Integer> heap = new PriorityQueue<>();
        for (int node : adj.get(i)) {
            int dist = dfs(adj, node);
            maxDistance = Math.max(maxDistance, dist);
            heap.add(dist);
            if (heap.size() > 2) heap.poll();
        }

        int temp = 0;
        while (!heap.isEmpty()) temp += heap.poll();
        result = Math.max(result, temp);
        return maxDistance+1;
    }
}
