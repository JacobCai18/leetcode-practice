package com.jacobcai.mcd;

import java.util.Arrays;

public class Lc1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] buckets = new int[101];
        int[] sums = new int[102];
        int[] res = new int[nums.length];
        for (int num : nums)
            buckets[num]++;
        for (int i = 1; i < 102; i++)
            sums[i] = sums[i - 1] + buckets[i - 1];
        for (int i = 0; i < nums.length; i++)
            res[i] = sums[nums[i]];
        return res;
    }

    public static void main(String[] args) {
        Lc1365 lc1365 = new Lc1365();
        int[] nums = {8, 1, 2, 2, 3};
        int[] res = lc1365.smallerNumbersThanCurrent(nums);
        System.out.println("res = " + Arrays.toString(res));
    }
}
