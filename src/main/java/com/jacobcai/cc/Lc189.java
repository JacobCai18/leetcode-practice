package com.jacobcai.cc;

import java.util.Arrays;

public class Lc189 {
    public void rotate(int[] nums,
                       int k) {
        int len = nums.length;
        int[] tmp = new int[len];
        for (int i = 0; i < len; i++) {
            tmp[(i + k) % len] = nums[i];
        }
        System.arraycopy(tmp,
                         0,
                         nums,
                         0,
                         len);
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 2;
        Lc189 lc189 = new Lc189();
        lc189.rotate(nums,
                     k);
        System.out.println("nums = " + Arrays.toString(nums));
    }
}
