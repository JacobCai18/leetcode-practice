package com.jacobcai.ccc;

public class Lc242 {
    public boolean isAnagram(String s,
                             String t) {
        int sLen, tLen;
        if ((sLen = s.length()) != (tLen = t.length())) {
            return false;
        }
        int[] map = new int[26];
        for (int i = 0; i < sLen; i++) {
            map[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < tLen; i++) {
            int v = --map[t.charAt(i) - 'a'];
            if (v < 0) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        String s = "abcdefg";
        String t = "gfedcba";
        Lc242 lc242 = new Lc242();
        boolean res = lc242.isAnagram(s,
                                      t);
        System.out.println("res = " + res);
    }
}
