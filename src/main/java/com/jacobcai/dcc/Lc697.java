package com.jacobcai.dcc;

public class Lc697 {
    public int findShortestSubArray(int[] nums) {
        int N = 50000, n = nums.length, mxCnt = 0, mnLen = Integer.MAX_VALUE;
        int[] cnt = new int[N], le = new int[N], ri = new int[N]; // 数据集较小时用数组代替哈希表
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            mxCnt = Math.max(mxCnt, ++cnt[x]);
            if (le[x] == 0) le[x] = i + 1; // 防止下标为 0 的元素被误认为未出现过
            ri[x] = i;
        }
        for (var x : nums)
            if (cnt[x]-- == mxCnt) // 每个度最大的元素只算一次
                mnLen = Math.min(mnLen, ri[x] - le[x] + 2);
        return mnLen;
    }

    public static void main(String[] args) {
        Lc697 lc697 = new Lc697();
        int[] nums = {1, 2, 2, 3, 1};
        int res = lc697.findShortestSubArray(nums);
        System.out.println("res = " + res);
    }
}
