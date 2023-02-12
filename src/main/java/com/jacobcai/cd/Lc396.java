package com.jacobcai.cd;

import java.util.Arrays;

public class Lc396 {
    public int maxRotateFunction(int[] nums) {
        int f = 0, n = nums.length, numSum = Arrays.stream(nums).sum();
        for (int i = 0; i < n; i++) f += i * nums[i];
        int res = f;
        for (int i = n - 1; i > 0; i--) {
            f += numSum - n * nums[i];
            res = Math.max(res, f);
        }
        return res;
    }

    public static void main(String[] args) {
        Lc396 lc396 = new Lc396();
        int[] nums = {4, 3, 2, 6};
        int res = lc396.maxRotateFunction(nums);
        System.out.println("res = " + res);
    }
}
