package com.jacobcai.c;

public class Lc64 {
    public int minPathSum(int[][] grid) {
        int rowLen, colLen;
        rowLen = grid.length;
        colLen = grid[0].length;
        int[] dp = new int[colLen];
        dp[0] = grid[0][0];
        for (int j = 1; j < colLen; j++) {
            dp[j] = grid[0][j] + dp[j - 1];
        }
        for (int i = 1; i < rowLen; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < colLen; j++) {
                dp[j] = grid[i][j] + Math.min(dp[j],
                                              dp[j - 1]);
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
