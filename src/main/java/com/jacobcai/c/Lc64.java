package com.jacobcai.c;

public class Lc64 {
    public int minPathSum(int[][] grid) {
        int rowLen, colLen;
        rowLen = grid.length;
        colLen = grid[0].length;
        int[] dp = new int[colLen];
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                int min;
                if (j == 0) {
                    min = dp[j];
                } else if (i == 0) {
                    min = dp[j - 1];
                } else {
                    min = Math.min(dp[j],
                                   dp[j - 1]);
                }
                dp[j] = grid[i][j] + min;
            }
        }
        return dp[colLen - 1];
    }
    
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        Lc64 lc64 = new Lc64();
        int res = lc64.minPathSum(grid);
        System.out.println("res = " + res);
    }
}
