package com.jacobcai.c;

public class Lc96 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
    
    public static void main(String[] args) {
        Lc96 lc96 = new Lc96();
        int res = lc96.numTrees(3);
        System.out.println("res = " + res);
    }
}
