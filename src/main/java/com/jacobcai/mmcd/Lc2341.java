package com.jacobcai.mmcd;

import java.util.Arrays;

public class Lc2341 {
    public int[] numberOfPairs(int[] nums) {
        int[] cnt = new int[101];
        int[] res = new int[2];
        for (var x : nums)
            cnt[x]++;
        for (var x : cnt) {
            res[0] += x / 2;
            res[1] += x % 2;
        }
        return res;
    }

    public static void main(String[] args) {
        Lc2341 lc2341 = new Lc2341();
        int[] nums = {1, 3, 2, 1, 3, 2, 2};
        int[] res = lc2341.numberOfPairs(nums);
        System.out.println("res = " + Arrays.toString(res));
    }
}
