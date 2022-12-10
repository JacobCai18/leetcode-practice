package com.jacobcai.mdcccc;

public class Lc1827 {
    public int minOperations(int[] nums) {
        int pre = nums[0] - 1;
        int cnt = 0;
        for (int num : nums) {
            pre = Math.max(pre + 1,
                           num);
            cnt += pre - num;
        }
        return cnt;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 5, 2, 4, 1};
        Lc1827 lc1827 = new Lc1827();
        int res = lc1827.minOperations(nums);
        System.out.println("res = " + res);
    }
}
