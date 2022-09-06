package com.jacobcai.ci;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Lc131 {
    List<List<String>> res = new ArrayList<>();
    Deque<String> stack = new ArrayDeque<>();
    int len;
    boolean[][] dp;
    
    public List<List<String>> partition(String s) {
        len = s.length();
        // dp[le][ri] == true: 当前le到ri的子串是回文串
        dp = new boolean[len][len];
        for (int ri = 0; ri < len; ri++) {
            for (int le = 0; le <= ri; le++) {
                if (s.charAt(le) == s.charAt(ri) && (ri - le <= 2 || dp[le + 1][ri - 1])) {
                    dp[le][ri] = true;
                }
            }
        }
        backtrack(s,
                  0);
        return res;
    }
    
    private void backtrack(String s,
                           int le) {
        if (le == len) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int ri = le; ri < len; ri++) {
            if (dp[le][ri]) {
                stack.addLast(s.substring(le, ri + 1));
                backtrack(s,
                          ri + 1);
                stack.removeLast();
            }
        }
    }
    
    public static void main(String[] args) {
        String s = "aab";
        Lc131 lc131 = new Lc131();
        List<List<String>> res = lc131.partition(s);
        System.out.println("res = " + res);
    }
}
