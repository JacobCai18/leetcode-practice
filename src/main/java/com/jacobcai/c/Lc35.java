package com.jacobcai.c;

public class Lc35 {
    public int searchInsert(int[] nums,
                            int target) {
        int le, ri;
        le = 0;
        ri = nums.length - 1;
        // [le, mid), mid, (mid, ri]
        while (le <= ri) {
            int mid = (le + ri) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                le = mid + 1;
            } else {
                ri = mid - 1;
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
