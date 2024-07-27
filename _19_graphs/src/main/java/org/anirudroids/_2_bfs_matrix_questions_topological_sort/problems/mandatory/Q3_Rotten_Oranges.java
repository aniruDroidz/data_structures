package org.anirudroids._2_bfs_matrix_questions_topological_sort.problems.mandatory;

import java.util.LinkedList;

public class Q3_Rotten_Oranges {
    /**
     * Problem Description
     * Given a matrix of integers A of size N x M consisting of 0, 1 or 2.
     *
     * Each cell can have three values:
     *
     * The value 0 representing an empty cell.
     *
     * The value 1 representing a fresh orange.
     *
     * The value 2 representing a rotten orange.
     *
     * Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to a rotten orange becomes rotten. Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1 instead.
     *
     * Note: Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.
     *
     *
     *
     * Problem Constraints
     * 1 <= N, M <= 1000
     *
     * 0 <= A[i][j] <= 2
     *
     *
     *
     * Input Format
     * The first argument given is the integer matrix A.
     *
     *
     *
     * Output Format
     * Return the minimum number of minutes that must elapse until no cell has a fresh orange.
     *
     * If this is impossible, return -1 instead.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     * A = [   [2, 1, 1]
     *         [1, 1, 0]
     *         [0, 1, 1]   ]
     * Input 2:
     *
     *
     * A = [   [2, 1, 1]
     *         [0, 1, 1]
     *         [1, 0, 1]   ]
     *
     *
     * Example Output
     * Output 1:
     *
     *  4
     * Output 2:
     *
     *  -1
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     * Minute 0: [ [2, 1, 1]
     *             [1, 1, 0]
     *             [0, 1, 1] ]
     * Minute 1: [ [2, 2, 1]
     *             [2, 1, 0]
     *             [0, 1, 1] ]
     * Minute 2: [ [2, 2, 2]
     *             [2, 2, 0]
     *             [0, 1, 1] ]
     * Minute 3: [ [2, 2, 2]
     *             [2, 2, 0]
     *             [0, 2, 1] ]
     * Minute 4: [ [2, 2, 2]
     *             [2, 2, 0]
     *             [0, 2, 2] ]
     * At Minute 4, all the oranges are rotten.
     * Explanation 2:
     *
     * The fresh orange at 2nd row and 0th column cannot be rotten, So return -1.
     */

    int[] x = new int[]{-1, 0, 1, 0};
    int[] y = new int[]{0, 1, 0, -1};

    public int solve(int[][] A) {
        LinkedList<Integer[]> q=new LinkedList<>();

        int freshOranges=0;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                if(A[i][j]==2){
                    q.add(new Integer[]{i,j,0});
                }else if(A[i][j]==1){
                    freshOranges++;
                }
            }
        }

        if(freshOranges==0) return 0;
        int maximumTime=0;
        while(!q.isEmpty()){
            Integer[] cell=q.remove();
            int a=cell[0];
            int b=cell[1];
            int time=cell[2];
            maximumTime=time;

            for(int i=0;i<=3;i++){
                int newA=a+x[i];
                int newB=b+y[i];
                if(newA>=0 && newA<A.length && newB>=0 && newB<A[0].length){
                    if(A[newA][newB]==1){
                        A[newA][newB]=2;
                        q.add(new Integer[]{newA,newB,time+1});
                        freshOranges--;
                    }
                }
            }
        }

        if(freshOranges>0) return -1;

        return maximumTime;
    }
}
