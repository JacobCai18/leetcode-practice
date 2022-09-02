package com.jacobcai;

public class Lc80 {
    public int removeDuplicates(int[] nums) {
        int len;
        if ((len = nums.length) < 3) {
            return len;
        }
        int le, ri;
        le = ri = 2;
        for (; ri < len; ri++) {
            if (nums[ri] != nums[le - 2]) {
                nums[le++] = nums[ri];
            }
        }
        return le;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        Lc80 lc80 = new Lc80();
        int res = lc80.removeDuplicates(nums);
        System.out.println("res = " + res);
    }
}
