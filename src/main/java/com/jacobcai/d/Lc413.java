package com.jacobcai.d;

public class Lc413 {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0;
        int cnt, i, j, gap;
        cnt = 0;
        i = 0;
        j = 1;
        gap = nums[j] - nums[i];
        while (j < nums.length) {
            if (nums[j] - nums[j - 1] != gap) {
                cnt += count(j - i);
                i = j - 1;
                gap = nums[j] - nums[i];
            }
            j++;
        }
        cnt += count(j - i);
        return cnt;
    }
    
    private int count(int len) {
        if (len < 3) return 0;
        len -= 2;
        return (1 + len) * len >> 1;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Lc413 lc413 = new Lc413();
        int res = lc413.numberOfArithmeticSlices(nums);
        System.out.println("res = " + res);
    }
}
