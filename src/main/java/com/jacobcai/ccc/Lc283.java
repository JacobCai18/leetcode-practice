package com.jacobcai.ccc;

import java.util.Arrays;

public class Lc283 {
    public void moveZeroes(int[] nums) {
        int le, ri;
        le = ri = 0;
        for (; ri < nums.length; ri++) {
            if (nums[ri] != 0) {
                if (ri > le) {
                    nums[le] = nums[ri];
                    nums[ri] = 0;
                }
                le++;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        Lc283 lc283 = new Lc283();
        lc283.moveZeroes(nums);
        System.out.println("nums = " + Arrays.toString(nums));
    }
}
