package com.jacobcai.d;

public class Lc494_2 {
    public int findTargetSumWays(int[] nums,
                                 int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || (diff & 1) != 0) {
            return 0;
        }
        int len = nums.length, neg = diff / 2;
        // dp[i][j]: 从前 i 个数字中选取元素，能使元素之和等于 j 的方案数
        int[][] dp = new int[len + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= len; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= neg; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= num) {
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }
        return dp[len][neg];
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        Lc494_2 lc494 = new Lc494_2();
        int res = lc494.findTargetSumWays(nums,
                                          target);
        System.out.println("res = " + res);
    }
}
