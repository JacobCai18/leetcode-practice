package com.jacobcai;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Lc46 {
    private List<List<Integer>> res;
    private Deque<Integer> deque;
    private boolean[] visited;
    private int len;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        len = nums.length;
        deque = new ArrayDeque<>(len);
        visited = new boolean[len];
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int curr) {
        if (curr == len) {
            res.add(new ArrayList<>(deque));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                deque.addLast(nums[i]);
                visited[i] = true;
                backtrack(nums, curr + 1);
                deque.removeLast();
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Lc46 lc46 = new Lc46();
        List<List<Integer>> res = lc46.permute(nums);
        System.out.println(res);
    }
}
