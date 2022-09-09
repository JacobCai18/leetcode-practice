package com.jacobcai.ccc;

public class Lc279_4 {
    public int numSquares(int n) {
        // dp[i][j]: 前 i+1 个完全平方数，凑出 j 所使用到的最少个数
        // dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-k*num]+k)
        // dp[j] = Math.min(dp[j], dp[j-num]+1)
        int[] dp = new int[n + 1];
        // 处理第一个完全平方数的情况
        for (int j = 0; j <= n; j++) {
            dp[j] = j;
        }
        // 处理剩余完全平方数的情况
        for (int i = 2; i * i <= n; i++) {
            int num = i * i;
            for (int j = num; j <= n; j++) {
                dp[j] = Math.min(dp[j],
                                 dp[j - num] + 1);
            }
        }
        return dp[n];
    }
    
    public static void main(String[] args) {
        int n = 12;
        Lc279_4 lc279_4 = new Lc279_4();
        int res = lc279_4.numSquares(n);
        System.out.println("res = " + res);
    }
}
