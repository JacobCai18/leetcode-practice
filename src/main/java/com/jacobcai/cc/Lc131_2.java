package com.jacobcai.cc;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Lc131_2 {
    List<List<String>> res;
    Deque<String> stack;
    int len;
    String s;
    boolean[][] dp;
    
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        stack = new ArrayDeque<>();
        len = s.length();
        this.s = s;
        // dp[le][ri] == true: 当前le到ri的子串是回文串
        dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            expendFromMid(i,
                          i);
            expendFromMid(i,
                          i + 1);
        }
        backtrack(0);
        return res;
    }
    
    private void expendFromMid(int le,
                               int ri) {
        while (le >= 0 && ri < len && s.charAt(le) == s.charAt(ri)) {
            dp[le][ri] = true;
            le--;
            ri++;
        }
    }
    
    private void backtrack(int le) {
        if (le == len) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int ri = le; ri < len; ri++) {
            if (dp[le][ri]) {
                stack.addLast(s.substring(le, ri + 1));
                backtrack(ri + 1);
                stack.removeLast();
            }
        }
    }
    
    public static void main(String[] args) {
        String s = "aab";
        Lc131_2 lc131_2 = new Lc131_2();
        List<List<String>> res = lc131_2.partition(s);
        System.out.println("res = " + res);
    }
}
