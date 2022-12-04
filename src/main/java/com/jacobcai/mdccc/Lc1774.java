package com.jacobcai.mdccc;

import java.util.Arrays;

public class Lc1774 {
    public int closestCost(int[] baseCosts,
                           int[] toppingCosts,
                           int target) {
        int min = Arrays.stream(baseCosts)
                        .min()
                        .getAsInt();
        if (min >= target) {
            return min;
        }
        int upper = 2 * target - min;
        // dp[i]: 能否搭配出总成本 i
        // 没有容量限制的多重背包
        boolean[] dp = new boolean[upper];
        // 1 份基料，0 份配料
        for (int baseCost : baseCosts) {
            if (baseCost < upper) {
                dp[baseCost] = true;
            }
        }
        for (int toppingCost : toppingCosts) {
            for (int j = upper - 1; j >= min; j--) {
                // 1 份基料，1 份配料
                if (dp[j] && (j + toppingCost < upper)) {
                    dp[j + toppingCost] = true;
                }
                // 1 份基料，2 份配料
                if (dp[j] && (j + 2 * toppingCost < upper)) {
                    dp[j + 2 * toppingCost] = true;
                }
            }
        }
        int res = min;
        for (int i = min + 1; i < upper; i++) {
            if (dp[i]) {
                if (Math.abs(i - target) < Math.abs(res - target)) {
                    res = i;
                } else if (Math.abs(i - target) == Math.abs(res - target)) {
                    res = Math.min(res,
                                   i);
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] baseCosts = {1, 7};
        int[] toppingCosts = {3, 4};
        int target = 10;
        Lc1774 lc1774 = new Lc1774();
        int res = lc1774.closestCost(baseCosts,
                                     toppingCosts,
                                     target);
        System.out.println("res = " + res);
    }
}
