package com.jacobcai.m;

import java.util.Arrays;

public class Lc905 {
    public int[] sortArrayByParity(int[] nums) {
        int le, ri;
        le = 0;
        ri = nums.length - 1;
        while (le < ri) {
            while (le < ri && (nums[le] & 1) == 0) le++;
            while (le < ri && (nums[ri] & 1) == 1) ri--;
            int tmp = nums[le];
            nums[le++] = nums[ri];
            nums[ri--] = tmp;
        }
        return nums;
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 1, 1, 1, 4};
        Lc905 lc905 = new Lc905();
        int[] res = lc905.sortArrayByParity(nums);
        System.out.println("res = " + Arrays.toString(res));
    }
}
