package com.jacobcai.c;

public class Lc63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int rowLen, colLen;
        rowLen = obstacleGrid.length;
        int[] dp = new int[colLen = obstacleGrid[0].length];
        dp[0] = 1;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[colLen - 1];
    }
    
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        Lc63 lc63 = new Lc63();
        int res = lc63.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(res);
    }
}
