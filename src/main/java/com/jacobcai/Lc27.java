package com.jacobcai;

public class Lc27 {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        Lc27 lc27 = new Lc27();
        int res = lc27.removeElement(nums, val);
        System.out.println("res = " + res);
    }
}
