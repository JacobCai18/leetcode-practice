package com.jacobcai.dcc;

public class Lc665 {
    public boolean checkPossibility(int[] nums) {
        int len = nums.length, cnt = 0;
        for (int i = 0; i < len - 1; ++i) {
            int x = nums[i], y = nums[i + 1];
            if (x > y) {
                cnt++;
                if (cnt > 1) {
                    return false;
                }
                if (i > 0 && y < nums[i - 1]) {
                    nums[i + 1] = x;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 4, 2, 3};
        Lc665 lc665 = new Lc665();
        boolean res = lc665.checkPossibility(nums);
        System.out.println("res = " + res);
    }
}
