package com.jacobcai.c;

import java.util.Arrays;

public class Lc16 {
    private int target, res, gap;
    
    public int threeSumClosest(int[] nums,
                               int target) {
        res = 0;
        gap = Integer.MAX_VALUE;
        this.target = target;
        int len = nums.length;
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            // 只处理第一个重复出现的数
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int min, max;
            // 判断当前i下三数和的最小值
            if ((min = nums[i] + nums[i + 1] + nums[i + 2]) > target) {
                checkGap(min);
                break;
            }
            // 判断当前i下三数和的最大值
            if ((max = nums[i] + nums[len - 2] + nums[len - 1]) < target) {
                checkGap(max);
                continue;
            }
            // j从前往后
            int j = i + 1;
            // k从后往前
            int k = len - 1;
            while (j < k) {
                int currSum;
                if ((currSum = nums[i] + nums[j] + nums[k]) == target) {
                    return currSum;
                } else if (currSum < target) {
                    j++;
                } else {
                    k--;
                }
                checkGap(currSum);
            }
        }
        return res;
    }
    
    private void checkGap(int currSum) {
        int currGap;
        if (gap > (currGap = Math.abs(currSum - target))) {
            gap = currGap;
            res = currSum;
        }
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
