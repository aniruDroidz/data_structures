package org.anirudroids._1_introduction_dfs_cycle_detection.problems.mandatory;

import java.util.ArrayList;

public class Q2_Cycle_in_Directed_Graph {
    /**
     * Problem Description
     * Given an directed graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
     *
     * Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.
     *
     * NOTE:
     *
     * The cycle must contain atleast two nodes.
     * There are no self-loops in the graph.
     * There are no multiple edges between two nodes.
     * The graph may or may not be connected.
     * Nodes are numbered from 1 to A.
     * Your solution will run on multiple test cases. If you are using global variables make sure to clear them.
     *
     *
     * Problem Constraints
     * 2 <= A <= 105
     *
     * 1 <= M <= min(200000,A*(A-1))
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
     * Return 1 if cycle is present else return 0.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = 5
     *  B = [  [1, 2]
     *         [4, 1]
     *         [2, 4]
     *         [3, 4]
     *         [5, 2]
     *         [1, 3] ]
     * Input 2:
     *
     *  A = 5
     *  B = [  [1, 2]
     *         [2, 3]
     *         [3, 4]
     *         [4, 5] ]
     *
     *
     * Example Output
     * Output 1:
     *
     *  1
     * Output 2:
     *
     *  0
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  The given graph contain cycle 1 -> 3 -> 4 -> 1 or the cycle 1 -> 2 -> 4 -> 1
     * Explanation 2:
     *
     *  The given graph doesn't contain any cycle.
     */

    public static ArrayList<Integer>[] graph;

    public static boolean[] visited;

    public static boolean[] path;

    public static boolean dfsCycle(int node) {
        visited[node] = true;
        path[node] = true;
        for(int v: graph[node]) {
            if(path[v]) return true;
            if(!visited[v] && dfsCycle(v)) {
                return true;
            }
        }
        path[node] = false;
        return false;
    }

    public int solve(int A, int[][] B) {
        graph = new ArrayList[A+1];
        visited = new boolean[A+1];
        path = new boolean[A+1];
        for(int i=0;i<graph.length;i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<B.length;i++) {
            int src = B[i][0];
            int des = B[i][1];
            graph[src].add(des);
        }

        for(int i=1;i<=A;i++) {
            if(!visited[i]) {
                if(dfsCycle(i)) return 1;
            }
        }
        return 0;
    }
}
