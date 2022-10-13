package com.jacobcai.c;

public class Lc63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rowLen, colLen;
        int[][] dp = new int[rowLen = obstacleGrid.length][colLen = obstacleGrid[0].length];
        dp[0][0] = obstacleGrid[0][0] == 0 ?
                   1 :
                   0;
        if (dp[0][0] == 0) {
            return 0;
        }
        for (int i = 1; i < rowLen; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }
        for (int j = 1; j < colLen; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            }
            dp[0][j] = 1;
        }
        for (int i = 1; i < rowLen; i++) {
            for (int j = 1; j < colLen; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[rowLen - 1][colLen - 1];
    }
    
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        Lc63 lc63 = new Lc63();
        int res = lc63.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(res);
    }
}
