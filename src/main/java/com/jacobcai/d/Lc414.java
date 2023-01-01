package com.jacobcai.d;

public class Lc414 {
    public int thirdMax(int[] nums) {
        Integer a, b, c;
        a = b = c = null;
        for (int num : nums) {
            if (a == null || a < num) {
                c = b;
                b = a;
                a = num;
            } else if (a > num && (b == null || b < num)) {
                c = b;
                b = num;
            } else if (b != null && b > num && (c == null || c < num)) {
                c = num;
            }
        }
        return c == null ?
               a :
               c;
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 1};
        Lc414 lc414 = new Lc414();
        int res = lc414.thirdMax(nums);
        System.out.println("res = " + res);
    }
}
