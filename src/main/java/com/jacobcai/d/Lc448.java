package com.jacobcai.d;

import java.util.ArrayList;
import java.util.List;

public class Lc448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        for (int num : nums) {
            // 还原该位置原来的值
            int x = (num - 1) % len;
            // 用 [1, len] 范围外的数字来表达是否存在
            nums[x] += len;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] <= len) {
                res.add(i + 1);
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        Lc448 lc448 = new Lc448();
        List<Integer> res = lc448.findDisappearedNumbers(nums);
        System.out.println("res = " + res);
    }
}
