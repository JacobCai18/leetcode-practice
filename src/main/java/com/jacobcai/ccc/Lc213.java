package com.jacobcai.ccc;

public class Lc213 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        } else if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(rob(nums, 0, len - 2), rob(nums, 1, len - 1));
    }
    
    private int rob(int[] nums,
                    int le,
                    int ri) {
        int a = nums[le];
        int b = Math.max(nums[le], nums[le + 1]);
        for (int i = le + 2; i <= ri; i++) {
            int tmp = b;
            b = Math.max(a + nums[i], b);
            a = tmp;
        }
        return b;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        Lc213 lc213 = new Lc213();
        int res = lc213.rob(nums);
        System.out.println("res = " + res);
    }
}
