package com.jacobcai.c;

public class Lc91 {
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        for (int i = 1; i <= len; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len];
    }
    
    public static void main(String[] args) {
        String s = "226";
        Lc91 lc91 = new Lc91();
        int res = lc91.numDecodings(s);
        System.out.println("res = " + res);
    }
}
