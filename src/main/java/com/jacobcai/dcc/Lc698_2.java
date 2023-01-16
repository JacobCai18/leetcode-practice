package com.jacobcai.dcc;

import java.util.Arrays;

public class Lc698_2 {
    private int[] nums;
    private int target, n;
    private boolean[] visited;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        this.nums = nums;
        int sum = Arrays.stream(nums).sum();
        if (sum % k > 0) return false;
        target = sum / k;
        Arrays.sort(nums);
        n = nums.length;
        if (nums[n - 1] > target) return false;
        visited = new boolean[n];
        return dfs(k, 0, n - 1);
    }

    private boolean dfs(int k, int curSum, int idx) {
        if (k == 0) return true;
        if (curSum == target) return dfs(k - 1, 0, n - 1);
        for (int i = idx; i > -1; i--) { // 从大到小
            if (visited[i] || nums[i] + curSum > target) continue;
            visited[i] = true;
            if (dfs(k, curSum + nums[i], i - 1)) return true;
            visited[i] = false;
            if (curSum == 0) return false; // 最大的数无法回溯成功
        }
        return false;
    }

    public static void main(String[] args) {
        Lc698_2 lc698 = new Lc698_2();
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        boolean res = lc698.canPartitionKSubsets(nums, 4);
        System.out.println("res = " + res);
    }
}
