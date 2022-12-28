package com.jacobcai.mmc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc2032 {
    public List<Integer> twoOutOfThree(int[] nums1,
                                       int[] nums2,
                                       int[] nums3) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums1) {
            map.put(n, 1);
        }
        for (int n : nums2) {
            map.put(n, map.getOrDefault(n, 0) | 2);
        }
        for (int n : nums3) {
            map.put(n, map.getOrDefault(n, 0) | 4);
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int k = e.getKey(), v = e.getValue();
            // 将最小一个 1 变为 0
            if ((v & (v - 1)) != 0) {
                res.add(k);
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 3, 2};
        int[] nums2 = {2, 3};
        int[] nums3 = {3};
        Lc2032 lc2032 = new Lc2032();
        List<Integer> res = lc2032.twoOutOfThree(nums1,
                                                 nums2,
                                                 nums3);
        System.out.println("res = " + res);
    }
}
