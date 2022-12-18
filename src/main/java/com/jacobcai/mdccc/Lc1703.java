package com.jacobcai.mdccc;

public class Lc1703 {
    public int minMoves(int[] nums,
                        int k) {
        int n = nums.length, m = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] != 0) {
                nums[m] = i - m;
                ++m;
            }
        }
        if (m == n) {
            return 0; // 全部都是 1
        }
        int[] p = nums;
        int sl = 0, sm = 0, sr = 0; // s[i] s[i+k/2] s[i+k]
        for (int i = 0; i < k; ++i) {
            if (i < k / 2) {
                sm += p[i];
            }
            sr += p[i];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= m - k; ++i) {
            ans = Math.min(ans,
                           sl + sr - sm * 2 - p[i + k / 2] * (k % 2));
            sl += p[i];
            sm += p[i + k / 2];
            sr += p[i + k];
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 0, 0, 1, 0, 1};
        int k = 2;
        Lc1703 lc1703 = new Lc1703();
        int res = lc1703.minMoves(nums,
                                  k);
        System.out.println("res = " + res);
    }
}
