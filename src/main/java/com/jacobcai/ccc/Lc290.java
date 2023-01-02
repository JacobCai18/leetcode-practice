package com.jacobcai.ccc;

import java.util.HashMap;
import java.util.Map;

public class Lc290 {
    public boolean wordPattern(String pattern,
                               String str) {
        Map<String, Character> str2ch = new HashMap<>();
        Map<Character, String> ch2str = new HashMap<>();
        int len = str.length();
        int i = 0;
        for (int p = 0; p < pattern.length(); p++) {
            char c = pattern.charAt(p);
            if (i >= len) {
                return false;
            }
            int j = i;
            while (j < len && str.charAt(j) != ' ') {
                j++;
            }
            String tmp = str.substring(i,
                                       j);
            if (str2ch.containsKey(tmp) && str2ch.get(tmp) != c) {
                return false;
            }
            if (ch2str.containsKey(c) && !tmp.equals(ch2str.get(c))) {
                return false;
            }
            str2ch.put(tmp,
                       c);
            ch2str.put(c,
                       tmp);
            i = j + 1;
        }
        return i >= len;
    }
    
    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";
        Lc290 lc290 = new Lc290();
        boolean res = lc290.wordPattern(pattern,
                                        s);
        System.out.println("res = " + res);
    }
}
