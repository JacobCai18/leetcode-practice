package com.jacobcai.dccc;

public class Lc714 {
    public int maxProfit(int[] prices,
                         int fee) {
        // dp[i][j]: 第i天状态j的最大利润
        // j=0: 持有现金
        // j=1: 持有股票
        int[] dp = new int[2];
        dp[1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[0] = Math.max(dp[0],
                             dp[1] + prices[i] - fee);
            dp[1] = Math.max(dp[1],
                             dp[0] - prices[i]);
        }
        return dp[0];
    }
    
    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        Lc714 lc714 = new Lc714();
        int res = lc714.maxProfit(prices,
                                  fee);
        System.out.println("res = " + res);
    }
}
