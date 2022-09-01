package com.jacobcai;

public class Lc55 {
    public boolean canJump(int[] nums) {
        int riMost, len;
        riMost = 0;
        for (int i = 0; i < (len = nums.length); i++) {
            if (i <= riMost) {
                riMost = Math.max(riMost, i + nums[i]);
                if (riMost >= len - 1) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        Lc55 lc55 = new Lc55();
        boolean res = lc55.canJump(nums);
        System.out.println("res = " + res);
    }
}
