package com.jacobcai.ccc;

public class Lc221_2 {
    public int maximalSquare(char[][] matrix) {
        int rowLen, colLen, max;
        rowLen = matrix.length;
        colLen = matrix[0].length;
        max = 0;
        int[][] dp = new int[rowLen][colLen];
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j],
                                                         dp[i][j - 1]),
                                                dp[i - 1][j - 1]);
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
        Lc221_2 lc221 = new Lc221_2();
        int res = lc221.maximalSquare(matrix);
        System.out.println("res = " + res);
    }
}
