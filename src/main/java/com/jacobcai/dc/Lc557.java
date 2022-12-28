package com.jacobcai.dc;

public class Lc557 {
    public String reverseWords(String s) {
        int len, le, ri;
        len = s.length();
        le = ri = 0;
        StringBuilder sb = new StringBuilder(s);
        while (le < len) {
            while (ri < len && s.charAt(ri) != ' ') {
                ri++;
            }
            reverse(s,
                    sb,
                    le,
                    ri - 1);
            le = ++ri;
        }
        return sb.toString();
    }
    
    private void reverse(String s,
                         StringBuilder sb,
                         int le,
                         int ri) {
        while (le < ri) {
            sb.setCharAt(le,
                         s.charAt(ri));
            sb.setCharAt(ri,
                         s.charAt(le));
            le++;
            ri--;
        }
    }
    
    public static void main(String[] args) {
        String s = "I have a plan";
        Lc557 lc557 = new Lc557();
        String res = lc557.reverseWords(s);
        System.out.println("res = " + res);
    }
}
