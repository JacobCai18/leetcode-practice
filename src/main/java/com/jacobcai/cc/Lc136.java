package com.jacobcai.cc;

public class Lc136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        Lc136 lc136 = new Lc136();
        int res = lc136.singleNumber(nums);
        System.out.println("res = " + res);
    }
}
