package com.jacobcai.md;

import java.util.Arrays;

public class Lc1480 {
    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] + nums[i];
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Lc1480 lc1480 = new Lc1480();
        int[] res = lc1480.runningSum(nums);
        System.out.println("res = " + Arrays.toString(res));
    }
}
