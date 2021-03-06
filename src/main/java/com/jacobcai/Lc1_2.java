package com.jacobcai;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Lc1_2 {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> hashMap = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Lc1_2 twoSumDemo = new Lc1_2();
        int[] nums = {2, 7, 9, 3, 5, 4};
        int target = 6;
        Arrays.stream(twoSumDemo.twoSum(nums, target)).forEach(System.out::println);
    }
}


