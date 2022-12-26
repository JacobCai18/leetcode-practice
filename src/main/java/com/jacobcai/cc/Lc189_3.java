package com.jacobcai.cc;

import java.util.Arrays;

public class Lc189_3 {
    public void rotate(int[] nums,
                       int k) {
        int len = nums.length;
        k %= len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }
    
    private void reverse(int[] nums,
                         int le,
                         int ri) {
        while (le < ri) {
            int tmp = nums[le];
            nums[le++] = nums[ri];
            nums[ri--] = tmp;
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 2;
        Lc189_3 lc189_3 = new Lc189_3();
        lc189_3.rotate(nums,
                       k);
        System.out.println("nums = " + Arrays.toString(nums));
    }
}
