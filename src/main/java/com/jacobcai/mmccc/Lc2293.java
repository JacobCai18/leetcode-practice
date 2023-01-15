package com.jacobcai.mmccc;

public class Lc2293 {
    public int minMaxGame(int[] nums) {
        int n = nums.length;
        while (n > 1) {
            n >>= 1;
            for (int i = 0; i < n; i++)
                if ((i & 1) == 0)
                    nums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                else
                    nums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
        }
        return nums[0];
    }

    public static void main(String[] args) {
        Lc2293 lc2293 = new Lc2293();
        int[] nums = {70, 38, 21, 22};
        int res = lc2293.minMaxGame(nums);
        System.out.println("res = " + res);
    }
}
