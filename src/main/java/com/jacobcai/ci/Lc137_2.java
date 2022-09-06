package com.jacobcai.ci;

public class Lc137_2 {
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            b = ~a & (b ^ num);
            a = ~b & (a ^ num);
        }
        return b;
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 2};
        Lc137_2 lc137_2 = new Lc137_2();
        int res = lc137_2.singleNumber(nums);
        System.out.println("res = " + res);
    }
}
