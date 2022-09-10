package com.jacobcai.cd;

public class Lc377 {
    public int combinationSum4(int[] nums,
                               int target) {
        // dp[i][j]: 前i种num凑成j的排列数
        // 组合中的最后一个num可以是nums中任意数值，固定背包大小，循环物品
        // dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[k]] (k in [0,len])
        // dp[j] = dp[j] + dp[j-nums[k]] (k in [0,len])
        int[] dp = new int[target + 1];
        // 前0种num凑成j的排列数为1
        dp[0] = 1;
        for (int j = 1; j <= target; j++) {
            for (int num : nums) {
                if (j - num >= 0) {
                    dp[j] += dp[j - num];
                }
            }
        }
        return dp[target];
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 5};
        int target = 5;
        Lc377 lc377 = new Lc377();
        int res = lc377.combinationSum4(nums,
                                        target);
        System.out.println("res = " + res);
    }
}
