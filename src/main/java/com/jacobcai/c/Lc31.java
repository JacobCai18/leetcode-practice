package com.jacobcai.c;

import java.util.Arrays;

public class Lc31 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return;
        }
        // 从后向前找到第一个比前一个小的数
        int i = n - 2;
        for (; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }
        // 若数组降序，则翻转
        if (i == -1) {
            reverse(nums,
                    0,
                    n - 1);
            return;
        }
        // 从后向前找第一个比nums[i]大的数
        int j = n - 1;
        for (; j >= i; j--) {
            if (nums[j] > nums[i]) {
                break;
            }
        }
        swap(nums,
             i,
             j);
        reverse(nums,
                i + 1,
                n - 1);
    }
    
    private void swap(int[] nums,
                      int i,
                      int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums,
                         int i,
                         int j) {
        while (i < j) {
            swap(nums,
                 i,
                 j);
            i++;
            j--;
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 3, 6, 5, 2};
        Lc31 lc31 = new Lc31();
        lc31.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
