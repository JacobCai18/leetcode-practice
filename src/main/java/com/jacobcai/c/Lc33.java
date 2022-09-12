package com.jacobcai.c;

public class Lc33 {
    public int search(int[] nums,
                      int target) {
        int lo, hi, mid;
        lo = 0;
        hi = nums.length - 1;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 前半部分有序
            if (nums[lo] <= nums[mid]) {
                // target在前半部分
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else { // 后半部分有序
                // target在后半部分
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        Lc33 lc33 = new Lc33();
        int res = lc33.search(nums,
                              target);
        System.out.println("res = " + res);
    }
}
