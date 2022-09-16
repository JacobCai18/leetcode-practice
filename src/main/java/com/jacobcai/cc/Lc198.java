package com.jacobcai.cc;

public class Lc198 {
    public int rob(int[] nums) {
        // dp[i][j]: i号房屋，j状态，最高金额
        // j=0:没偷
        // j=1:偷
        int[] dp = new int[2];
        int pre = dp[0];
        dp[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[0] = Math.max(dp[0],
                             dp[1]);
            dp[1] = pre + nums[i];
            pre = dp[0];
        }
        return Math.max(dp[0],
                        dp[1]);
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        Lc198 lc198 = new Lc198();
        int res = lc198.rob(nums);
        System.out.println("res = " + res);
    }
}
