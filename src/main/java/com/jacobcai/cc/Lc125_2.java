package com.jacobcai.cc;

public class Lc125_2 {
    public boolean isPalindrome(String s) {
        int len, le, ri;
        len = s.length();
        le = 0;
        ri = len - 1;
        while (le < ri) {
            while (le < ri && !Character.isLetterOrDigit(s.charAt(le))) {
                le++;
            }
            while (le < ri && !Character.isLetterOrDigit(s.charAt(ri))) {
                ri--;
            }
            if (le < ri) {
                if (Character.toLowerCase(s.charAt(le)) != Character.toLowerCase(s.charAt(ri))) {
                    return false;
                }
                le++;
                ri--;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        Lc125_2 lc125_2 = new Lc125_2();
        boolean res = lc125_2.isPalindrome(s);
        System.out.println("res = " + res);
    }
}
