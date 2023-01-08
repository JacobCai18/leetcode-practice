package com.jacobcai.d;

public class Lc413_2 {
    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        if (len == 1) return 0;
        // d: 差, t: 等差数列增量, res: 等差数组子数组个数
        int d, t, res;
        d = nums[0] - nums[1];
        t = 0;
        res = 0;
        // 因为等差数列的长度至少为 3，所以可以从 i = 2 开始枚举
        for (int i = 2; i < len; ++i) {
            if (nums[i - 1] - nums[i] == d) {
                t++;
            } else {
                d = nums[i - 1] - nums[i];
                t = 0;
            }
            res += t;
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Lc413_2 lc413_2 = new Lc413_2();
        int res = lc413_2.numberOfArithmeticSlices(nums);
        System.out.println("res = " + res);
    }
}
