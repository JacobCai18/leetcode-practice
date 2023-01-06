package com.jacobcai.mdcc;

import java.util.HashMap;
import java.util.Map;

public class Lc1658_2 {
    public int minOperations(int[] nums, int x) {
        int len = nums.length;
        // <sufSum, opt>
        Map<Integer, Integer> suf = new HashMap<>(len);
        suf.put(0, 0);
        int sufSum = 0;
        for (int i = len - 1; i >= 0; i--) {
            sufSum += nums[i];
            suf.put(sufSum, len - i);
        }
        int preSum = 0;
        int minOpt = len + 1;
        for (int i = 0; i < len; i++) {
            if (suf.containsKey(x - preSum)) minOpt = Math.min(minOpt, i + suf.get(x - preSum));
            preSum += nums[i];
        }
        return minOpt == len + 1 ? -1 : minOpt;
    }
    
    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1, 1};
        int x = 5;
        Lc1658_2 lc1658_2 = new Lc1658_2();
        int res = lc1658_2.minOperations(nums,
                                         x);
        System.out.println("res = " + res);
    }
}
