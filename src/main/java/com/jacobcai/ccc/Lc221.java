package com.jacobcai.ccc;

public class Lc221 {
    public int maximalSquare(char[][] matrix) {
        int rowLen, colLen, max;
        rowLen = matrix.length;
        colLen = matrix[0].length;
        max = 0;
        int[][] dp = new int[rowLen][colLen];
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1;
                    if (i > 0 && j > 0) {
                        int cur = Math.min(dp[i][j - 1],
                                           dp[i - 1][j]);
                        if (matrix[i - cur][j - cur] == '1') {
                            dp[i][j] = cur + 1;
                        } else {
                            dp[i][j] = cur;
                        }
                    }
                    max = Math.max(max,
                                   dp[i][j]);
                }
            }
        }
        return max * max;
    }
    
    public static void main(String[] args) {
        char[][] matrix = {{'0', '1', '1', '0', '1'},
                           {'1', '1', '0', '1', '0'},
                           {'0', '1', '1', '1', '0'},
                           {'1', '1', '1', '1', '0'},
                           {'1', '1', '1', '1', '1'},
                           {'0', '0', '0', '0', '0'}};
        Lc221 lc221 = new Lc221();
        int res = lc221.maximalSquare(matrix);
        System.out.println("res = " + res);
    }
}
