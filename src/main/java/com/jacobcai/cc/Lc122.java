package com.jacobcai.cc;

public class Lc122 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        // dp[i][j]: 第i天状态j时的最大利润
        // j=0：持有现金
        // j=1：持有股票
        int[][] dp = new int[len][2];
        // 第0天持有现金的最大利润（本金为0）
        dp[0][0] = 0;
        // 第0天持有股票的最大利润
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0],
                                dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1],
                                dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }
    
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        Lc122 lc122 = new Lc122();
        int res = lc122.maxProfit(prices);
        System.out.println("res = " + res);
    }
}
