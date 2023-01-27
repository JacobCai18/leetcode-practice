package com.jacobcai.dc;

public class Lc516 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int ri = 0; ri < n; ri++) {
            dp[ri][ri] = 1;
            for (int le = ri - 1; le > -1; le--) {
                if (s.charAt(le) == s.charAt(ri)) {
                    dp[le][ri] = dp[le + 1][ri - 1] + 2;
                } else {
                    dp[le][ri] = Math.max(dp[le][ri - 1], dp[le + 1][ri]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Lc516 lc516 = new Lc516();
        String s = "bbbab";
        int res = lc516.longestPalindromeSubseq(s);
        System.out.println("res = " + res);
    }
}
