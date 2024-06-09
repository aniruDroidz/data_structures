package org.anirudroids;

public class Main {
    public static void main(String[] args) {
        int[][] A = new int[2][];
        A[0] = new int[] {74,37,82,1};
        A[1] = new int[] {66,38,16,1};
        adjacent(A);
    }

    public static int adjacent(int[][] A) {
        int[] temp = new int[A.length];
        for(int index = 0; index < A.length; index++) {
            temp[index] = Math.max(A[0][index], A[1][index]);
        }

        int max = 0;
        for(int index = 0; index < temp.length; index++) {
            int first = temp[index];
            for(int jIndex = index + 2; jIndex < temp.length; jIndex++) {
                int second = temp[jIndex];

                max = Math.max(max, first+second);
            }
        }

        return max;
    }
}
