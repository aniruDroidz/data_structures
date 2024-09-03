package org.anirudroids.interview;

public class FirstInterview {
    /**
     * Question 1.
     * Given a parentheses string `s` containing only the characters '(' and ')'.
     * A parentheses string is balanced if:
     * ● Any left parenthesis ( must have a corresponding two consecutive right parenthesis ))
     * ● Left parenthesis ( must go before the corresponding two consecutive right parenthesis ))
     * In other words, we treat "(" as open needing two ")" to close. Your task is to insert the minimum number
     * of parentheses '(' and/or ')' to make the string balanced and return the minimum number of insertions
     * needed.
     * Input: " ( ( ) ) ) "
     * Output: 1
     * Explanation:
     * The string needs one more ')' at the end to be balanced.
     *
     * Input: "  )) ( ) ) ( "
     * Output: 3
     * Explanation:
     * Add '(' to match the first '))', Add '))' to match the last '('.
     *
     * int requiredParanthesis = 0;
     *
     * for(int i = 0; i < str.length(); i++) {
     *
     * }
     * Question 2:
     * Imagine you are given a 2D binary grid representing a map with 1s (land) and 0s (water). Your task is to
     * implement a function that returns the number of islands. An island is formed by connecting adjacent lands
     * horizontally or vertically, surrounded by water. Assume all four edges of the grid are surrounded by water.
     * Implement the following function:
     *
     * int numIslands(int[][] grid) {
     *     int numIslands = 0;
     *
     *     for(int i = 0; i < grid.length; i++) {
     *     for(int j = 0; j < grid[i].length; j++) {
     *     if(grid[i][j] == 1) {
     *             numIslands++;
     *             dfs(grid, i, j);
     *         }
     *     }
     * }
     *     return numIslands;
     * }
     *
     * void dfs(int[][] grid, int i, int j) {
     *     if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 2) return;
     *
     *     grid[i][j] = 2;
     *
     *     dfs(grid, i+1, j);
     *     dfs(grid, i-1, j);
     *     dfs(grid, i, j+1);
     *     dfs(grid, i, j-1);
     * }
     *
     * Input:
     * grid = [
     * [1, 1, 0, 0, 0],
     * [0, 1, 0, 0, 0],
     * [1, 0, 0, 1, 1],
     * [0, 0, 0, 0, 0],
     * [1, 0, 1, 0, 0]
     * ]
     * Output: 5
     *
     *
     * grid = [
     * [1, 1, 0, 0, 0],
     * [1, 1, 0, 0, 0],
     * [0, 0, 1, 0, 0],
     * [0, 0, 0, 1, 1]
     */
}
