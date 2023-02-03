package com.jacobcai.cc;

import java.util.Arrays;

public class Lc164_2 {
    private static class Bucket {
        int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;
        boolean used = false;
    }

    public int maximumGap(int[] nums) {
        int n = nums.length, maxVal, minVal, d, m;
        if (n < 2) return 0;
        maxVal = Arrays.stream(nums).max().getAsInt();
        minVal = Arrays.stream(nums).min().getAsInt();
        d = Math.max(1, (maxVal - minVal) / (n - 1));
        m = (maxVal - minVal) / d + 1;
        Bucket[] buckets = new Bucket[m];
        for (int i = 0; i < m; i++) buckets[i] = new Bucket();
        for (var x : nums) {
            int i = (x - minVal) / d;
            buckets[i].used = true;
            buckets[i].minVal = Math.min(buckets[i].minVal, x);
            buckets[i].maxVal = Math.max(buckets[i].maxVal, x);
        }
        int res = 0, pre = minVal;
        for (var b : buckets) {
            if (!b.used) continue;
            res = Math.max(res, b.minVal - pre);
            pre = b.maxVal;
        }
        return res;
    }

    public static void main(String[] args) {
        Lc164_2 lc164 = new Lc164_2();
        int[] nums = {3, 6, 9, 1, 12, 19, 16};
        int res = lc164.maximumGap(nums);
        System.out.println("res = " + res);
    }
}
