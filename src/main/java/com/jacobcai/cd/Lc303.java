package com.jacobcai.cd;

public class Lc303 {
    private final int[] sums;
    
    public Lc303(int[] nums) {
        int len = nums.length;
        sums = new int[len + 1];
        for (int i = 0; i < len; i++) {
            // nums[0] ~ nums[i] 的和
            sums[i + 1] = sums[i] + nums[i];
        }
    }
    
    /**
     * @param left  nums 左下标
     * @param right nums 右下标
     *
     * @return nums[left] ~ nums[right] 的和
     */
    public int sumRange(int left,
                        int right) {
        return sums[right + 1] - sums[left];
    }
    
    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        Lc303 lc303 = new Lc303(nums);
        int res = lc303.sumRange(2,
                                 5);
        System.out.println("res = " + res);
    }
}
