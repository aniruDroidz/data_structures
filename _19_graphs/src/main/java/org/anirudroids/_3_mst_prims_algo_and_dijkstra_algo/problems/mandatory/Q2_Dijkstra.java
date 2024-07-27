package org.anirudroids._3_mst_prims_algo_and_dijkstra_algo.problems.mandatory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q2_Dijkstra {
    /**
     * Problem Description
     * Given a weighted undirected graph having A nodes and M weighted edges, and a source node C.
     *
     * You have to find an integer array D of size A such that:
     *
     * D[i]: Shortest distance from the C node to node i.
     * If node i is not reachable from C then -1.
     * Note:
     *
     * There are no self-loops in the graph.
     * There are no multiple edges between two pairs of vertices.
     * The graph may or may not be connected.
     * Nodes are numbered from 0 to A-1.
     * Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.
     *
     *
     * Problem Constraints
     * 1 <= A <= 1e5
     *
     * 0 <= B[i][0],B[i][1] < A
     *
     * 0 <= B[i][2] <= 1e3
     *
     * 0 <= C < A
     *
     *
     *
     * Input Format
     * The first argument is an integer A, representing the number of nodes in the graph.
     * The second argument is a matrix B of size M x 3, where each row represents an edge in the graph. The three columns of each row denote the source node B[i][0], the destination node B[i][1], and the weight of the edge B[i][2].
     * The third argument is an integer C, representing the source node for which the shortest distance to all other nodes needs to be found.
     *
     *
     * Output Format
     * Return the integer array D.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     * A = 6
     * B = [   [0, 4, 9]
     *         [3, 4, 6]
     *         [1, 2, 1]
     *         [2, 5, 1]
     *         [2, 4, 5]
     *         [0, 3, 7]
     *         [0, 1, 1]
     *         [4, 5, 7]
     *         [0, 5, 1] ]
     * C = 4
     * Input 2:
     *
     * A = 5
     * B = [   [0, 3, 4]
     *         [2, 3, 3]
     *         [0, 1, 9]
     *         [3, 4, 10]
     *         [1, 3, 8]  ]
     * C = 4
     *
     *
     * Example Output
     * Output 1:
     *
     * D = [7, 6, 5, 6, 0, 6]
     * Output 2:
     *
     * D = [14, 18, 13, 10, 0]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  All Paths can be considered from the node C to get shortest path
     * Explanation 2:
     *
     *  All Paths can be considered from the node C to get shortest path
     */

    public int[] solve(int A, int[][] B, int C) {
        ArrayList<int[]>[] adjacencyList = new ArrayList[A+1];

        for(int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for(int i = 0; i < B.length; i++) {
            adjacencyList[B[i][0]].add(new int[] {B[i][1], B[i][2]});
            adjacencyList[B[i][1]].add(new int[] {B[i][0], B[i][2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i[1]));

        pq.offer(new int[] {C, 0});

        int[] result = new int[A];
        Arrays.fill(result, Integer.MAX_VALUE);

        result[C] = 0;

        while(!pq.isEmpty()) {
            int[] point = pq.poll();

            for(int i = 0; i < adjacencyList[point[0]].size(); i++) {
                int[] neighbour = adjacencyList[point[0]].get(i);

                int nodeValue = neighbour[0];
                int weight = neighbour[1];

                int newWeight = result[point[0]] + weight;

                if(newWeight < result[nodeValue]) {
                    result[nodeValue] = newWeight;
                    pq.offer(new int[] {nodeValue, newWeight});
                }
            }
        }

        for(int i = 0; i < result.length; i++) {
            if(result[i] == Integer.MAX_VALUE) {
                result[i] = -1;
            }
        }
        return result;
    }
}
