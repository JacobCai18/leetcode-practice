package com.jacobcai.c;

public class Lc81 {
    public boolean search(int[] nums,
                          int target) {
        int len = nums.length;
        int le = 0, ri = len - 1;
        while (le <= ri) {
            int mid = (le + ri) >>> 1;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[le] == nums[mid] && nums[mid] == nums[ri]) { // 左中右相等
                ++le;
                --ri;
            } else if (nums[le] <= nums[mid]) { // 前半部分有序
                if (nums[le] <= target && target < nums[mid]) { // target 在前半部分
                    ri = mid - 1;
                } else {
                    le = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[len - 1]) {
                    le = mid + 1;
                } else {
                    ri = mid - 1;
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        int target = 0;
        Lc81 lc81 = new Lc81();
        boolean res = lc81.search(nums,
                                  target);
        System.out.println("res = " + res);
    }
}
