package com.jacobcai.dccc;

public class Lc704 {
    public int search(int[] nums,
                      int target) {
        int le, ri;
        le = 0;
        ri = nums.length - 1;
        // [le,mid),mid,(mid,ri]
        while (le <= ri) {
            int mid = (le + ri) >>> 1;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                ri = mid - 1;
            } else {
                le = mid + 1;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        Lc704 lc704 = new Lc704();
        int res = lc704.search(nums,
                               target);
        System.out.println("res = " + res);
    }
}
