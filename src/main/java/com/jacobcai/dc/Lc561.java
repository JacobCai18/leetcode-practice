package com.jacobcai.dc;

import java.util.Arrays;

public class Lc561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i += 2) ans += nums[i];
        return ans;
    }

    public static void main(String[] args) {
        Lc561 lc561 = new Lc561();
        int[] nums = {1, 4, 3, 2};
        int res = lc561.arrayPairSum(nums);
        System.out.println("res = " + res);
    }
}
