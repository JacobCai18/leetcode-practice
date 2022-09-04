package com.jacobcai.c;

public class Lc26 {
    public int removeDuplicates(int[] nums) {
        int le = 0;
        int ri = 1;
        while (ri < nums.length) {
            if (nums[le] != nums[ri]) {
                nums[++le] = nums[ri];
            }
            ri++;
        }
        return le + 1;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        Lc26 lc26 = new Lc26();
        int res = lc26.removeDuplicates(nums);
        System.out.println("res = " + res);
    }
}
