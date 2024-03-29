package com.jacobcai.cc;

import java.util.Arrays;

public class Lc179 {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        // 转换成包装类型，以便传入 Comparator 对象（此处为 lambda 表达式）
        Integer[] numsArr = new Integer[n];
        for (int i = 0; i < n; i++) numsArr[i] = nums[i];
        Arrays.sort(numsArr, (x, y) -> {
            long sx = 10, sy = 10;
            while (sx <= x) sx *= 10;
            while (sy <= y) sy *= 10;
            return (int) (-sy * x - y + sx * y + x);
        });
        if (numsArr[0] == 0) return "0";
        StringBuilder res = new StringBuilder();
        for (int num : numsArr) res.append(num);
        return res.toString();
    }

    public static void main(String[] args) {
        Lc179 lc179 = new Lc179();
        int[] nums = {3, 30, 34, 5, 9};
        String res = lc179.largestNumber(nums);
        System.out.println("res = " + res);
    }
}
