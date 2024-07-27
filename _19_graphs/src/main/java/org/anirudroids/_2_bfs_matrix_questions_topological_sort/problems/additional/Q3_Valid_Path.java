package org.anirudroids._2_bfs_matrix_questions_topological_sort.problems.additional;

import java.util.LinkedList;
import java.util.Queue;

public class Q3_Valid_Path {
    /**
     * Problem Description
     * There is a rectangle with left bottom as (0, 0) and right up as (x, y).
     *
     * There are N circles such that their centers are inside the rectangle.
     *
     * Radius of each circle is R. Now we need to find out if it is possible that we can move from (0, 0) to (x, y) without touching any circle.
     *
     * Note : We can move from any cell to any of its 8 adjecent neighbours and we cannot move outside the boundary of the rectangle at any point of time.
     *
     *
     *
     * Problem Constraints
     * 0 <= x , y, R <= 100
     *
     * 1 <= N <= 1000
     *
     * Center of each circle would lie within the grid
     *
     *
     *
     * Input Format
     * 1st argument given is an Integer x , denoted by A in input.
     *
     * 2nd argument given is an Integer y, denoted by B in input.
     *
     * 3rd argument given is an Integer N, number of circles, denoted by C in input.
     *
     * 4th argument given is an Integer R, radius of each circle, denoted by D in input.
     *
     * 5th argument given is an Array A of size N, denoted by E in input, where A[i] = x cordinate of ith circle
     *
     * 6th argument given is an Array B of size N, denoted by F in input, where B[i] = y cordinate of ith circle
     *
     *
     *
     * Output Format
     * Return YES or NO depending on weather it is possible to reach cell (x,y) or not starting from (0,0).
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  x = 2
     *  y = 3
     *  N = 1
     *  R = 1
     *  A = [2]
     *  B = [3]
     * Input 2:
     *
     *  x = 3
     *  y = 3
     *  N = 1
     *  R = 1
     *  A = [0]
     *  B = [3]
     *
     *
     * Example Output
     * Output 1:
     *
     *  NO
     * Output 2:
     *
     *  YES
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  There is NO valid path in this case
     * Explanation 2:
     *
     *  There is many valid paths in this case.
     *  One of the path is (0, 0) -> (1, 0) -> (2, 0) -> (3, 0) -> (3, 1) -> (3, 2) -> (3, 3).
     */

    class Pair {
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

    public String solve(int A, int B, int C, int D, int[] E, int[] F) {

        boolean[][] visited = new boolean[A+1][B+1];
        for (int i = 0; i < C; i++) {
            int centerX = E[i];
            int centerY = F[i];

            int radius = D;

            for (int x = Math.max(0, centerX - radius); x <= Math.min(A, centerX + radius); x++) {
                for (int y = Math.max(0, centerY - radius); y <= Math.min(B, centerY + radius); y++) {
                    if ((x - centerX) * (x - centerX) + (y - centerY) * (y - centerY) <= radius * radius) {
                        visited[x][y] = true;
                    }
                }
            }
        }

        if (visited[0][0] || visited[A][B]) {
            return "NO";
        }

        return bfs(A, B, visited) ? "YES" : "NO";
    }

    private boolean bfs(int A, int B, boolean[][] visited) {

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();

            int x = current.x;
            int y = current.y;

            if (x == A && y == B) {
                return true;
            }

            int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX <= A && newY >= 0 && newY <= B && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.offer(new Pair(newX, newY));
                }
            }
        }

        return false;

    }
}
