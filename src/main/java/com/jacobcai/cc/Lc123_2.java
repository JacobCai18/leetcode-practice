package com.jacobcai.cc;

public class Lc123_2 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        // dp[i][j][k]: 第i天状态j买入k+1次时的最大利润（可推出卖出几次）
        // j=0: 持有现金
        // j=1: 持有股票
        // k=-1: 无意义
        int[][] dp = new int[2][2];
        // 第0天持有股票买入1次，卖出0次的最大利润
        dp[1][0] = -prices[0];
        // 第0天持有股票买入2次，卖出1次的最大利润
        dp[1][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            // 持有现金买入1次，卖出1次
            dp[0][0] = Math.max(dp[0][0],
                                dp[1][0] + prices[i]);
            // 持有股票买入1次，卖出0次
            dp[1][0] = Math.max(dp[1][0],
                                -prices[i]);
            // 持有现金买入2次，卖出2次
            dp[0][1] = Math.max(dp[0][1],
                                dp[1][1] + prices[i]);
            // 持有股票买入2次，卖出1次
            dp[1][1] = Math.max(dp[1][1],
                                dp[0][0] - prices[i]);
        }
        return dp[0][1];
    }
    
    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        Lc123_2 lc123_2 = new Lc123_2();
        int res = lc123_2.maxProfit(prices);
        System.out.println("res = " + res);
    }
}
