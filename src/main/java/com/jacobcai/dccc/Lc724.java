package com.jacobcai.dccc;

public class Lc724 {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int n : nums) sum += n;
        int leSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int riSum = sum - leSum - nums[i];
            if (leSum == riSum) return i;
            leSum += nums[i];
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        Lc724 lc724 = new Lc724();
        int res = lc724.pivotIndex(nums);
        System.out.println("res = " + res);
    }
}
