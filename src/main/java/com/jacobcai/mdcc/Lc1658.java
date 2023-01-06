package com.jacobcai.mdcc;

public class Lc1658 {
    public int minOperations(int[] nums, int x) {
        int len, sum, le, ri, minOpt;
        len = nums.length;
        sum = 0;
        for (int n : nums) sum += n;
        if (sum < x) return -1;
        le = ri = 0;
        minOpt = len + 1;
        while (ri < len) {
            sum -= nums[ri++];
            while (sum < x) sum += nums[le++];
            if (sum == x) minOpt = Math.min(minOpt, le + len - ri);
        }
        return minOpt == len + 1 ? -1 : minOpt;
    }
    
    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1, 1};
        int x = 5;
        Lc1658 lc1658 = new Lc1658();
        int res = lc1658.minOperations(nums, x);
        System.out.println("res = " + res);
    }
}
