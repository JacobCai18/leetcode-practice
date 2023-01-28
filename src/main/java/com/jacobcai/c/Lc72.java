package com.jacobcai.c;

public class Lc72 {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if (m * n == 0) return m + n; // 有一个字符串为空串
        int[][] dp = new int[m + 1][n + 1]; // dp[i][j] = 串 1 [1, i] 转换成串 2 [1, j] 的最少操作数
        for (int i = 1; i < m + 1; i++) dp[i][0] = i;
        for (int j = 1; j < n + 1; j++) dp[0][j] = j;
        for (int i = 1; i < m + 1; i++)
            for (int j = 1; j < n + 1; j++) {
                int a, b, c;
                a = dp[i - 1][j] + 1; // 串 1 插入
                b = dp[i][j - 1] + 1; // 串 2 插入
                c = dp[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1); // 串 1 替换
                dp[i][j] = Math.min(a, Math.min(b, c));
            }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Lc72 lc72 = new Lc72();
        int res = lc72.minDistance("horse", "ros");
        System.out.println("res = " + res);
    }
}
