package com.jacobcai.mmcd;

public class Lc2351 {
    public char repeatedCharacter(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            if (++cnt[c - 'a'] == 2) {
                return c;
            }
        }
        return ' ';
    }
    
    public static void main(String[] args) {
        String s = "abccbaacz";
        Lc2351 lc2351 = new Lc2351();
        char res = lc2351.repeatedCharacter(s);
        System.out.println("res = " + res);
    }
}
