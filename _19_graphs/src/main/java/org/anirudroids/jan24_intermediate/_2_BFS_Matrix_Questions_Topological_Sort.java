package org.anirudroids.jan24_intermediate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _2_BFS_Matrix_Questions_Topological_Sort {

    /**
     * Agenda
     * BFS Traversal
     * Questions
     * Topological sort
     */

    public static void main(String[] args) {
        solve(1,1,1,1, new int[] {0,0}, new int[]{0,0});
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

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            Pair pair = (Pair)o;

            return this.x == pair.x && this.y == pair.y;
        }
    }

    public static String solve(int A, int B, int C, int D, int[] E, int[] F) {
        List<Pair> invalidPoints = new ArrayList<>();

        int[][] directions = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for(int index = 0; index < C; index++) {
            int centerX = E[index];
            int centerY = F[index];

            invalidPoints.add(new Pair(centerX, centerY));

            for(int j = 0; j < directions.length; j++) {
                for(int k = 1; k <= D; k++) {
                    int x = centerX + directions[j][0] * k;
                    int y = centerY + directions[j][1] * k;

                    invalidPoints.add(new Pair(x, y));
                }
            }
        }

        boolean[][] visited = new boolean[A+1][B+1];

        for(int i = 0; i <= A; i++) {
            for(int j = 0; j <= B; j++) {
                if(!visited[i][j]) {
                    dfs(visited, directions, invalidPoints, i, j);
                }
            }
        }

        return visited[0][0] && visited[A][B] ? "YES" : "NO";
    }

    private static void dfs(boolean[][] visited, int[][] directions, List<Pair> invalidPoints, int i, int j) {
        if(isValid(visited, directions, invalidPoints, i, j)) return;

        if(!invalidPoints.contains(new Pair(i, j))) {
            visited[i][j] = true;
        }

        for(int index = 0; index < directions.length; index++) {
            int x = i + directions[index][0];
            int y = j + directions[index][1];

            if(isValid(visited, directions, invalidPoints, i, j) && !visited[x][y]) {
                dfs(visited, directions, invalidPoints, x, y);
            }
        }
    }

    private static boolean isValid(boolean[][] visited, int[][] directions, List<Pair> invalidPoints, int i, int j) {
        return i < 0 || j < 0 || i >= visited.length || j >= visited[i].length;
    }
}
