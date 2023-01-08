package com.jacobcai.cd;

public class Lc376 {
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if (len < 2) return len;
        int preDiff = nums[1] - nums[0];
        int cnt = preDiff != 0 ? 2 : 1;
        for (int i = 2; i < len; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((preDiff <= 0 && diff > 0) || (preDiff >= 0 && diff < 0)) {
                cnt++;
                // 只在摆动时更新，消除平坡影响
                preDiff = diff;
            }
        }
        return cnt;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 7, 4, 6, 9, 2, 5};
        Lc376 lc376 = new Lc376();
        int res = lc376.wiggleMaxLength(nums);
        System.out.println("res = " + res);
    }
}
