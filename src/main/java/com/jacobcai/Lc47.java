package com.jacobcai;

import java.util.*;

public class Lc47 {
    int len;
    List<List<Integer>> res;
    Deque<Integer> deque;
    boolean[] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        len = nums.length;
        res = new ArrayList<>();
        deque = new ArrayDeque<>(len);
        visited = new boolean[len];
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int index) {
        if (index == len) {
            res.add(new ArrayList<>(deque));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (visited[i]) {
                continue;
            }
            // nums[i - 1]刚刚被撤销选择
            if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) {
                continue;
            }
            deque.addLast(nums[i]);
            visited[i] = true;
            backtrack(nums, index + 1);
            deque.removeLast();
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1};
        Lc47 lc47 = new Lc47();
        List<List<Integer>> res = lc47.permuteUnique(nums);
        System.out.println("res = " + res);
    }
}
