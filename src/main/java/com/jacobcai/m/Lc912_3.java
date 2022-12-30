package com.jacobcai.m;

import java.util.Arrays;

public class Lc912_3 {
    int[] tmp;
    
    public int[] sortArray(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums,
                  0,
                  nums.length - 1);
        return nums;
    }
    
    public void mergeSort(int[] nums,
                          int l,
                          int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) >> 1;
        mergeSort(nums,
                  l,
                  mid);
        mergeSort(nums,
                  mid + 1,
                  r);
        int i = l, j = mid + 1;
        int cnt = 0;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                tmp[cnt++] = nums[i++];
            } else {
                tmp[cnt++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[cnt++] = nums[i++];
        }
        while (j <= r) {
            tmp[cnt++] = nums[j++];
        }
        if (r - l + 1 >= 0) {
            System.arraycopy(tmp,
                             0,
                             nums,
                             l,
                             r - l + 1);
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {5, 1, 1, 2, 0, 0};
        Lc912_3 lc912_2 = new Lc912_3();
        int[] res = lc912_2.sortArray(nums);
        System.out.println("res = " + Arrays.toString(res));
    }
}
