package com.jacobcai.d;

public class Lc485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max, cnt;
        max = cnt = 0;
        for (int n : nums) {
            if (n == 1) {
                cnt++;
            } else {
                max = Math.max(max,
                               cnt);
                cnt = 0;
            }
        }
        return Math.max(max,
                        cnt);
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        Lc485 lc485 = new Lc485();
        int res = lc485.findMaxConsecutiveOnes(nums);
        System.out.println("res = " + res);
    }
}
