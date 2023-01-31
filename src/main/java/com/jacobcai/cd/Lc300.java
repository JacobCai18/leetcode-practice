package com.jacobcai.cd;

public class Lc300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, mx = 1;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int j = 1; j < n; j++) {
            dp[j] = 1;
            for (int i = 0; i < j; i++)
                if (nums[i] < nums[j])
                    dp[j] = Math.max(dp[j], dp[i] + 1);
            mx = Math.max(mx, dp[j]);
        }
        return mx;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        Lc300 lc300 = new Lc300();
        int res = lc300.lengthOfLIS(nums);
        System.out.println("res = " + res);
    }
}
