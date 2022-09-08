package com.jacobcai.cc;

import java.util.HashMap;
import java.util.Map;

public class Lc137 {
    public int singleNumber(int[] nums) {
        // k:数字，v:出现次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,
                    map.getOrDefault(num,
                                     0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 2};
        Lc137 lc137 = new Lc137();
        int res = lc137.singleNumber(nums);
        System.out.println("res = " + res);
    }
}
