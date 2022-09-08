package com.jacobcai.d;

public class Lc416_3 {
    public boolean canPartition(int[] nums) {
        // tar: 「等和子集」的和
        int len, sum, tar;
        sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // sum为奇数时nums不能被分为两个「等和子集」
        if ((sum & 1) == 1) {
            return false;
        }
        // dp[i][j]: 前i个数字，能选出数字组合使数字总和恰好为j
        // dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]]
        boolean[][] dp = new boolean[(len = nums.length) + 1][(tar = sum / 2) + 1];
        // 前0个数字能选出数字组合使数字总和恰好为0
        dp[0][0] = true;
        for (int i = 1; i <= len; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= tar; j++) {
                dp[i][j] = dp[i - 1][j] || (j - num >= 0 && dp[i - 1][j - num]);
            }
        }
        return dp[len][tar];
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        Lc416_3 lc416_3 = new Lc416_3();
        boolean res = lc416_3.canPartition(nums);
        System.out.println("res = " + res);
    }
}
