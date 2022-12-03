package com.jacobcai.mdccc;

import java.util.Arrays;

public class Lc1769_2 {
    public int[] minOperations(String boxes) {
        // le: [0, i] 上 '1' 的个数
        // ri: (i, len - 1] 上 '1' 的个数
        // count: 所有小球移动到 i 的最小操作数
        int len, le, ri, count;
        int[] res;
        len = boxes.length();
        le = boxes.charAt(0) - '0';
        ri = 0;
        count = 0;
        // 计算 i = 0 位置上右边的 '1' 的个数，以及所有 '1' 移动到 i = 0 的操作数
        for (int i = 1; i < len; i++) {
            if (boxes.charAt(i) == '1') {
                ri++;
                count += i;
            }
        }
        res = new int[len];
        res[0] = count;
        for (int i = 1; i < len; i++) {
            // 根据上一个位置左边的 '1' 的个数和右边的 '1' 的个数计算所有小球移动到当前位置的操作数
            count = count + le - ri;
            res[i] = count;
            // 更新当前位置左边的 '1' 的个数和右边的 '1' 的个数
            if (boxes.charAt(i) == '1') {
                le++;
                ri--;
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        String boxes = "001011";
        Lc1769_2 lc1769_2 = new Lc1769_2();
        int[] res = lc1769_2.minOperations(boxes);
        System.out.println("res = " + Arrays.toString(res));
    }
}
