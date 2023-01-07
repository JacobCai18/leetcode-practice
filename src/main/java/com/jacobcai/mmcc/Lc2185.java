package com.jacobcai.mmcc;

public class Lc2185 {
    public int prefixCount(String[] words,
                           String pref) {
        int cnt = 0;
        int prefLen = pref.length();
        for (String word : words) {
            if (word.length() < prefLen)
                continue;
            int i = 0;
            for (; i < prefLen; i++)
                if (word.charAt(i) != pref.charAt(i))
                    break;
            if (i == prefLen) cnt++;
        }
        return cnt;
    }
    
    public static void main(String[] args) {
        String[] words = {"pay", "attention", "practice", "attend"};
        String pref = "at";
        Lc2185 lc2185 = new Lc2185();
        int res = lc2185.prefixCount(words,
                                     pref);
        System.out.println("res = " + res);
    }
}
