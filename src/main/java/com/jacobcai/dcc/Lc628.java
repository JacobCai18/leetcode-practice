package com.jacobcai.dcc;

public class Lc628 {
    public int maximumProduct(int[] nums) {
        int min1, min2, max1, max2, max3;
        min1 = min2 = Integer.MAX_VALUE;
        max1 = max2 = max3 = Integer.MIN_VALUE;
        for (int x : nums) {
            if (x < min1) {
                min2 = min1;
                min1 = x;
            } else if (x < min2) {
                min2 = x;
            }
            if (x > max1) {
                max3 = max2;
                max2 = max1;
                max1 = x;
            } else if (x > max2) {
                max3 = max2;
                max2 = x;
            } else if (x > max3) {
                max3 = x;
            }
        }
        return Math.max(min1 * min2 * max1,
                        max1 * max2 * max3);
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Lc628 lc628 = new Lc628();
        int res = lc628.maximumProduct(nums);
        System.out.println("res = " + res);
    }
}
