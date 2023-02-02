package com.jacobcai.cc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lc139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int j = 1; j <= n; j++)
            for (int i = j - 1; i > -1; i--)
                if (dp[i] && wordDictSet.contains(s.substring(i, j))) {
                    dp[j] = true;
                    break;
                }
        return dp[n];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        Lc139 lc139 = new Lc139();
        boolean res = lc139.wordBreak(s, wordDict);
        System.out.println("res = " + res);
    }
}
