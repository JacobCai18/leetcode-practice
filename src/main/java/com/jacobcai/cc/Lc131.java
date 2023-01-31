package com.jacobcai.cc;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Lc131 {
    private void backtrack(String s, List<List<String>> res, Deque<String> stk, boolean[][] dp, int le) {
        if (le == s.length()) {
            res.add(new ArrayList<>(stk));
            return;
        }
        for (int ri = le; ri < s.length(); ri++) {
            if (dp[le][ri]) {
                stk.addLast(s.substring(le, ri + 1));
                backtrack(s, res, stk, dp, ri + 1);
                stk.removeLast();
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        Deque<String> stk = new ArrayDeque<>();
        boolean[][] dp = new boolean[s.length()][s.length()]; // dp[le][ri] == true: 当前le到ri的子串是回文串
        for (int ri = 0; ri < s.length(); ri++)
            for (int le = 0; le <= ri; le++)
                if (s.charAt(le) == s.charAt(ri) && (ri - le <= 2 || dp[le + 1][ri - 1]))
                    dp[le][ri] = true;
        backtrack(s, res, stk, dp, 0);
        return res;
    }

    public static void main(String[] args) {
        String s = "aab";
        Lc131 lc131 = new Lc131();
        List<List<String>> res = lc131.partition(s);
        System.out.println("res = " + res);
    }
}
