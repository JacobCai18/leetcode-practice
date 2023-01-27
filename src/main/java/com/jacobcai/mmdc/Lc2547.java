package com.jacobcai.mmdc;

import java.util.Arrays;

public class Lc2547 {
    public int minCost(int[] nums, int k) {
        // trimmed(subarray).length = subarray.length - occ[1]
        // importance value = k + trimmed(subarray).length
        int n = nums.length;
        var dp = new int[n + 1]; // dp[ri + 1] = min(dp[ri + 1], dp[le] + importance(le, ri))
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int ri = 0; ri < n; ri++) {
            var cnt = new int[n]; // <num, cnt>
            var occ = new int[n]; // <cnt, occ>
            for (int le = ri; le > -1; le--) {
                occ[cnt[nums[le]]]--;
                occ[++cnt[nums[le]]]++;
                dp[ri + 1] = Math.min(dp[ri + 1], dp[le] + k + ri - le + 1 - occ[1]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Lc2547 lc2547 = new Lc2547();
        int[] nums = {1, 2, 1, 2, 1, 3, 3};
        int res = lc2547.minCost(nums, 2);
        System.out.println("res = " + res);
    }
}
