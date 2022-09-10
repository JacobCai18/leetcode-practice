package com.jacobcai.dc;

public class Lc518 {
    public int change(int amount,
                      int[] coins) {
        // dp[i][j]: 前i种coin凑成j的组合数
        // dp[i][j] = dp[i-1][j] + dp[i-1][j-k*coin[i-1]]
        // dp[j] = dp[j] + dp[j-coin[i-1]]
        int[] dp = new int[amount + 1];
        // 前0种coin凑成0的组合数为1
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }
    
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        Lc518 lc518 = new Lc518();
        int res = lc518.change(amount,
                               coins);
        System.out.println("res = " + res);
    }
}
