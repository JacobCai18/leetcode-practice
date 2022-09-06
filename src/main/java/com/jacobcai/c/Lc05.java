package com.jacobcai.c;

public class Lc05 {
    public String longestPalindrome(String s) {
        int le = 0;
        int ri = 0;
        int len = 1;
        for (int i = 0; i < s.length(); i++) {
            int len1, len2, curr;
            // 以一个char为中心
            len1 = expandFromMid(i,
                                 i,
                                 s);
            // 以两个相同的char为中心
            len2 = expandFromMid(i,
                                 i + 1,
                                 s);
            if (len < (curr = Math.max(len1,
                                       len2))) {
                len = curr;
                // 记录此时的左右，便于返回子串
                ri = i + len / 2;
                le = ri - len + 1;
            }
        }
        // [le, ri + 1)
        return s.substring(le,
                           ri + 1);
    }
    
    private int expandFromMid(int le,
                              int ri,
                              String s) {
        int len = 1;
        while (le >= 0 && ri < s.length() && s.charAt(le) == s.charAt(ri)) {
            len = ri - le + 1;
            le--;
            ri++;
        }
        return len;
    }
    
    public static void main(String[] args) {
        String s = "bab";
        Lc05 lc05 = new Lc05();
        String res = lc05.longestPalindrome(s);
        System.out.println("res = " + res);
    }
}
