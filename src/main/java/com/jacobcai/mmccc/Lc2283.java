package com.jacobcai.mmccc;

import java.util.Arrays;

public class Lc2283 {
    public boolean digitCount(String num) {
        int n = num.length();
        int[] cnt = new int[n];
        char[] nums = num.toCharArray();
        for (char c : nums) {
            if (c - '0' > n - 1) return false;
            else cnt[c - '0']++;
        }
        for (int i = 0; i < n; i++)
            if (nums[i] - '0' != cnt[i])
                return false;
        return true;
    }
    
    public static void main(String[] args) {
        String num = "1210";
        Lc2283 lc2283 = new Lc2283();
        boolean res = lc2283.digitCount(num);
        System.out.println("res = " + res);
    }
}
