package com.jacobcai.cc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lc140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> st = new HashSet<>(wordDict);
        List<String>[] f = new List[n + 1];
        for (int j = 0; j < n; j++) {
            String substr;
            f[j + 1] = new ArrayList<>();
            if (st.contains(substr = s.substring(0, j + 1)))
                f[j + 1].add(substr);
            for (int i = j; i > 0; i--)
                if (!f[i].isEmpty() && st.contains(substr = s.substring(i, j + 1)))
                    for (var e : f[i])
                        f[j + 1].add(e + ' ' + substr);
        }
        return f[n];
    }

    public static void main(String[] args) {
        Lc140 lc140 = new Lc140();
        String s = "catsanddog";
        List<String> wordDict = List.of("cat", "cats", "and", "sand", "dog");
        List<String> res = lc140.wordBreak(s, wordDict);
        System.out.println("res = " + res);
    }
}
