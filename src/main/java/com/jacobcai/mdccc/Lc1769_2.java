package com.jacobcai.mdccc;

import java.util.Arrays;

public class Lc1769_2 {
    public int[] minOperations(String boxes) {
        // le: [0, i] 上 '1' 的个数
        // ri: (i, len - 1] 上 '1' 的个数
        int len, le, ri;
        // dp[i]: 所有小球移动到 i 的最小操作数
        int[] dp;
        len = boxes.length();
        le = boxes.charAt(0) - '0';
        ri = 0;
        dp = new int[len];
        // 计算 i = 0 位置上右边的 '1' 的个数，以及所有 '1' 移动到 i = 0 的最小操作数
        for (int i = 1; i < len; i++) {
            if (boxes.charAt(i) == '1') {
                ri++;
                dp[0] += i;
            }
        }
        for (int i = 1; i < len; i++) {
            // 根据上一个位置左边的 '1' 的个数和右边的 '1' 的个数计算所有小球移动到当前位置的操作数
            dp[i] = dp[i - 1] + le - ri;
            // 更新当前位置左边的 '1' 的个数和右边的 '1' 的个数
            if (boxes.charAt(i) == '1') {
                le++;
                ri--;
            }
        }
        return dp;
    }
    
    public static void main(String[] args) {
        String boxes = "001011";
        Lc1769_2 lc1769_2 = new Lc1769_2();
        int[] res = lc1769_2.minOperations(boxes);
        System.out.println("res = " + Arrays.toString(res));
    }
}
