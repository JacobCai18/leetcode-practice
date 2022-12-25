package com.jacobcai.c;

import java.util.Arrays;

public class Lc34 {
    public int[] searchRange(int[] nums,
                             int target) {
        int len;
        int[] res = {-1, -1};
        if ((len = nums.length) == 0) {
            return res;
        }
        int le = 0;
        int ri = len - 1;
        // Find the first index nums[index] >= target
        // [le,mid], (mid,ri]
        while (le < ri) {
            int mid = (le + ri) >>> 1;
            if (nums[mid] < target) {
                le = mid + 1;
            } else {
                ri = mid;
            }
        }
        if (nums[le] != target) {
            return res;
        }
        res[0] = le;
        le = 0;
        ri = len - 1;
        // Find the first index nums[index] <= target;
        // [le, mid), [mid, ri]
        while (le < ri) {
            int mid = (le + ri + 1) >>> 1;
            if (nums[mid] <= target) {
                le = mid;
            } else {
                ri = mid - 1;
            }
        }
        res[1] = le;
        return res[0] > res[1] ?
               new int[]{-1, -1} :
               res;
    }
    
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        Lc34 lc34 = new Lc34();
        int[] res = lc34.searchRange(nums,
                                     target);
        System.out.println("res = " + Arrays.toString(res));
    }
}