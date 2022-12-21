package com.jacobcai.d;

public class Lc494 {
    private int[] nums;
    private int target;
    private int cnt;
    private int sum;
    
    public int findTargetSumWays(int[] nums,
                                 int target) {
        this.nums = nums;
        this.target = target;
        cnt = 0;
        sum = 0;
        backtrack(0);
        return cnt;
    }
    
    private void backtrack(int i) {
        if (i == nums.length) {
            if (sum == target) {
                cnt++;
            }
            return;
        }
        int num = nums[i];
        sum += num;
        backtrack(i + 1);
        sum -= 2 * num;
        backtrack(i + 1);
        sum += num;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        Lc494 lc494 = new Lc494();
        int res = lc494.findTargetSumWays(nums,
                                          target);
        System.out.println("res = " + res);
    }
}
