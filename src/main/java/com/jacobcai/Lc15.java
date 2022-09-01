package com.jacobcai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 3) {
            return res;
        }
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            // 只处理第一个重复出现的数
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 最小值大于0，跳出
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0) {
                break;
            }
            // 最大值小于0，继续
            if (nums[i] + nums[len - 2] + nums[len - 1] < 0) {
                continue;
            }
            // j从前往后
            int j = i + 1;
            // k从后往前
            int k = len - 1;
            while (j < k) {
                int currSum;
                if ((currSum = nums[i] + nums[j] + nums[k]) == 0) {
                    res.add(Arrays.asList(nums[i],
                                          nums[j],
                                          nums[k]));
                    // 去到下一个不重复的j
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    j++;
                    // 去到下一个不重复的k
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    k--;
                } else if (currSum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Lc15 lc15 = new Lc15();
        List<List<Integer>> res = lc15.threeSum(nums);
        System.out.println(res);
    }
}
