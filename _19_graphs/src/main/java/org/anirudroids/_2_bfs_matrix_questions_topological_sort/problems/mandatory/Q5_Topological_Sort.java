package org.anirudroids._2_bfs_matrix_questions_topological_sort.problems.mandatory;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Q5_Topological_Sort {
    /**
     * Problem Description
     * Given an directed acyclic graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
     *
     * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv, vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.
     *
     * Return the topological ordering of the graph and if it doesn't exist then return an empty array.
     *
     * If there is a solution return the correct ordering. If there are multiple solutions print the lexographically smallest one.
     *
     * Ordering (a, b, c) is said to be lexographically smaller than ordering (e, f, g) if a < e or if(a==e) then b < f and so on.
     *
     * NOTE:
     *
     * There are no self-loops in the graph.
     * The graph may or may not be connected.
     * Nodes are numbered from 1 to A.
     * Your solution will run on multiple test cases. If you are using global variables make sure to clear them.
     *
     *
     * Problem Constraints
     * 2 <= A <= 104
     *
     * 1 <= M <= min(100000,A*(A-1))
     *
     * 1 <= B[i][0], B[i][1] <= A
     *
     *
     *
     * Input Format
     * The first argument given is an integer A representing the number of nodes in the graph.
     *
     * The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
     *
     *
     *
     * Output Format
     * Return a one-dimensional array denoting the topological ordering of the graph and it it doesn't exist then return empty array.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = 6
     *  B = [  [6, 3]
     *         [6, 1]
     *         [5, 1]
     *         [5, 2]
     *         [3, 4]
     *         [4, 2] ]
     * Input 2:
     *
     *  A = 3
     *  B = [  [1, 2]
     *         [2, 3]
     *         [3, 1] ]
     *
     *
     * Example Output
     * Output 1:
     *
     *  [5, 6, 1, 3, 4, 2]
     * Output 2:
     *
     *  []
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  The given graph contain no cycle so topological ordering exists which is [5, 6, 1, 3, 4, 2]
     * Explanation 2:
     *
     *  The given graph contain cycle so topological ordering not possible we will return empty array.
     */

    public int[] solve(int A, int[][] B) {
        int[] inDegree = new int[A+1];
        List<List<Integer>> list = build(A, B, inDegree);
        return topologicalOrder(A, inDegree, list);
    }

    private int[] topologicalOrder(int n, int[] inDegree, List<List<Integer>> list) {
        int[] ans = new int[n];
        int j = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int current = q.poll();
            ans[j] = current;
            j++;
            List<Integer> neighbour = list.get(current);
            for (int v : neighbour) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    q.add(v);
                }
            }
        }
        for (int i : ans) {
            if (i != 0) return ans;
        }

        return new int[0];
    }

    private List<List<Integer>> build(int n, int[][] edges, int[] inDegree){
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            list.get(u).add(v);
            inDegree[v]++;
        }

        return list;
    }
}
