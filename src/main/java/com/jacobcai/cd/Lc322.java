package com.jacobcai.cd;

import java.util.Arrays;

public class Lc322 {
    public int coinChange(int[] coins,
                          int amount) {
        // dp[i][j]: 前 i 种coin凑成 j 所需的最少个数
        // dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-k*coins[i]]+k)
        // dp[j] = Math.min(dp[j], dp[j-coins[i]]+1)
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,
                    0x3f3f3f3f);
        // 前 0 种coin凑成 0 所需的最少个数为 0
        dp[0] = 0;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] = Math.min(dp[j],
                                 dp[j - coin] + 1);
            }
        }
        return dp[amount] == 0x3f3f3f3f ?
               -1 :
               dp[amount];
    }
    
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        Lc322 lc322 = new Lc322();
        int res = lc322.coinChange(coins,
                                   amount);
        System.out.println("res = " + res);
    }
}
