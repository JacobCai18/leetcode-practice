package com.jacobcai.cd;

public class Lc300_2 {
    public int lengthOfLIS(int[] nums) {
        int m = nums.length, n = 1;
        int[] inc = new int[m + 1]; // inc[i] = 长度为 i 的最长上升子序列的末尾元素的最小值
        inc[n] = nums[0];
        for (int i = 1; i < m; i++) {
            if (nums[i] > inc[n]) {
                inc[++n] = nums[i];
                continue;
            }
            int le = 1, ri = n;
            while (le < ri) {
                int mid = (le + ri) >> 1;
                if (inc[mid] < nums[i])
                    le = mid + 1;
                else
                    ri = mid;
            }
            inc[le] = nums[i]; // 找到 inc 中第一个不小于 nums[i] 的数并替换
        }
        return n;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        Lc300_2 lc300_2 = new Lc300_2();
        int res = lc300_2.lengthOfLIS(nums);
        System.out.println("res = " + res);
    }
}
