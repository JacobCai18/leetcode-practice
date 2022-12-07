package com.jacobcai.mdccc;

import java.util.Arrays;

public class Lc1775 {
    public int minOperations(int[] nums1,
                             int[] nums2) {
        int len1, len2, diff;
        len1 = nums1.length;
        len2 = nums2.length;
        // 无论如何变都无法相等
        if (6 * len1 < len2 || 6 * len2 < len1) {
            return -1;
        }
        diff = Arrays.stream(nums1).sum() - Arrays.stream(nums2).sum();
        if (diff < 0) {
            return helper(-diff, nums2, nums1);
        }
        return helper(diff, nums1, nums2);
    }
    
    /**
     * @param diff  非负数
     * @param nums1 和较大
     * @param nums2 和较小
     *
     * @return 最小操作数
     */
    private int helper(int diff,
                       int[] nums1,
                       int[] nums2) {
        // 统计每个数的最大变化量
        int[] cnts = new int[6];
        // 将 nums1 中的 6 变为 1
        for (int num1 : nums1) {
            cnts[num1 - 1]++;
        }
        // 将 nums2 中的 1 变为 6
        for (int num2 : nums2) {
            cnts[6 - num2]++;
        }
        int res = 0;
        // 贪心，从最大变化量开始变
        for (int i = 5; i > 0 && diff > 0; i--) {
            int cnt = Math.min((diff + i - 1) / i, cnts[i]);
            res += cnt;
            diff -= i * cnt;
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6};
        int[] nums2 = {1, 1, 2, 2, 2};
        Lc1775 lc1775 = new Lc1775();
        int res = lc1775.minOperations(nums1,
                                       nums2);
        System.out.println("res = " + res);
    }
}
