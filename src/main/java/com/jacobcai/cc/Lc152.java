package com.jacobcai.cc;

public class Lc152 {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] dpMax = new int[len];
        int[] dpMin = new int[len];
        System.arraycopy(nums,
                         0,
                         dpMax,
                         0,
                         len);
        System.arraycopy(nums,
                         0,
                         dpMin,
                         0,
                         len);
        for (int i = 1; i < len; i++) {
            dpMax[i] = Math.max(dpMax[i - 1] * nums[i],
                                Math.max(nums[i],
                                         dpMin[i - 1] * nums[i]));
            dpMin[i] = Math.min(dpMin[i - 1] * nums[i],
                                Math.min(nums[i],
                                         dpMax[i - 1] * nums[i]));
        }
        int res = dpMax[0];
        for (int i = 1; i < len; ++i) {
            res = Math.max(res,
                           dpMax[i]);
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4, -2};
        Lc152 lc152 = new Lc152();
        int res = lc152.maxProduct(nums);
        System.out.println("res = " + res);
    }
}
