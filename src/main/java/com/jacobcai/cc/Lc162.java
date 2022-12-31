package com.jacobcai.cc;

public class Lc162 {
    public int findPeakElement(int[] nums) {
        // [le, mid], (mid, ri]
        int le = 0, ri = nums.length - 1;
        while (le < ri) {
            int mid = (le + ri) >>> 1;
            if (nums[mid] < nums[mid + 1]) {
                le = mid + 1;
            } else {
                ri = mid;
            }
        }
        return le;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        Lc162 lc162 = new Lc162();
        int res = lc162.findPeakElement(nums);
        System.out.println("res = " + res);
    }
}
