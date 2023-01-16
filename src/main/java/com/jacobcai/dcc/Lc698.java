package com.jacobcai.dcc;

import java.util.Arrays;

public class Lc698 {
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
        visited = new boolean[1 << n];
        return dfs(0, 0);
    }

    private boolean dfs(int state, int curSum) {
        if (state == (1 << n) - 1) return true;
        if (visited[state]) return false;
        visited[state] = true;
        for (int i = 0; i < n; i++) {
            if (nums[i] + curSum > target) break;
            if (((state >> i) & 1) == 1) continue;
            if (dfs(state ^ (1 << i), (nums[i] + curSum) % target))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Lc698 lc698 = new Lc698();
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        boolean res = lc698.canPartitionKSubsets(nums, 4);
        System.out.println("res = " + res);
    }
}
