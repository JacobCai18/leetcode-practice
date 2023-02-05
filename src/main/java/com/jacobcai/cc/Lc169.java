package com.jacobcai.cc;

public class Lc169 {
    public int majorityElement(int[] nums) {
        int ct = 0, candidate = -1;
        for (int num : nums) {
            if (ct == 0) candidate = num;
            ct += num == candidate ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        Lc169 lc169 = new Lc169();
        int res = lc169.majorityElement(nums);
        System.out.println("res = " + res);
    }
}
