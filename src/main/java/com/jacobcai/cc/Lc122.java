package com.jacobcai.cc;

public class Lc122 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        // dp[i][j]: 第i天状态j时的最大利润
        // j=0：持有现金
        // j=1：持有股票
        int[] dp = new int[2];
        // 第0天持有现金的最大利润（本金为0）
        // 第0天持有股票的最大利润
        dp[1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[0] = Math.max(dp[0],
                             dp[1] + prices[i]);
            dp[1] = Math.max(dp[1],
                             dp[0] - prices[i]);
        }
        return dp[0];
    }
    
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        Lc122 lc122 = new Lc122();
        int res = lc122.maxProfit(prices);
        System.out.println("res = " + res);
    }
}
