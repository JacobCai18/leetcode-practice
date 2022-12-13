package com.jacobcai.cc;

public class Lc169 {
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int candidate = -1;
        for (int num : nums) {
            if (cnt == 0) {
                candidate = num;
            }
            cnt += num == candidate ?
                   1 :
                   -1;
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
