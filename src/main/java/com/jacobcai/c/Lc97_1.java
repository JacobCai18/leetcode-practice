package com.jacobcai.c;

public class Lc97_1 {
    public boolean isInterleave(String s1,
                                String s2,
                                String s3) {
        int l1, l2;
        if ((l1 = s1.length()) + (l2 = s2.length()) != s3.length()) {
            return false;
        }
        // 从使用0个字母开始
        boolean[][] dp = new boolean[l1 + 1][l2 + 1];
        // 确定初始状态
        dp[0][0] = true;
        for (int i = 1; i < l1 + 1; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int j = 1; j < l2 + 1; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        // 父问题借助子问题解决
        for (int i = 1; i < l1 + 1; i++) {
            for (int j = 1; j < l2 + 1; j++) {
                dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1) ||
                           dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
            }
        }
        return dp[l1][l2];
    }
    
    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        Lc97_1 lc97_1 = new Lc97_1();
        boolean res = lc97_1.isInterleave(s1,
                                          s2,
                                          s3);
        System.out.println("res = " + res);
    }
}
