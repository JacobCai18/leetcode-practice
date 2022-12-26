package com.jacobcai.cc;

import java.util.Arrays;

public class Lc189_2 {
    public void rotate(int[] nums,
                       int k) {
        int len = nums.length;
        k = k % len;
        int count = gcd(k,
                        len);
        for (int start = 0; start < count; start++) {
            int curr = start;
            int prev = nums[start];
            do {
                int next = (curr + k) % len;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                curr = next;
            } while (start != curr);
        }
    }
    
    public int gcd(int x,
                   int y) {
        return y > 0 ?
               gcd(y,
                   x % y) :
               x;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 2;
        Lc189_2 lc189_2 = new Lc189_2();
        lc189_2.rotate(nums,
                       k);
        System.out.println("nums = " + Arrays.toString(nums));
    }
}
