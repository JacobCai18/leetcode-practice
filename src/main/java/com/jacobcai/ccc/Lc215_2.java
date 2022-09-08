package com.jacobcai.ccc;

import java.util.Random;

public class Lc215_2 {
    // 使用随机数
    private static final Random RANDOM = new Random(System.currentTimeMillis());
    
    public int findKthLargest(int[] nums,
                              int k) {
        int len = nums.length;
        // target: 升序排序后的第k大的数是第len-k小，其下标为len-k
        int target = len - k;
        int le = 0;
        int ri = len - 1;
        while (true) {
            int[] pivotPair = partition(nums,
                                        le,
                                        ri);
            int lePivot = pivotPair[0];
            int riPivot = pivotPair[1];
            // target in nums
            // [le, lePivot):      find [le, lePivot-1]
            // [lePivot, riPivot]: return nums[target]
            // (riPivot, ri]:      find [riPivot+1, ri]
            if (target < lePivot) {
                ri = lePivot - 1;
            } else if (target > riPivot) {
                le = riPivot + 1;
            } else {
                return nums[target];
            }
        }
    }
    
    private int[] partition(int[] nums,
                            int le,
                            int ri) {
        // 使用随机数
        // bound: the upper bound (exclusive). Must be positive
        int randomIndex = le + RANDOM.nextInt(ri - le + 1);
        swap(nums,
             randomIndex,
             le);
        // 循环不变量：
        // all in [le, lePivot) < pivotNum
        // all in [lePivot, i) = pivotNum
        // all in [i, riPivot] = unread
        // all in (riPivot, ri] > pivotNum
        int pivotNum, lePivot, riPivot, i;
        pivotNum = nums[le];
        lePivot = i = le;
        riPivot = ri;
        while (i <= riPivot) {
            if (nums[i] < pivotNum) {
                swap(nums,
                     i++,
                     lePivot++);
            } else if (nums[i] == pivotNum) {
                i++;
            } else {
                swap(nums,
                     i,
                     riPivot--);
            }
        }
        return new int[]{lePivot, riPivot};
    }
    
    private void swap(int[] nums,
                      int i,
                      int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        Lc215_2 lc215_2 = new Lc215_2();
        int res = lc215_2.findKthLargest(nums,
                                         k);
        System.out.println("res = " + res);
    }
}
