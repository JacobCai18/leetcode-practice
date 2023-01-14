package com.jacobcai.mc;

import java.util.Arrays;

public class Lc1005_2 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0, minNatural = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < 0 && k > 0) {
                num = -num;
                k--;
            }
            minNatural = Math.min(minNatural, num);
            sum += num;
        }
        return sum - ((k & 1) == 1 ? 2 * minNatural : 0);
    }

    public static void main(String[] args) {
        Lc1005_2 lc1005_2 = new Lc1005_2();
        int[] nums = {2, -3, -1, 5, -4};
        int res = lc1005_2.largestSumAfterKNegations(nums, 2);
        System.out.println("res = " + res);
    }
}
