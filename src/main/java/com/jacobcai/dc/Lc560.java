package com.jacobcai.dc;

import java.util.HashMap;
import java.util.Map;

public class Lc560 {
    public int subarraySum(int[] nums,
                           int k) {
        int cnt = 0, pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,
               1);
        for (int num : nums) {
            pre += num;
            if (map.containsKey(pre - k)) {
                cnt += map.get(pre - k);
            }
            map.put(pre,
                   map.getOrDefault(pre,
                                   0) + 1);
        }
        return cnt;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, -2, 3, 3};
        int k = 3;
        Lc560 lc560 = new Lc560();
        int res = lc560.subarraySum(nums,
                                    k);
        System.out.println("res = " + res);
    }
}
