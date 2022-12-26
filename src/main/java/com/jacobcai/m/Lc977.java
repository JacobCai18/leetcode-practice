package com.jacobcai.m;

import java.util.Arrays;

public class Lc977 {
    public int[] sortedSquares(int[] nums) {
        int len, le, ri, p;
        len = nums.length;
        le = 0;
        ri = p = len - 1;
        int[] res = new int[len];
        while (le <= ri) {
            int le2, ri2;
            if ((le2 = nums[le] * nums[le]) < (ri2 = nums[ri] * nums[ri])) {
                res[p] = ri2;
                ri--;
            } else {
                res[p] = le2;
                le++;
            }
            p--;
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        Lc977 lc977 = new Lc977();
        int[] res = lc977.sortedSquares(nums);
        System.out.println("res = " + Arrays.toString(res));
    }
}
