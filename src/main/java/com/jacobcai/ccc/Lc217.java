package com.jacobcai.ccc;

import java.util.HashSet;
import java.util.Set;

public class Lc217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        Lc217 lc217 = new Lc217();
        boolean res = lc217.containsDuplicate(nums);
        System.out.println("res = " + res);
    }
}
