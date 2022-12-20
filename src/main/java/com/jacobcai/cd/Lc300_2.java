package com.jacobcai.cd;

public class Lc300_2 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] d = new int[len + 1];
        int lenD = 1;
        d[lenD] = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] > d[lenD]) {
                d[++lenD] = nums[i];
            } else {
                int le = 1, ri = lenD, index = 0;
                while (le <= ri) {
                    int mid = (le + ri) >>> 1;
                    if (d[mid] < nums[i]) {
                        index = mid;
                        le = mid + 1;
                    } else {
                        ri = mid - 1;
                    }
                }
                d[index + 1] = nums[i];
            }
        }
        return lenD;
    }
    
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        Lc300_2 lc300_2 = new Lc300_2();
        int res = lc300_2.lengthOfLIS(nums);
        System.out.println("res = " + res);
    }
}
