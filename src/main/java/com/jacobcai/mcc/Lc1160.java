package com.jacobcai.mcc;

import java.util.HashMap;
import java.util.Map;

public class Lc1160 {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> charsCnt = new HashMap<>();
        int n = chars.length();
        for (int i = 0; i < n; i++) {
            char c = chars.charAt(i);
            charsCnt.put(c, charsCnt.getOrDefault(c, 0) + 1);
        }
        int ans = 0;
        for (String word : words) {
            Map<Character, Integer> wordCnt = new HashMap<>();
            int m = word.length();
            for (int i = 0; i < m; i++) {
                char c = word.charAt(i);
                wordCnt.put(c, wordCnt.getOrDefault(c, 0) + 1);
            }
            boolean isAns = true;
            for (int i = 0; i < m; i++) {
                char c = word.charAt(i);
                if (charsCnt.getOrDefault(c, 0) < wordCnt.getOrDefault(c, 0)) {
                    isAns = false;
                    break;
                }
            }
            if (isAns) ans += word.length();
        }
        return ans;
    }

    public static void main(String[] args) {
        Lc1160 lc1160 = new Lc1160();
        String[] words = {"cat", "bt", "hat", "tree"};
        String chars = "atach";
        int res = lc1160.countCharacters(words, chars);
        System.out.println("res = " + res);
    }
}
