package org.anirudroids._2_bfs_matrix_questions_topological_sort.problems.mandatory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q4_Another_BFS {
    /**
     * Problem Description
     *
     * Given a weighted undirected graph having A nodes, a source node C and destination node D.
     *
     * Find the shortest distance from C to D and if it is impossible to reach node D from C then return -1.
     *
     * You are expected to do it in Time Complexity of O(A + M).
     *
     * Note:
     *
     * There are no self-loops in the graph.
     *
     * No multiple edges between two pair of vertices.
     *
     * The graph may or may not be connected.
     *
     * Nodes are Numbered from 0 to A-1.
     *
     * Your solution will run on multiple testcases. If you are using global variables make sure to clear them.
     *
     *
     *
     * Problem Constraints
     *
     * 1 <= A <= 105
     *
     * 0 <= B[i][0], B[i][1] < A
     *
     * 1 <= B[i][2] <= 2
     *
     * 0 <= C < A
     *
     * 0 <= D < A
     *
     *
     *
     * Input Format
     *
     * The first argument given is an integer A, representing the number of nodes.
     *
     * The second argument given is the matrix B, where B[i][0] and B[i][1] are connected through an edge of weight B[i][2].
     *
     * The third argument given is an integer C, representing the source node.
     *
     * The fourth argument is an integer D, representing the destination node.
     *
     * Note: B[i][2] will be either 1 or 2.
     *
     *
     *
     * Output Format
     *
     * Return the shortest distance from C to D. If it is impossible to reach node D from C then return -1.
     *
     *
     *
     * Example Input
     *
     * Input 1:
     *
     *
     * A = 6
     * B = [   [2, 5, 1]
     *         [1, 3, 1]
     *         [0, 5, 2]
     *         [0, 2, 2]
     *         [1, 4, 1]
     *         [0, 1, 1] ]
     * C = 3
     * D = 2
     * Input 2:
     *
     * A = 2
     * B = [   [0, 1, 1]
     *     ]
     * C = 0
     * D = 1
     *
     *
     * Example Output
     *
     * Output 1:
     *
     *  4
     * Output 2:
     *
     *  1
     *
     *
     * Example Explanation
     *
     * Explanation 1:
     *
     * The path to be followed will be:
     *     3 -> 1 (Edge weight : 1)
     *     1 -> 0 (Edge weight : 1)
     *     0 -> 2 (Edge weight : 2)
     * Total length of path = 1 + 1 + 2 = 4.
     * Explanation 2:
     *
     *  Path will be 0-> 1.
     */

    class Pair{
        Integer value;
        Integer weight;
        public Pair(int value, int weight){
            this.value = value;
            this.weight = weight;
        }
    }

    public int solve(int A, int[][] B, int C, int D) {
        if(C == D) return 0;

        List<List<Pair>> adjList = new ArrayList<>();
        for(int i = 0; i <= A; i++){
            adjList.add(new ArrayList<>());
        }
        int newNode = A;
        for(int i = 0; i < B.length; i++){
            if(B[i][2] == 2){
                adjList.add(new ArrayList<>());

                adjList.get(B[i][0]).add(new Pair(newNode, 1));
                adjList.get(newNode).add(new Pair(B[i][0], 1));

                adjList.get(B[i][1]).add(new Pair(newNode, 1));
                adjList.get(newNode).add(new Pair(B[i][1], 1));

                newNode++;
            } else {
                adjList.get(B[i][0]).add(new Pair(B[i][1], 1));
                adjList.get(B[i][1]).add(new Pair(B[i][0], 1));
            }
        }

        boolean[] visited = new boolean[newNode + 1];
        Queue<Pair> q = new LinkedList<>();
        visited[C] = true;
        for(Pair pair : adjList.get(C)){
            q.add(pair);
            visited[pair.value] = true;
        }

        while(!q.isEmpty()){
            Pair temp = q.poll();
            if(temp.value == D)
                return temp.weight;
            for(Pair pair : adjList.get(temp.value)){
                if(!visited[pair.value]){
                    visited[pair.value] = true;
                    if(pair.value == D)
                        return temp.weight + 1;
                    q.add(new Pair(pair.value, temp.weight + 1));
                    visited[pair.value] = true;
                }
            }
        }
        return -1;
    }
}
