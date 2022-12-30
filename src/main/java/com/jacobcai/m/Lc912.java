package com.jacobcai.m;

import java.util.Arrays;
import java.util.Random;

public class Lc912 {
    public int[] sortArray(int[] nums) {
        randomizedQuicksort(nums,
                            0,
                            nums.length - 1);
        return nums;
    }
    
    public void randomizedQuicksort(int[] nums,
                                    int l,
                                    int r) {
        if (l < r) {
            int pos = randomizedPartition(nums,
                                          l,
                                          r);
            randomizedQuicksort(nums,
                                l,
                                pos - 1);
            randomizedQuicksort(nums,
                                pos + 1,
                                r);
        }
    }
    
    public int randomizedPartition(int[] nums,
                                   int l,
                                   int r) {
        int i = new Random().nextInt(r - l + 1) + l; // 随机选一个作为我们的主元
        swap(nums,
             r,
             i);
        return partition(nums,
                         l,
                         r);
    }
    
    public int partition(int[] nums,
                         int l,
                         int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums,
                     i,
                     j);
            }
        }
        swap(nums,
             i + 1,
             r);
        return i + 1;
    }
    
    private void swap(int[] nums,
                      int i,
                      int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void main(String[] args) {
        int[] nums = {5, 1, 1, 2, 0, 0};
        Lc912 lc912 = new Lc912();
        int[] res = lc912.sortArray(nums);
        System.out.println("res = " + Arrays.toString(res));
    }
}
