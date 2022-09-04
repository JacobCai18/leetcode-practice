package com.jacobcai.c;

import java.util.Arrays;

public class Lc75 {
    public void sortColors(int[] nums) {
        int le, ri, i;
        le = i = 0;
        ri = nums.length;
        // [0, le) == 0
        // [le, i) == 1
        // [i, ri)
        // [ri, nums.length - 1] == 2
        while (i < ri) {
            if (nums[i] == 0) {
                swap(nums,
                     i++,
                     le++);
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums,
                     i,
                     --ri);
            }
        }
    }
    
    private void swap(int[] nums,
                      int i,
                      int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        Lc75 lc75 = new Lc75();
        lc75.sortColors(nums);
        System.out.println("nums = " + Arrays.toString(nums));
    }
}
