package com.jacobcai.mc;

import java.util.HashMap;
import java.util.Map;

public class Lc1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            res += num;
        }
        // 节省排序所需时间
        for (int i = -100; i < 0; i++) {
            if (freq.containsKey(i)) {
                int ops = Math.min(k, freq.get(i));
                res += (-i) * ops * 2;
                freq.put(i, freq.get(i) - ops);
                freq.put(-i, freq.getOrDefault(-i, 0) + ops);
                k -= ops;
                if (k == 0) break;
            }
        }
        if (k % 2 == 1 && !freq.containsKey(0)) {
            for (int i = 1; i <= 100; i++) {
                if (freq.containsKey(i)) {
                    res -= i * 2;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Lc1005 lc1005 = new Lc1005();
        int[] nums = {2, -3, -1, 5, -4};
        int res = lc1005.largestSumAfterKNegations(nums, 2);
        System.out.println("res = " + res);
    }
}
