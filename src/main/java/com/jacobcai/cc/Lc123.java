package com.jacobcai.cc;

public class Lc123 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        // dp[i][j][k]: 第i天状态j买入k次时的最大利润（可推出卖出几次）
        // j=0: 持有现金
        // j=1: 持有股票
        // k=0: 无意义
        int[][][] dp = new int[len][2][3];
        // 第0天持有股票买入1次，卖出0次的最大利润
        dp[0][1][1] = -prices[0];
        // 第0天持有股票买入2次，卖出1次的最大利润
        dp[0][1][2] = -prices[0];
        for (int i = 1; i < len; i++) {
            // 持有现金买入1次，卖出1次
            dp[i][0][1] = Math.max(dp[i - 1][0][1],
                                   dp[i - 1][1][1] + prices[i]);
            // 持有股票买入1次，卖出0次
            dp[i][1][1] = Math.max(dp[i - 1][1][1],
                                   -prices[i]);
            // 持有现金买入2次，卖出2次
            dp[i][0][2] = Math.max(dp[i - 1][0][2],
                                   dp[i - 1][1][2] + prices[i]);
            // 持有股票买入2次，卖出1次
            dp[i][1][2] = Math.max(dp[i - 1][1][2],
                                   dp[i - 1][0][1] - prices[i]);
        }
        return dp[len - 1][0][2];
    }
    
    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        Lc123 lc123 = new Lc123();
        int res = lc123.maxProfit(prices);
        System.out.println("res = " + res);
    }
}
