package com.jacobcai.ccc;

import java.util.HashSet;
import java.util.Set;

public class Lc219_2 {
    public boolean containsNearbyDuplicate(int[] nums,
                                           int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        Lc219_2 lc219_2 = new Lc219_2();
        boolean res = lc219_2.containsNearbyDuplicate(nums,
                                                      k);
        System.out.println("res = " + res);
    }
}
