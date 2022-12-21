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
        int[] dp = new int[neg + 1];
        dp[0] = 1;
        for (int i = 1; i <= len; i++) {
            int num = nums[i - 1];
            for (int j = neg; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[neg];
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
