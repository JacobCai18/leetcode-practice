package com.jacobcai.cd;

public class Lc309 {
    public int maxProfit(int[] prices) {
        // dp[i][j]: 第i天状态j时的最大利润
        // j=0: 持有现金，今天未卖出股票
        // j=1: 持有股票，昨天未卖出股票时今天才能买入股票
        // j=2: 持有现金，今天卖出股票
        int[] dp = new int[3];
        dp[1] = -prices[0];
        // 昨天的dp[0]会被今天的dp[0]覆盖
        int pre = dp[0];
        for (int i = 1; i < prices.length; i++) {
            dp[0] = Math.max(dp[0],
                             dp[2]);
            dp[2] = dp[1] + prices[i];
            dp[1] = Math.max(dp[1],
                             pre - prices[i]);
            pre = dp[0];
        }
        return Math.max(dp[0],
                        dp[2]);
    }
    
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        Lc309 lc309 = new Lc309();
        int res = lc309.maxProfit(prices);
        System.out.println("res = " + res);
    }
}
