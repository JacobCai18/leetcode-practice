package com.jacobcai.ccc;

import java.util.Arrays;

public class Lc238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        res[0] = 1;
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int ri = 1;
        for (int i = len - 1; i >= 0; i--) {
            res[i] *= ri;
            ri *= nums[i];
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Lc238 lc238 = new Lc238();
        int[] res = lc238.productExceptSelf(nums);
        System.out.println("res = " + Arrays.toString(res));
    }
}
