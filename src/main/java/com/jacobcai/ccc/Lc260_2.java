package com.jacobcai.ccc;

import java.util.Arrays;

public class Lc260_2 {
    public int[] singleNumber(int[] nums) {
        int xorsum = 0;
        for (int num : nums)
            xorsum ^= num;
        int lsb = (xorsum == Integer.MIN_VALUE ? xorsum : xorsum & (-xorsum)); // 防止溢出
        int type1 = 0, type2 = 0;
        for (int num : nums)
            if ((num & lsb) != 0)
                type1 ^= num;
            else
                type2 ^= num;
        return new int[]{type1, type2};
    }

    public static void main(String[] args) {
        Lc260_2 lc260 = new Lc260_2();
        int[] nums = {1, 2, 1, 3, 2, 5};
        int[] res = lc260.singleNumber(nums);
        System.out.println("res = " + Arrays.toString(res));
    }
}
