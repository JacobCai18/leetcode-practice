package com.jacobcai;

public class Lc27 {
    public int removeElement(int[] nums,
                             int val) {
        int left = 0;
        int right = nums.length - 1;
        // 左右相等时仍要进入while
        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        Lc27 lc27 = new Lc27();
        int res = lc27.removeElement(nums,
                                     val);
        System.out.println("res = " + res);
    }
}
