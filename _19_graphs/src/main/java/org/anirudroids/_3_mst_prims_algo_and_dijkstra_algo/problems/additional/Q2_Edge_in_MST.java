package org.anirudroids._3_mst_prims_algo_and_dijkstra_algo.problems.additional;

import java.util.Arrays;
import java.util.Comparator;

public class Q2_Edge_in_MST {
    /**
     * Problem Description
     * Given a undirected weighted graph with A nodes labelled from 1 to A with M edges given in a form of 2D-matrix B of size M * 3 where B[i][0] and B[i][1] denotes the two nodes connected by an edge of weight B[i][2].
     *
     * For each edge check whether it belongs to any of the possible minimum spanning tree or not , return 1 if it belongs else return 0.
     *
     * Return an one-dimensional binary array of size M denoting answer for each edge.
     *
     * NOTE:
     *
     * The graph may be disconnected in that case consider mst for each component.
     * No self-loops and no multiple edges present.
     * Answers in output array must be in order with the input array B output[i] must denote the answer of edge B[i][0] to B[i][1].
     *
     *
     * Problem Constraints
     * 1 <= A, M <= 3*105
     *
     * 1 <= B[i][0], B[i][1] <= A
     *
     * 1 <= B[i][1] <= 103
     *
     *
     *
     * Input Format
     * The first argument given is an integer A representing the number of nodes in the graph.
     *
     * The second argument given is an matrix B of size M x 3 which represents the M edges such that there is a edge between node B[i][0] and node B[i][1] with weight B[i][2].
     *
     *
     *
     * Output Format
     * Return an one-dimensional binary array of size M denoting answer for each edge.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = 3
     *  B = [ [1, 2, 2]
     *        [1, 3, 2]
     *        [2, 3, 3]
     *      ]
     *
     *
     * Example Output
     * Output 1:
     *
     *  [1, 1, 0]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  Edge (1, 2) with weight 2 is included in the MST           1
     *                                                           /   \
     *                                                          2     3
     *  Edge (1, 3) with weight 2 is included in the same MST mentioned above.
     *  Edge (2,3) with weight 3 cannot be included in any of the mst possible.
     *  So we will return [1, 1, 0]
     */

    int[] parent;

    public int[] solve(int A, int[][] B) {
        parent = new int[A + 1];

        for (int i = 0; i < parent.length; i++) { parent[i] = i; }

        int[][] C = new int[B.length][4];
        for (int i = 0; i < C.length; i++) {
            C[i][0] = B[i][0];
            C[i][1] = B[i][1];
            C[i][2] = B[i][2];
            C[i][3] = i;
        }

        Arrays.sort(C, Comparator.comparingInt(b -> b[2]));

        int[] result = new int[B.length];
        int j = 0;
        for (int i = 0; i < C.length; i++) {
            int x = C[i][0];
            int y = C[i][1];
            if (j <= i) {
                while (j < C.length && C[i][2] == C[j][2]) {
                    if (findRoot(C[j][0]) != findRoot(C[j][1])) result[C[j][3]] = 1;
                    j++;
                }
            }
            union(x, y);
        }

        return result;
    }

    private int findRoot(int x) {
        if (parent[x] == x) return x;
        parent[x] = findRoot(parent[x]);
        return parent[x];
    }

    private void union(int x, int y) {
        int xParent = findRoot(x);
        int yParent = findRoot(y);
        if (xParent != yParent) parent[yParent] = xParent;
    }
}
