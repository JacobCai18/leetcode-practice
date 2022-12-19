package com.jacobcai.ccc;

import java.util.HashMap;
import java.util.Map;

public class Lc219 {
    public boolean containsNearbyDuplicate(int[] nums,
                                           int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num) && i - map.get(num) <= k) {
                return true;
            }
            map.put(num, i);
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        Lc219 lc219 = new Lc219();
        boolean res = lc219.containsNearbyDuplicate(nums,
                                                    k);
        System.out.println("res = " + res);
    }
}
