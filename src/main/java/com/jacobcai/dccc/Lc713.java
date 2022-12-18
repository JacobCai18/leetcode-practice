package com.jacobcai.dccc;

public class Lc713 {
    public int numSubarrayProductLessThanK(int[] nums,
                                           int k) {
        if (k <= 1) {
            return 0;
        }
        int le, ri, prod, cnt;
        // [le, ri]
        le = ri = 0;
        prod = 1;
        cnt = 0;
        for (; ri < nums.length; ri++) {
            prod *= nums[ri];
            while (prod >= k) {
                prod /= nums[le++];
            }
            cnt += ri - le + 1;
        }
        return cnt;
    }
    
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        Lc713 lc713 = new Lc713();
        int res = lc713.numSubarrayProductLessThanK(nums,
                                                    k);
        System.out.println("res = " + res);
    }
}
