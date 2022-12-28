package com.jacobcai.ccc;

public class Lc268 {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return (len * len + len) / 2 - sum;
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        Lc268 lc268 = new Lc268();
        int res = lc268.missingNumber(nums);
        System.out.println("res = " + res);
    }
}
