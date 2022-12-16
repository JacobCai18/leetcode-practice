package com.jacobcai.mdccc;

public class Lc1785_2 {
    public int minElements(int[] nums,
                           int limit,
                           int goal) {
        // 防止溢出
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        long gap = Math.abs(goal - sum);
        // 类型转换优先级高于加减乘除
        return (int) ((gap + limit - 1) / limit);
    }
    
    public static void main(String[] args) {
        int[] nums = {1, -10, 9, 1};
        int limit = 100;
        int goal = 0;
        Lc1785_2 lc1785_2 = new Lc1785_2();
        int res = lc1785_2.minElements(nums,
                                       limit,
                                       goal);
        System.out.println("res = " + res);
    }
}
