package com.jacobcai.cc;

public class Lc153 {
    public int findMin(int[] nums) {
        int le, ri;
        le = 0;
        ri = nums.length - 1;
        while (le < ri) {
            int mid = (le + ri) >>> 1;
            if (nums[mid] < nums[ri]) {
                ri = mid;
            } else {
                le = mid + 1;
            }
        }
        return nums[le];
    }
    
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        Lc153 lc153 = new Lc153();
        int res = lc153.findMin(nums);
        System.out.println("res = " + res);
    }
}
