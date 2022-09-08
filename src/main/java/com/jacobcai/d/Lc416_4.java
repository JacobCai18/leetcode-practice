package com.jacobcai.d;

public class Lc416_4 {
    public boolean canPartition(int[] nums) {
        // tar: 「等和子集」的和
        int sum, tar;
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
        // dp[j] = dp[j] || dp[j-nums[i]]
        boolean[] dp = new boolean[(tar = sum / 2) + 1];
        // 前0个数字能选出数字组合使数字总和恰好为0
        dp[0] = true;
        for (int i = 1; i <= nums.length; i++) {
            int num = nums[i - 1];
            for (int j = tar; j >= 0; j--) {
                dp[j] = dp[j] || (j - num >= 0 && dp[j - num]);
                if (dp[tar]) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        Lc416_4 lc416_4 = new Lc416_4();
        boolean res = lc416_4.canPartition(nums);
        System.out.println("res = " + res);
    }
}
