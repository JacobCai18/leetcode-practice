package com.jacobcai.c;

public class Lc04 {
    int[] nums1, nums2;
    int len1, len2;
    
    public double findMedianSortedArrays(int[] nums1,
                                         int[] nums2) {
        int len;
        len1 = nums1.length;
        len2 = nums2.length;
        len = len1 + len2;
        this.nums1 = nums1;
        this.nums2 = nums2;
        if ((len & 1) == 1) {
            int mid = len / 2;
            return getK(mid);
        } else {
            int mid1 = len / 2 - 1;
            int mid2 = len / 2;
            return (getK(mid1) + getK(mid2)) / 2.0;
        }
    }
    
    public int getK(int k) {
        int i1, i2;
        i1 = i2 = 0;
        while (true) {
            if (i1 == len1) {
                return nums2[i2 + k];
            }
            if (i2 == len2) {
                return nums1[i1 + k];
            }
            if (k == 0) {
                return Math.min(nums1[i1],
                                nums2[i2]);
            }
            int newI1 = Math.min(i1 + ((k - 1) >>> 1),
                                 len1 - 1);
            int newI2 = Math.min(i2 + ((k - 1) >>> 1),
                                 len2 - 1);
            if (nums1[newI1] <= nums2[newI2]) {
                k -= (newI1 - i1 + 1);
                i1 = newI1 + 1;
            } else {
                k -= (newI2 - i2 + 1);
                i2 = newI2 + 1;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {2, 4, 6, 8};
        Lc04 lc04 = new Lc04();
        double res = lc04.findMedianSortedArrays(nums1,
                                                 nums2);
        System.out.println("res = " + res);
    }
}
