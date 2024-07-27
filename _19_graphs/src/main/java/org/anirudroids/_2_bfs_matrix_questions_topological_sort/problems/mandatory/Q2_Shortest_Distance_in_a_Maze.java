package org.anirudroids._2_bfs_matrix_questions_topological_sort.problems.mandatory;

import java.util.LinkedList;
import java.util.Queue;

public class Q2_Shortest_Distance_in_a_Maze {
    /**
     * Problem Description
     * Given a matrix of integers A of size N x M describing a maze. The maze consists of empty locations and walls.
     *
     * 1 represents a wall in a matrix and 0 represents an empty location in a wall.
     *
     * There is a ball trapped in a maze. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall (maze boundary is also considered as a wall). When the ball stops, it could choose the next direction.
     *
     * Given two array of integers of size B and C of size 2 denoting the starting and destination position of the ball.
     *
     * Find the shortest distance for the ball to stop at the destination. The distance is defined by the number of empty spaces traveled by the ball from the starting position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.
     *
     *
     *
     * Problem Constraints
     * 2 <= N, M <= 100
     *
     * 0 <= A[i] <= 1
     *
     * 0 <= B[i][0], C[i][0] < N
     *
     * 0 <= B[i][1], C[i][1] < M
     *
     *
     *
     * Input Format
     * The first argument given is the integer matrix A.
     *
     * The second argument given is an array of integer B.
     *
     * The third argument if an array of integer C.
     *
     *
     *
     * Output Format
     * Return a single integer, the minimum distance required to reach destination
     *
     *
     *
     * Example Input
     * Input 1:
     *
     * A = [ [0, 0],
     *       [0, 0] ]
     * B = [0, 0]
     * C = [0, 1]
     * Input 2:
     *
     * A = [ [0, 1],
     *       [1, 0] ]
     * B = [0, 0]
     * C = [1, 1]
     *
     *
     * Example Output
     * Output 1:
     *
     *  1
     * Output 2:
     *
     *  -1
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  Go directly from start to destination in distance 1.
     * Explanation 2:
     *
     *  It is impossible to reach the destination from (0, 0) to (1, 1) as there are walls at (1, 0) and (0, 1)
     */
    class Position {
        int x;
        int y;
        int count;

        Position(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public int solve(int[][] A, int[] B, int[] C) {
        int[] directions = new int[]{0, 1, 0, -1, 0};

        boolean[][] visited = new boolean[A.length][A[0].length];

        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(B[0], B[1], 0));

        while(!queue.isEmpty()) {
            Position position = queue.poll();
            int x = position.x;
            int y = position.y;
            if(x == C[0] && y == C[1]) {
                return position.count;
            }

            for(int i = 0; i < directions.length-1; i++) {
                int nX = x;
                int nY = y;

                int count = position.count;

                while(nX >= 0 && nX < A.length && nY >= 0 && nY < A[0].length && A[nX][nY] == 0) {
                    nX += directions[i];
                    nY += directions[i+1];

                    count++;
                }

                nX -= directions[i];
                nY -= directions[i+1];
                count--;

                if(!visited[nX][nY]){
                    queue.add(new Position(nX, nY, count));
                    visited[nX][nY] = true;
                }
            }
        }
        return -1;
    }

}
