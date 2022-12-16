package com.jacobcai.mdccc;

import java.util.Arrays;

public class Lc1785 {
    public int minElements(int[] nums,
                           int limit,
                           int goal) {
        // 防止溢出
        long sum = Arrays.stream(nums)
                         .mapToLong(num -> (long) num)
                         .sum();
        long gap = Math.abs(goal - sum);
        // 类型转换优先级高于加减乘除
        return (int) ((gap + limit - 1) / limit);
    }
    
    public static void main(String[] args) {
        int[] nums = {1, -10, 9, 1};
        int limit = 100;
        int goal = 0;
        Lc1785 lc1785 = new Lc1785();
        int res = lc1785.minElements(nums,
                                     limit,
                                     goal);
        System.out.println("res = " + res);
    }
}
