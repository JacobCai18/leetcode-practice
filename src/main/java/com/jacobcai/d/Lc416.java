package com.jacobcai.d;

public class Lc416 {
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
        // dp[i][j]: 前i+1个数字，数字总和不超过j时的最大总和
        // dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-nums[i]]+nums[i])
        int[][] dp = new int[len = nums.length][(tar = sum / 2) + 1];
        // 先处理考虑第 1 个数字的情况
        for (int j = 0; j <= tar; j++) {
            dp[0][j] = j - nums[0] >= 0 ?
                       nums[0] :
                       0;
        }
        // 再处理考虑其余数字的情况
        for (int i = 1; i < len; i++) {
            int num = nums[i];
            for (int j = 0; j <= tar; j++) {
                // 不选第 i 个数字
                int no = dp[i - 1][j];
                // 选第 i 个数字
                int yes = j - num >= 0 ?
                          dp[i - 1][j - num] + num :
                          0;
                dp[i][j] = Math.max(no,
                                    yes);
            }
        }
        // 如果最大总和等于 tar，说明可以拆分成两个「等和子集」
        return dp[len - 1][tar] == tar;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        Lc416 lc416 = new Lc416();
        boolean res = lc416.canPartition(nums);
        System.out.println("res = " + res);
    }
}
