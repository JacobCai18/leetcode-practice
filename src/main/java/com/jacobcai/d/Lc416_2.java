package com.jacobcai.d;

public class Lc416_2 {
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
        // dp[i][j]: 前i个数字，数字总和不超过j时的最大总和
        // dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-nums[i]]+nums[i])
        // dp[j] = Math.max(dp[j], dp[j-nums[i]]+nums[i])
        int[] dp = new int[(tar = sum / 2) + 1];
        for (int num : nums) {
            for (int j = tar; j >= 0; j--) {
                // 不选第 i 个数字
                int no = dp[j];
                // 选第 i 个数字
                int yes = j - num >= 0 ?
                          dp[j - num] + num :
                          0;
                dp[j] = Math.max(no,
                                 yes);
            }
        }
        // 如果最大总和等于 tar，说明可以拆分成两个「等和子集」
        return dp[tar] == tar;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        Lc416_2 lc416_2 = new Lc416_2();
        boolean res = lc416_2.canPartition(nums);
        System.out.println("res = " + res);
    }
}
