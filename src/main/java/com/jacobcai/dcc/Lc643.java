package com.jacobcai.dcc;

public class Lc643 {
    public double findMaxAverage(int[] nums,
                                 int k) {
        int ri, sum, max;
        sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        ri = k;
        max = sum;
        while (ri < nums.length) {
            sum += (nums[ri] - nums[ri++ - k]);
            max = Math.max(max,
                           sum);
        }
        return (double) max / k;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        Lc643 lc643 = new Lc643();
        double res = lc643.findMaxAverage(nums,
                                          k);
        System.out.println("res = " + res);
    }
}
