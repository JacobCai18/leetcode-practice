package com.jacobcai.ccc;

public class Lc209 {
    public int minSubArrayLen(int target,
                              int[] nums) {
        int sum, le, ri, minLen;
        sum = 0;
        // window: [le, ri)
        le = ri = 0;
        minLen = Integer.MAX_VALUE;
        while (ri < nums.length) {
            sum += nums[ri++];
            while (sum >= target) {
                minLen = Math.min(minLen,
                                  ri - le);
                sum -= nums[le++];
            }
        }
        return minLen == Integer.MAX_VALUE ?
               0 :
               minLen;
    }
    
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        Lc209 lc209 = new Lc209();
        int res = lc209.minSubArrayLen(target,
                                       nums);
        System.out.println("res = " + res);
    }
}
