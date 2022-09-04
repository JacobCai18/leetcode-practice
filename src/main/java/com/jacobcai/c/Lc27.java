package com.jacobcai.c;

public class Lc27 {
    public int removeElement(int[] nums,
                             int val) {
        int le = 0;
        int ri = nums.length - 1;
        // 左右相等时仍要进入while
        while (le <= ri) {
            if (nums[le] == val) {
                nums[le] = nums[ri--];
            } else {
                le++;
            }
        }
        return le;
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        Lc27 lc27 = new Lc27();
        int res = lc27.removeElement(nums,
                                     val);
        System.out.println("res = " + res);
    }
}
