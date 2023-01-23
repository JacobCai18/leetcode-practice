package com.jacobcai.cc;

public class Lc154 {
    public int findMin(int[] nums) {
        int le = 0, ri = nums.length - 1;
        while (le < ri) { // [le, mid], [mid + 1, ri]
            int mid = (le + ri) >> 1;
            if (nums[mid] < nums[ri]) {
                ri = mid;
            } else if (nums[mid] > nums[ri]) {
                le = mid + 1;
            } else {
                ri--; // 存在重复元素
            }
        }
        return nums[le];
    }

    public static void main(String[] args) {
        Lc154 lc154 = new Lc154();
        int[] nums = {2, 2, 2, 0, 2};
        int res = lc154.findMin(nums);
        System.out.println("res = " + res);
    }
}
