package com.jacobcai.dcc;

public class Lc680 {
    public boolean validPalindrome(String s) {
        int le, ri;
        le = 0;
        ri = s.length() - 1;
        while (le < ri) {
            if (s.charAt(le) == s.charAt(ri)) {
                le++;
                ri--;
            } else {
                return validPalindrome(s, le, ri - 1) || validPalindrome(s, le + 1, ri);
            }
        }
        return true;
    }
    
    private boolean validPalindrome(String s,
                                    int le,
                                    int ri) {
        for (int i = le, j = ri; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        String s = "abca";
        Lc680 lc680 = new Lc680();
        boolean res = lc680.validPalindrome(s);
        System.out.println("res = " + res);
    }
}
