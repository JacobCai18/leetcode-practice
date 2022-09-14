package com.jacobcai.cc;

import java.util.Arrays;

public class Lc188 {
    public int maxProfit(int k,
                         int[] prices) {
        int len = prices.length;
        // dp[i][j][k]: 第i天状态j买入k次时的最大利润（可推出卖出几次）
        // j=0: 持有现金
        // j=1: 持有股票
        // k=0: 买入0次
        int[][] dp = new int[2][k + 1];
        // 第0天持有股票买入比卖出多1次，买入从0到k次各自的最大利润
        Arrays.fill(dp[1],
                    -prices[0]);
        // dp[0][0]: 第0天持有现金买入0次，卖出0次的最大利润
        // dp[1][0]: 无意义
        for (int i = 1; i < len; i++) {
            for (int ki = 1; ki <= k; ki++) {
                // 持有现金买入和卖出相同次
                dp[0][ki] = Math.max(dp[0][ki],
                                     dp[1][ki] + prices[i]);
                // 持有股票买入比卖出多1次
                dp[1][ki] = Math.max(dp[1][ki],
                                     dp[0][ki - 1] - prices[i]);
            }
        }
        return dp[0][k];
    }
    
    public static void main(String[] args) {
        int k = 2;
        int[] prices = {3, 2, 6, 5, 0, 3};
        Lc188 lc188 = new Lc188();
        int res = lc188.maxProfit(k,
                                  prices);
        System.out.println("res = " + res);
    }
}
