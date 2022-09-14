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
            // 若昨天价格高于今天，则dp[0]仍是昨天的，符合未空间优化时的dp[i-1][0]
            // 若昨天价格低于今天，则dp[0]虽是今天的，但dp[i][0]-prices[i]==dp[1]，不会改变未空间优化时的结果，
            // 相当于昨天买，今天卖了再买，和昨天已持有股票是一样的
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
