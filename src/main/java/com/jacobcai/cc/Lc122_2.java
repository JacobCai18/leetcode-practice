package com.jacobcai.cc;

public class Lc122_2 {
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            // 今天价格比昨天高，昨天就买并今天卖出
            // 今天价格比昨天低，昨天就不买
            res += Math.max(prices[i] - prices[i - 1],
                            0);
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        Lc122_2 lc122_2 = new Lc122_2();
        int res = lc122_2.maxProfit(prices);
        System.out.println("res = " + res);
    }
}
