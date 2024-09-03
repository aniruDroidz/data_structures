package org.anirudroids;

public class Test {
    int age = 1;



    public static void main(String[] args) {

        //System.out.println((char)(1 + '0'));

        System.out.println(compress(new char[] {'a','a','b','b','c','c','c'}));

        //first_1();

//    System.out.println(numIslands(new int[][] {
//            new int[]{1, 1, 0, 0, 0},
//            new int[]{1, 1, 0, 0, 0},
//            new int[]{0, 0, 1, 0, 0},
//            new int[]{0, 0, 0, 1, 1}}));
    }


    static int numIslands(int[][] grid) {
        int numIslands = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    numIslands++;
                    dfs(grid, i, j);
                }
            }
        }
        return numIslands;
    }

    static void dfs(int[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 2 || grid[i][j] == 0) return;

        grid[i][j] = 2;

        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }

    void first() {
        String str = ")) ( ) ) (";
        int requiredParanthesis = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                if(i != str.length()-1) {
                    for (int j = i + 1; j < i + 3; j++) {
                        if (str.charAt(j) != ')') {
                            if (j == i + 1) {
                                requiredParanthesis += 2;
                                i++;
                            } else {
                                requiredParanthesis++;
                                i++;
                            }
                        }
                    }
                }
            } else if (i+1 < str.length() && str.charAt(i+1) == ')') {
                requiredParanthesis++;
                i++;
            } else {
                requiredParanthesis += 2;
                i++;
            }
        }

        System.out.println(requiredParanthesis);
    }

    static void first_1() {
        int ans = 0;

        //String str = ")) ( ) ) (";
        String str = "(()))";

        int opening = 0;
        int closing = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ')') {
                if(opening == 0) {
                    closing += 1;
                } else {
                    opening -= 1;
                }
            } else  if (str.charAt(i) == '(') {
                opening += 2;
            }
        }

        ans += opening;
        ans += closing/2;

        if(closing % 2 != 0) {
            ans += 2;
        }

        System.out.println(ans);
    }

    public static int compress(char[] chars) {
        int i = 0;
        int j = 0;
        int count = 0;

        while(i < chars.length) {
            char curr = chars[i];

            if(count == 0) {
                chars[j++] = curr;
                count++;
            }

            if(i != 0) {
                if(curr == chars[i-1]) {
                    count++;
                }

                if(curr != chars[i-1] || i == chars.length-1){
                    if(count != 1) {
                        String num = String.valueOf(count);
                        char[] digits = num.toCharArray();

                        for (char digit : digits) {
                            chars[j++] = digit;
                        }
                        count = 0;
                    }

                    chars[j++] = curr;
                }
            }
            i++;
        }

        return j-1;
    }
}
