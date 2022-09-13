package com.jacobcai.c;

public class Lc45 {
    public int jump(int[] nums) {
        int len;
        if ((len = nums.length) == 1) {
            return 0;
        }
        int maxI = 0;
        int curMaxI = 0;
        // 最后一跳
        int step = 1;
        for (int i = 0; i < len - 1; i++) {
            maxI = Math.max(maxI,
                            i + nums[i]);
            if (maxI >= len - 1) {
                break;
            }
            if (i == curMaxI) {
                curMaxI = maxI;
                step++;
            }
        }
        return step;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 0};
        Lc45 lc45 = new Lc45();
        int res = lc45.jump(nums);
        System.out.println("res = " + res);
    }
}
