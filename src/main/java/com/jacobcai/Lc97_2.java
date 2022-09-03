package com.jacobcai;

public class Lc97_2 {
    public boolean isInterleave(String s1,
                                String s2,
                                String s3) {
        int l1, l2;
        if ((l1 = s1.length()) + (l2 = s2.length()) != s3.length()) {
            return false;
        }
        // 从使用0个字母开始
        boolean[] dp = new boolean[l2 + 1];
        dp[0] = true;
        for (int j = 1; j < l2 + 1; j++) {
            dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        for (int i = 1; i < l1 + 1; i++) {
            dp[0] = dp[0] && s1.charAt(i - 1) == s3.charAt(i - 1);
            for (int j = 1; j < l2 + 1; j++) {
                dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1) ||
                        dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
            }
        }
        return dp[l2];
    }
    
    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        Lc97_2 lc97_2 = new Lc97_2();
        boolean res = lc97_2.isInterleave(s1,
                                          s2,
                                          s3);
        System.out.println("res = " + res);
    }
}
