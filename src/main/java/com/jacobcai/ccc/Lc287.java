package com.jacobcai.ccc;

public class Lc287 {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[slow];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int ptr = 0;
        while (ptr != slow) {
            ptr = nums[ptr];
            slow = nums[slow];
        }
        return ptr;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        Lc287 lc287 = new Lc287();
        int res = lc287.findDuplicate(nums);
        System.out.println("res = " + res);
    }
}
