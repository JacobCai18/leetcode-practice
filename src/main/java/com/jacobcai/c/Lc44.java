package com.jacobcai.c;

public class Lc44 {
    public boolean isMatch(String s,
                           String p) {
        int sLen, pLen;
        // dp[i][j]: s前i个字符和p前j个字符是否能匹配
        boolean[][] dp = new boolean[(sLen = s.length()) + 1][(pLen = p.length()) + 1];
        // s前0个字符和p前0个字符能匹配
        dp[0][0] = true;
        for (int j = 1; j <= pLen; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?');
                }
            }
        }
        return dp[sLen][pLen];
    }
    
    public static void main(String[] args) {
        String s = "aa";
        String p = "*";
        Lc44 lc44 = new Lc44();
        boolean res = lc44.isMatch(s,
                                   p);
        System.out.println("res = " + res);
    }
}
