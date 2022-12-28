package com.jacobcai.mdccc;

public class Lc1750 {
    public int minimumLength(String s) {
        int len, le, ri;
        len = s.length();
        le = 0;
        ri = len - 1;
        while (le < ri && s.charAt(le) == s.charAt(ri)) {
            char c = s.charAt(le);
            while (le <= ri && s.charAt(le) == c) {
                le++;
            }
            while (le <= ri && s.charAt(ri) == c) {
                ri--;
            }
        }
        return ri - le + 1;
    }
    
    public static void main(String[] args) {
        String s = "cabaabac";
        Lc1750 lc1750 = new Lc1750();
        int res = lc1750.minimumLength(s);
        System.out.println("res = " + res);
    }
}
