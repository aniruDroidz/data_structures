package org.anirudroids.jan24_intermediate;

import java.util.LinkedList;
import java.util.Queue;

public class _2_BFS_Matrix_Questions_Topological_Sort {

    /**
     * Agenda
     * BFS Traversal
     * Questions
     * Topological sort
     */

    public static void main(String[] args) {

    }

    /**
     * Breadth First Search (BFS) Traversal
     */

    static Queue<Integer> queue = new LinkedList<>();
    private static void first(int[] a) {
        boolean[] visited = new boolean[a.length];

        for(int i = 0; i < a.length; i++) {
            if(!visited[i]) bfs(a[i], visited);
        }
    }

    private static void bfs(int num, boolean[] visited) {
        visited[num] = true;
        queue.offer(num);

    }

    /**
     * Rotten Oranges
     * Given a matrix of integers
     * 0 -> Empty
     * 1 -> Fresh
     * 2 -> Rotten
     *
     * Every minute any fresh orange which is adjacent to rotten orange becomes rotten
     * In how many minutes will all oranges become rotten? If not possible, then return -1
     *
     * (Multi-source BFS)
     */
    private static int second(int[][] matrix) {
        int fresh = 0;
        int minutes = 0;

        // 1. Traverse and insert rotten orange into a queue. Also keep count of fresh orange
        if(fresh == 0) return 0;
        Queue<Integer[]> q = new LinkedList<>();
        while(!q.isEmpty()) {
            Integer[] cell = q.poll();
            int x = cell[0];
            int y = cell[1];
            int min = cell[2];

            for(int i = 0; i < 3; i++) {
                //int newX = x +
            }
        }

        return 0;
    }

    /**
     * Flipkart delivery
     * Find minimum distance from warehouse for each pin code.
     *
     * (Multi-source BFS).. same as previous question
     */
    private static void third() {

    }

    /**
     * Possibility of finishing the course
     * N = 5
     * 1 -> 2 & 3
     * 2 -> 3 & 5
     * 3 -> 4
     * 4 -> 2
     */

    // Topological Order: Linear ordering of all nodes such that if there's an edge from node i to j, then i will be on the left of j
    // Multiple topological order can exist for graphs
    // Either keeps track of in-degree OR out-degree
    // For in-degree (left to right), topological sort can end if outdegree = 0(length of adjacency list) for that node

    private static void forth() {
        // Compute in-degree

        // 1. Insert all nodes in queue with in-degree 0
        // 2. For every deque, visit all neighbours and update in-degree (reduce by 1)
        // 3. If updated in-degree of any node becomes zero, insert it into queue and repeat step 2 & 3 until queue is empty
    }

    // BFS would be the better choice to find the shortest path to destination.
}
