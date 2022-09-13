package com.jacobcai.c;

public class Lc41 {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            // 满足在指定范围内、并且没有放在正确的位置上，才交换
            while (0 < nums[i] && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                swap(nums,
                     nums[i] - 1,
                     i);
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }
    
    private void swap(int[] nums,
                      int i,
                      int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public static void main(String[] args) {
        int[] nums = {7, 9, 8, 1, 2, 10};
        Lc41 lc41 = new Lc41();
        int res = lc41.firstMissingPositive(nums);
        System.out.println("res = " + res);
    }
}
