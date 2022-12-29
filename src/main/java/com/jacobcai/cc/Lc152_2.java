package com.jacobcai.cc;

public class Lc152_2 {
    public int maxProduct(int[] nums) {
        int maxF, minF, res;
        maxF = minF = res = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i],
                            Math.max(nums[i],
                                     mn * nums[i]));
            minF = Math.min(mn * nums[i],
                            Math.min(nums[i],
                                     mx * nums[i]));
            res = Math.max(maxF,
                           res);
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4, -2};
        Lc152_2 lc152_2 = new Lc152_2();
        int res = lc152_2.maxProduct(nums);
        System.out.println("res = " + res);
    }
}
