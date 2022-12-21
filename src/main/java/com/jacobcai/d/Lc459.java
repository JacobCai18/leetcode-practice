package com.jacobcai.d;

public class Lc459 {
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }
    
    public static void main(String[] args) {
        String s = "abab";
        Lc459 lc459 = new Lc459();
        boolean res = lc459.repeatedSubstringPattern(s);
        System.out.println("res = " + res);
    }
}
