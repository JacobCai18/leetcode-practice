package com.jacobcai.c;

public class Lc53 {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int pre = 0;
        for (int num : nums) {
            pre = pre > 0 ?
                  num + pre :
                  num;
            res = Math.max(res,
                           pre);
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Lc53 lc53 = new Lc53();
        int res = lc53.maxSubArray(nums);
        System.out.println("res = " + res);
    }
}
