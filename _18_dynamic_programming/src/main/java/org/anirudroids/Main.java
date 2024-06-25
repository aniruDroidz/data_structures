package org.anirudroids;

public class Main {
    public static void main(String[] args) {
        System.out.println(numDistinct("ABC", "B"));
    }

    public static int numDistinct(String A, String B) {

        int[][] dp = new int[B.length()+1][A.length()+1];

        for(int i = 0; i <= B.length(); i++) {
            for (int j = 1; j <= A.length(); j++) {
                if(i == 0) {
                    dp[i][j] = 1;
                }
                else if(B.charAt(i) != A.charAt(j)) {
                    dp[i][j] = dp[i][j-1];
                } else {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
                }
            }
        }
        return dp[B.length()][A.length()];
    }
}