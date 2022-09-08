package com.jacobcai.cii;

public class Lc279_2 {
    public int numSquares(int n) {
        // dp[0] = 0: i-j*j=0时需要的次数为0+1
        // dp[i] = min(dp[i-j*j]) + 1, j in [1,√i]
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min,
                                dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
    
    public static void main(String[] args) {
        int n = 12;
        Lc279_2 lc279_2 = new Lc279_2();
        int res = lc279_2.numSquares(n);
        System.out.println("res = " + res);
    }
}
