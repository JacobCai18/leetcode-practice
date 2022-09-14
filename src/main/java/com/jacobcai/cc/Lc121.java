package com.jacobcai.cc;

public class Lc121 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            // 价格最低时买入
            minPrice = Math.min(minPrice,
                                price);
            // 今天卖出的利润，维护最大利润
            maxProfit = Math.max(maxProfit,
                                 price - minPrice);
        }
        return maxProfit;
    }
    
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        Lc121 lc121 = new Lc121();
        int res = lc121.maxProfit(prices);
        System.out.println("res = " + res);
    }
}
