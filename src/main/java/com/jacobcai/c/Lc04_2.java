package com.jacobcai.c;

public class Lc04_2 {
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
            return getK(mid,
                        0,
                        0);
        } else {
            int mid1 = len / 2 - 1;
            int mid2 = len / 2;
            return (getK(mid1,
                         0,
                         0) + getK(mid2,
                                   0,
                                   0)) / 2.0;
        }
    }
    
    public int getK(int k,
                    int i1,
                    int i2) {
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
            return getK(k - (newI1 - i1 + 1),
                        newI1 + 1,
                        i2);
        } else {
            return getK(k - (newI2 - i2 + 1),
                        i1,
                        newI2 + 1);
        }
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {2, 4, 6, 8};
        Lc04_2 lc04_2 = new Lc04_2();
        double res = lc04_2.findMedianSortedArrays(nums1,
                                                   nums2);
        System.out.println("res = " + res);
    }
}
