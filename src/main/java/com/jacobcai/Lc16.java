package com.jacobcai;

import java.util.Arrays;

public class Lc16 {
    public int threeSumClosest(int[] nums,
                               int target) {
        int res = 0;
        int gap = Integer.MAX_VALUE;
        int len = nums.length;
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            // 只处理第一个重复出现的数
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 判断当前i下三数和的最小值
            int min = nums[i] + nums[i + 1] + nums[i + 2];
            if (min > target) {
                if (gap > min - target) {
                    res = min;
                }
                break;
            }
            // 判断当前i下三数和的最大值
            int max = nums[i] + nums[len - 2] + nums[len - 1];
            if (max < target) {
                if (gap > target - max) {
                    gap = target - max;
                    res = max;
                }
                continue;
            }
            // j从前往后
            int j = i + 1;
            // k从后往前
            int k = len - 1;
            while (j < k) {
                int curr = nums[i] + nums[j] + nums[k];
                if (curr == target) {
                    return curr;
                } else if (curr < target) {
                    j++;
                } else {
                    k--;
                }
                if (gap > Math.abs(curr - target)) {
                    gap = Math.abs(curr - target);
                    res = curr;
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        Lc16 lc16 = new Lc16();
        int res = lc16.threeSumClosest(nums,
                                       target);
        System.out.println(res);
    }
}
