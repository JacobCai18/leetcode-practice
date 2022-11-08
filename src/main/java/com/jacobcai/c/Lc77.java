package com.jacobcai.c;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Lc77 {
    List<List<Integer>> res;
    Deque<Integer> deque;
    int n;
    int k;
    
    public List<List<Integer>> combine(int n,
                                       int k) {
        res = new ArrayList<>();
        deque = new ArrayDeque<>(k);
        this.n = n;
        this.k = k;
        backtrack(1);
        return res;
    }
    
    private void backtrack(int index) {
        int remainSpace = k - deque.size();
        if (remainSpace == 0) {
            res.add(new ArrayList<>(deque));
            return;
        }
        for (int i = index; i <= n - remainSpace + 1; i++) {
            deque.addLast(i);
            backtrack(i + 1);
            deque.removeLast();
        }
    }
    
    public static void main(String[] args) {
        int n = 4, k = 2;
        Lc77 lc77 = new Lc77();
        List<List<Integer>> res = lc77.combine(n,
                                               k);
        System.out.println("res = " + res);
    }
}
