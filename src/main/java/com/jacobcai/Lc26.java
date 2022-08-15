package com.jacobcai;

public class Lc26 {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        Lc26 lc26 = new Lc26();
        int res = lc26.removeDuplicates(nums);
        System.out.println("res = " + res);
    }
}
