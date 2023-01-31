package com.jacobcai.cc;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Lc131_2 {
    private void expendFromMid(String s, boolean[][] dp, int le, int ri) {
        while (le >= 0 && ri < s.length() && s.charAt(le) == s.charAt(ri)) dp[le--][ri++] = true;
    }

    private void backtrack(String s, List<List<String>> res, Deque<String> stack, boolean[][] dp, int le) {
        if (le == s.length()) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int ri = le; ri < s.length(); ri++) {
            if (dp[le][ri]) {
                stack.addLast(s.substring(le, ri + 1));
                backtrack(s, res, stack, dp, ri + 1);
                stack.removeLast();
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();
        int n = s.length();
        boolean[][] dp = new boolean[n][n]; // dp[le][ri] == true: 当前le到ri的子串是回文串
        for (int i = 0; i < n; i++) {
            expendFromMid(s, dp, i, i);
            expendFromMid(s, dp, i, i + 1);
        }
        backtrack(s, res, stack, dp, 0);
        return res;
    }

    public static void main(String[] args) {
        String s = "aab";
        Lc131_2 lc131_2 = new Lc131_2();
        List<List<String>> res = lc131_2.partition(s);
        System.out.println("res = " + res);
    }
}
