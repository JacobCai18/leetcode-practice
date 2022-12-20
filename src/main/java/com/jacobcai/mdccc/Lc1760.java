package com.jacobcai.mdccc;

public class Lc1760 {
    public int minimumSize(int[] nums,
                           int maxOperations) {
        int le = 1;
        int ri = 0;
        for (int num : nums) {
            ri = Math.max(ri, num);
        }
        int res = 0;
        while (le <= ri) {
            int mid = (le + ri) >>> 1;
            long ops = 0;
            for (int num : nums) {
                ops += (num - 1) / mid;
            }
            if (ops <= maxOperations) {
                res = mid;
                ri = mid - 1;
            } else {
                le = mid + 1;
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 4, 8, 2};
        int maxOperations = 4;
        Lc1760 lc1760 = new Lc1760();
        int res = lc1760.minimumSize(nums,
                                     maxOperations);
        System.out.println("res = " + res);
    }
}
