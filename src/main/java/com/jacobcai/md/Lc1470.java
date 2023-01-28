package com.jacobcai.md;

import java.util.Arrays;

public class Lc1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        for (int i = 0; i < n; i++) {
            res[2 * i] = nums[i];
            res[2 * i + 1] = nums[n + i];
        }
        return res;
    }

    public static void main(String[] args) {
        Lc1470 lc1470 = new Lc1470();
        int[] nums = {2, 5, 1, 3, 4, 7};
        int[] res = lc1470.shuffle(nums, 3);
        System.out.println("res = " + Arrays.toString(res));
    }
}
