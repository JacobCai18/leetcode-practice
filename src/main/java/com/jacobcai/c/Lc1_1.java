package com.jacobcai.c;

import java.util.Arrays;

public class Lc1_1 {
    public int[] twoSum(int[] nums,
                        int target) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
    
    public static void main(String[] args) {
        Lc1_1 lc1_1 = new Lc1_1();
        int[] nums = {2, 7, 9, 3, 5, 4};
        int target = 6;
        int[] res = lc1_1.twoSum(nums,
                                     target);
        System.out.println(Arrays.toString(res));
    }
    
}
