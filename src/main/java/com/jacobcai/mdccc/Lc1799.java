package com.jacobcai.mdccc;

public class Lc1799 {
    public int maxScore(int[] nums) {
        int len = nums.length;
        int[] dp = new int[1 << len];
        int[][] gcdTmp = new int[len][len];
        for (int i = 0; i < len; ++i) {
            for (int j = i + 1; j < len; ++j) {
                gcdTmp[i][j] = gcd(nums[i], nums[j]);
            }
        }
        int all = 1 << len;
        for (int s = 1; s < all; ++s) {
            int t = Integer.bitCount(s);
            if ((t & 1) != 0) {
                continue;
            }
            for (int i = 0; i < len; ++i) {
                if (((s >> i) & 1) != 0) {
                    for (int j = i + 1; j < len; ++j) {
                        if (((s >> j) & 1) != 0) {
                            dp[s] = Math.max(dp[s], dp[s ^ (1 << i) ^ (1 << j)] + t / 2 * gcdTmp[i][j]);
                        }
                    }
                }
            }
        }
        return dp[all - 1];
    }
    
    public int gcd(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1;
            num1 = num2;
            num2 = temp % num2;
        }
        return num1;
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 4, 6, 8};
        Lc1799 lc1799 = new Lc1799();
        int res = lc1799.maxScore(nums);
        System.out.println("res = " + res);
    }
}
