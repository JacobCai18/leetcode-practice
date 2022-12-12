package com.jacobcai.c;

public class Lc72 {
    public int minDistance(String word1,
                           String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        // 有一个字符串为空串
        if (len1 * len2 == 0) {
            return len1 + len2;
        }
        // DP 数组
        int[][] dp = new int[len1 + 1][len2 + 1];
        // 边界状态初始化
        for (int i = 0; i < len1 + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < len2 + 1; j++) {
            dp[0][j] = j;
        }
        // 计算所有 DP 值
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                int left = dp[i - 1][j] + 1;
                int down = dp[i][j - 1] + 1;
                int leftDown = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    leftDown += 1;
                }
                dp[i][j] = Math.min(left,
                                   Math.min(down,
                                            leftDown));
            }
        }
        return dp[len1][len2];
    }
    
    public static void main(String[] args) {
        Lc72 lc72 = new Lc72();
        int res = lc72.minDistance("horse",
                                   "ros");
        System.out.println("res = " + res);
    }
}
