package com.jacobcai.mmcc;

public class Lc2185_2 {
    public int prefixCount(String[] words,
                           String pref) {
        int cnt = 0;
        for (String word : words)
            if (word.startsWith(pref))
                cnt++;
        return cnt;
    }
    
    public static void main(String[] args) {
        String[] words = {"pay", "attention", "practice", "attend"};
        String pref = "at";
        Lc2185_2 lc2185_2 = new Lc2185_2();
        int res = lc2185_2.prefixCount(words,
                                     pref);
        System.out.println("res = " + res);
    }
}
