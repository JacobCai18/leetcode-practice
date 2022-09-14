package com.jacobcai.dccc;

public class Lc714_2 {
    public int maxProfit(int[] prices,
                         int fee) {
        // 手续费在买入时计算
        int buy = prices[0] + fee;
        int profit = 0;
        for (int i = 1; i < prices.length; ++i) {
            int curBuy, curProfit;
            if ((curBuy = prices[i] + fee) < buy) {
                buy = curBuy;
                continue;
            }
            if ((curProfit = prices[i] - buy) > 0) {
                profit += curProfit;
                buy = prices[i];
            }
        }
        return profit;
    }
    
    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        Lc714_2 lc714_2 = new Lc714_2();
        int res = lc714_2.maxProfit(prices,
                                    fee);
        System.out.println("res = " + res);
    }
}
