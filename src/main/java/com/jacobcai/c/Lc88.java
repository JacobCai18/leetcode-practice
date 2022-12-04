package com.jacobcai.c;

import java.util.Arrays;

public class Lc88 {
    public void merge(int[] nums1,
                      int m,
                      int[] nums2,
                      int n) {
        int le1 = m - 1;
        int le2 = n - 1;
        int ri = m + n - 1;
        while (le1 >= 0 || le2 >= 0) {
            if (le1 == -1) {
                nums1[ri--] = nums2[le2--];
            } else if (le2 == -1) {
                nums1[ri--] = nums1[le1--];
            } else if (nums1[le1] > nums2[le2]) {
                nums1[ri--] = nums1[le1--];
            } else {
                nums1[ri--] = nums2[le2--];
            }
        }
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        Lc88 lc88 = new Lc88();
        lc88.merge(nums1,
                   m,
                   nums2,
                   n);
        System.out.println("nums1 = " + Arrays.toString(nums1));
    }
}
