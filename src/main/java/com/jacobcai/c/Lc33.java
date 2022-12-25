package com.jacobcai.c;

public class Lc33 {
    public int search(int[] nums,
                      int target) {
        int le, ri;
        le = 0;
        ri = nums.length - 1;
        while (le <= ri) {
            int mid = (le + ri) >>> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[le] <= nums[mid]) { // 前半部分有序
                if (nums[le] <= target && target < nums[mid]) { // target 在前半部分
                    ri = mid - 1;
                } else { // target 在后半部分
                    le = mid + 1;
                }
            } else { // 后半部分有序
                if (nums[mid] < target && target <= nums[ri]) { // target 在后半部分
                    le = mid + 1;
                } else { // target 在前半部分
                    ri = mid - 1;
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
