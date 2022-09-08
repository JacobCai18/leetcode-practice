package com.jacobcai.ccc;

import java.util.Arrays;

public class Lc209_2 {
    public int minSubArrayLen(int target,
                              int[] nums) {
        int len = nums.length;
        int minLen = Integer.MAX_VALUE;
        // 前缀和数组
        // 为了方便计算，令前缀和数组长度为len + 1
        // sums[i]: 前i个元素的前缀和
        int[] sums = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        // sums: le, ri
        for (int le = 1; le <= len; le++) {
            // sums[ri] - sums[le - 1] >= target -> sums[le - 1] + target <= sums[ri]
            int k = sums[le - 1] + target;
            int ri = Arrays.binarySearch(sums,
                                         k);
            // insertion point: the index of the first element greater than the key
            // ri = -(insertion point) - 1 -> insertion point = ~ri
            if (ri < 0) {
                ri = ~ri;
            }
            // nums: i, j
            // curLen: [i, j] = [le - 1, ri - 1]
            // curLen = j - i + 1 = (ri - 1) - (le - 1) + 1 = ri - le + 1
            if (ri <= len) {
                minLen = Math.min(minLen,
                                  ri - le + 1);
            }
        }
        return minLen == Integer.MAX_VALUE ?
               0 :
               minLen;
    }
    
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        Lc209_2 lc209_2 = new Lc209_2();
        int res = lc209_2.minSubArrayLen(target,
                                         nums);
        System.out.println("res = " + res);
    }
}
