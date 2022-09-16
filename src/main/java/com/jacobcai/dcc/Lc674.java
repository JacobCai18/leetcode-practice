package com.jacobcai.dcc;

public class Lc674 {
    public int findLengthOfLCIS(int[] nums) {
        int pre, count, max;
        pre = nums[0];
        count = 1;
        max = 1;
        for (int num : nums) {
            if (pre < num) {
                max = Math.max(max,
                               ++count);
            } else {
                count = 1;
            }
            pre = num;
        }
        return max;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};
        Lc674 lc674 = new Lc674();
        int res = lc674.findLengthOfLCIS(nums);
        System.out.println("res = " + res);
    }
}
