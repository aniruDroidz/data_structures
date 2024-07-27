package org.anirudroids._3_mst_prims_algo_and_dijkstra_algo.problems.mandatory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q1_Commutable_Islands {
    /**
     * Problem Description
     * There are A islands and there are M bridges connecting them. Each bridge has some cost attached to it.
     *
     * We need to find bridges with minimal cost such that all islands are connected.
     *
     * It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each other.
     *
     *
     *
     * Problem Constraints
     * 1 <= A, M <= 6*104
     *
     * 1 <= B[i][0], B[i][1] <= A
     *
     * 1 <= B[i][2] <= 103
     *
     *
     *
     * Input Format
     * The first argument contains an integer, A, representing the number of islands.
     *
     * The second argument contains an 2-d integer matrix, B, of size M x 3 where Island B[i][0] and B[i][1] are connected using a bridge of cost B[i][2].
     *
     *
     *
     * Output Format
     * Return an integer representing the minimal cost required.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = 4
     *  B = [  [1, 2, 1]
     *         [2, 3, 4]
     *         [1, 4, 3]
     *         [4, 3, 2]
     *         [1, 3, 10]  ]
     * Input 2:
     *
     *  A = 4
     *  B = [  [1, 2, 1]
     *         [2, 3, 2]
     *         [3, 4, 4]
     *         [1, 4, 3]   ]
     *
     *
     * Example Output
     * Output 1:
     *
     *  6
     * Output 2:
     *
     *  6
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  We can choose bridges (1, 2, 1), (1, 4, 3) and (4, 3, 2), where the total cost incurred will be (1 + 3 + 2) = 6.
     * Explanation 2:
     *
     *  We can choose bridges (1, 2, 1), (2, 3, 2) and (1, 4, 3), where the total cost incurred will be (1 + 2 + 3) = 6.
     */

    public int solve(int A, int[][] B) {
        ArrayList<int[]>[] adjacencyList = new ArrayList[A+1];

        for(int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        int start = Integer.MAX_VALUE;
        for(int i = 0; i < B.length; i++) {
            if(B[i][2] < start) start = B[i][0];
            adjacencyList[B[i][0]].add(new int[] {B[i][1], B[i][2]});
            adjacencyList[B[i][1]].add(new int[] {B[i][0], B[i][2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i[2]));

        boolean[] visited = new boolean[A+1];
        visited[start] = true;

        addNodeInHeap(adjacencyList, start, visited, pq);

        int count = 1;
        int result = 0;

        while(count < A) {
            int[] point = pq.poll();

            if(!visited[point[1]]) {
                visited[point[1]] = true;

                count++;
                result += point[2];
                addNodeInHeap(adjacencyList, point[1], visited, pq);
            }
        }

        return result;
    }

    private void addNodeInHeap(ArrayList<int[]>[] adjacencyList, int node, boolean[] visited, PriorityQueue<int[]> pq) {
        for(int i = 0; i < adjacencyList[node].size(); i++) {
            int[] point = adjacencyList[node].get(i);
            if(!visited[point[0]]) pq.offer(new int[] {node, point[0], point[1]});
        }
    }
}
