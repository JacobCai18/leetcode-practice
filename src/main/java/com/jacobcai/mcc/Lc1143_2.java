package com.jacobcai.mcc;

public class Lc1143_2 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int pre = 0;
            for (int j = 1; j <= n; j++) {
                int cur = dp[j];
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[j] = pre + 1;
                else
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                pre = cur;
            }
        }
        return dp[n];
    }
    
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "badcbe";
        Lc1143_2 lc1143_2 = new Lc1143_2();
        int res = lc1143_2.longestCommonSubsequence(text1, text2);
        System.out.println("res = " + res);
    }
}
