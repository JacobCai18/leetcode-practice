package com.jacobcai.mmdc;

public class Lc2540 {
    public int getCommon(int[] nums1, int[] nums2) {
        int n = nums2.length, j = 0;
        for (int x : nums1) {
            while (j < n && nums2[j] < x) j++;
            if (j < n && nums2[j] == x) return x;
        }
        return -1;
    }

    public static void main(String[] args) {
        Lc2540 lc2540 = new Lc2540();
        int[] nums1 = {2, 4};
        int[] nums2 = {1, 2};
        int res = lc2540.getCommon(nums1, nums2);
        System.out.println("res = " + res);
    }
}
