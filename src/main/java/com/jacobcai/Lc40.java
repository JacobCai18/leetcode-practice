package com.jacobcai;

import java.util.*;

public class Lc40 {
    int[] candidates;
    int len;
    List<List<Integer>> res;
    Deque<Integer> deque;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        len = candidates.length;
        res = new ArrayList<>();
        deque = new ArrayDeque<>(len);
        Arrays.sort(candidates);
        this.candidates = candidates;
        backtrack(0, target);
        return res;
    }

    private void backtrack(int index, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(deque));
            return;
        }
        for (int i = index; i < len; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            // 让同一层级不出现相同元素，允许不同层级之间重复
            if (i > index && candidates[i - 1] == candidates[i]) {
                continue;
            }
            deque.addLast(candidates[i]);
            backtrack(i + 1, target - candidates[i]);
            deque.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        Lc40 lc40 = new Lc40();
        List<List<Integer>> res = lc40.combinationSum2(candidates, target);
        System.out.println("res = " + res);
    }
}
