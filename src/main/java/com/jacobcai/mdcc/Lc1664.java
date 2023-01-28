package com.jacobcai.mdcc;

public class Lc1664 {
    public int waysToMakeFair(int[] nums) {
        int n = nums.length, cnt = 0, o1 = 0, o2 = 0, e1 = 0, e2 = 0;
        for (int i = 0; i < n; i++)
            if ((i & 1) == 1) o2 += nums[i];
            else e2 += nums[i];
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 1) o2 -= nums[i];
            else e2 -= nums[i];
            if (o1 + e2 == e1 + o2) cnt++;
            if ((i & 1) == 1) o1 += nums[i];
            else e1 += nums[i];
        }
        return cnt;
    }

    public static void main(String[] args) {
        Lc1664 lc1664 = new Lc1664();
        int[] nums = {2, 1, 6, 4};
        int res = lc1664.waysToMakeFair(nums);
        System.out.println("res = " + res);
    }
}
