package com.jacobcai.mdcccc;

import java.util.HashMap;
import java.util.Map;

public class Lc1814 { // 8m
    public int countNicePairs(int[] nums) {
        final int MOD = (int) 1e9 + 7;
        long res = 0;
        // <nums[i] - rev(nums[i]), cnt>
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int tmp = num, rev = 0;
            while (tmp > 0) {
                rev = rev * 10 + tmp % 10;
                tmp /= 10;
            }
            int cnt = map.getOrDefault(num - rev, 0);
            res += cnt;
            map.put(num - rev, cnt + 1);
        }
        return (int) (res % MOD);
    }

    public static void main(String[] args) {
        int[] nums = {13, 10, 35, 24, 76};
        Lc1814 lc1814 = new Lc1814();
        int res = lc1814.countNicePairs(nums);
        System.out.println("res = " + res);
    }
}
