package com.jacobcai.c;

public class Lc35 {
    public int searchInsert(int[] nums,
                            int target) {
        int le, ri, mid;
        le = 0;
        ri = nums.length - 1;
        if (target > nums[ri]) {
            return nums.length;
        }
        // [le, mid], (mid, ri]
        while (le < ri) {
            mid = (le + ri) >>> 1;
            if (target <= nums[mid]) {
                ri = mid;
            } else {
                le = mid + 1;
            }
        }
        return le;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        Lc35 lc35 = new Lc35();
        int res = lc35.searchInsert(nums,
                                    target);
        System.out.println("res = " + res);
    }
}
