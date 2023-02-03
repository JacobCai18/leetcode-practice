package com.jacobcai.cc;

import java.util.Arrays;

public class Lc164 {
    public int maximumGap(int[] nums) {
        int n = nums.length, exp = 1, maxVal = Arrays.stream(nums).max().getAsInt();
        int[] tmp = new int[n];
        while (exp <= maxVal) {
            int[] cnt = new int[10];
            for (var x : nums) {
                int d = x / exp % 10;
                cnt[d]++;
            }
            for (int i = 1; i < 10; i++)
                cnt[i] += cnt[i - 1]; // 当前数位为 0 - i 一共有多少个数
            for (int i = n - 1; i > -1; i--) { // 从大到小遍历
                int x = nums[i], d = x / exp % 10;
                tmp[--cnt[d]] = x; // 根据相应下标填到中间排序缓存中
            }
            System.arraycopy(tmp, 0, nums, 0, n);
            exp *= 10;
        }
        int res = 0, pre = nums[0];
        for (var x : nums) {
            res = Math.max(res, x - pre);
            pre = x;
        }
        return res;
    }

    public static void main(String[] args) {
        Lc164 lc164 = new Lc164();
        int[] nums = {3, 6, 9, 1, 12, 19, 16};
        int res = lc164.maximumGap(nums);
        System.out.println("res = " + res);
    }
}
