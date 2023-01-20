package com.jacobcai.dc;

public class Lc581 {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length, max = nums[0], min = nums[n - 1], le = 0, ri = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < max) ri = i; // 从前往后最后一个小于 max 的位置
            else max = nums[i];
            if (nums[n - i - 1] > min) le = n - i - 1; // 从后往前最后一个大于 min 的位置
            else min = nums[n - i - 1];
        }
        return ri - le + 1;
    }

    public static void main(String[] args) {
        Lc581 lc581 = new Lc581();
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        int res = lc581.findUnsortedSubarray(nums);
        System.out.println("res = " + res);
    }
}
