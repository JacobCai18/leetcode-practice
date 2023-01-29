package com.jacobcai.mmdc;

import java.util.Arrays;

public class Lc2541 {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        if (k == 0) return Arrays.equals(nums1, nums2) ? 0 : -1;
        int n = nums1.length;
        long cnt = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            int diff = nums1[i] - nums2[i];
            if (diff % k != 0) return -1;
            if (diff > 0) cnt += diff / k;
            sum += diff;
        }
        return sum == 0 ? cnt : -1;
    }

    public static void main(String[] args) {
        Lc2541 lc2541 = new Lc2541();
        int[] nums1 = {4, 3, 1, 4};
        int[] nums2 = {1, 3, 7, 1};
        long res = lc2541.minOperations(nums1, nums2, 3);
        System.out.println("res = " + res);
    }
}
