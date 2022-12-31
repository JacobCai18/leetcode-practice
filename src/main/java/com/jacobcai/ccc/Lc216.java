package com.jacobcai.ccc;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Lc216 {
    List<List<Integer>> res;
    Deque<Integer> stack;
    
    public List<List<Integer>> combinationSum3(int k,
                                               int n) {
        res = new ArrayList<>();
        stack = new ArrayDeque<>(k);
        backtrack(k,
                  n,
                  1);
        return res;
    }
    
    private void backtrack(int k,
                           int n,
                           int index) {
        if (k == 0) {
            if (n == 0) {
                res.add(new ArrayList<>(stack));
            }
            return;
        }
        for (int i = index; i <= 9 - k + 1; i++) {
            stack.addLast(i);
            backtrack(k - 1,
                      n - i,
                      i + 1);
            stack.removeLast();
        }
    }
    
    public static void main(String[] args) {
        Lc216 lc216 = new Lc216();
        List<List<Integer>> res = lc216.combinationSum3(2,
                                                        18);
        System.out.println("res = " + res);
    }
}
