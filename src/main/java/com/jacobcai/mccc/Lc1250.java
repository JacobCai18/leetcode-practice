package com.jacobcai.mccc;

public class Lc1250 {
    private int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    public boolean isGoodArray(int[] nums) {
        int divisor = nums[0];
        for (int x : nums) {
            divisor = gcd(divisor, x);
            if (divisor == 1) break;
        }
        return divisor == 1;
    }

    public static void main(String[] args) {
        Lc1250 lc1250 = new Lc1250();
        int[] nums = {12, 5, 7, 23};
        boolean res = lc1250.isGoodArray(nums);
        System.out.println("res = " + res);
    }
}
