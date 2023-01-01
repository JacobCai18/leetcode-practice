package com.jacobcai.dccc;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Lc797 {
    List<List<Integer>> res;
    Deque<Integer> stack;
    int[][] graph;
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        res = new ArrayList<>();
        stack = new ArrayDeque<>();
        this.graph = graph;
        stack.addLast(0);
        backtrack(0);
        return res;
    }
    
    private void backtrack(int i) {
        if (i == graph.length - 1) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int j : graph[i]) {
            stack.addLast(j);
            backtrack(j);
            stack.removeLast();
        }
    }
    
    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        Lc797 lc797 = new Lc797();
        List<List<Integer>> res = lc797.allPathsSourceTarget(graph);
        System.out.println("res = " + res);
    }
}
