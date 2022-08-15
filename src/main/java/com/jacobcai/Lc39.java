package com.jacobcai;

import java.util.*;

public class Lc39 {
    private int[] candidates;
    private List<List<Integer>> res;
    private Deque<Integer> deque;
    private int len;
    
    public List<List<Integer>> combinationSum(int[] candidates,
                                              int target) {
        len = candidates.length;
        res = new ArrayList<>();
        deque = new ArrayDeque<>();
        Arrays.sort(candidates);
        this.candidates = candidates;
        backtrack(0,
                  target);
        return res;
    }
    
    private void backtrack(int index,
                           int target) {
        if (target == 0) {
            res.add(new ArrayList<>(deque));
            return;
        }
        for (int i = index; i < len; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            deque.addLast(candidates[i]);
            backtrack(i,
                      target - candidates[i]);
            deque.removeLast();
        }
    }
    
    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 8;
        Lc39 lc39 = new Lc39();
        List<List<Integer>> res = lc39.combinationSum(candidates,
                                                      target);
        System.out.println(res);
    }
}
