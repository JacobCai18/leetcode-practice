package com.jacobcai.cd;

import java.util.*;

public class Lc350 {
    public int[] intersect(int[] nums1,
                           int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2,
                             nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            int cnt = map.getOrDefault(num, 0) + 1;
            map.put(num, cnt);
        }
        List<Integer> resList = new ArrayList<>();
        for (int num : nums2) {
            int cnt = map.getOrDefault(num, 0);
            if (cnt > 0) {
                resList.add(num);
                cnt--;
                if (cnt > 0) {
                    map.put(num, cnt);
                } else {
                    map.remove(num);
                }
            }
        }
        int[] res = new int[resList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = resList.get(i);
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        Lc350 lc350 = new Lc350();
        int[] res = lc350.intersect(nums1,
                                    nums2);
        System.out.println("res = " + Arrays.toString(res));
    }
}
