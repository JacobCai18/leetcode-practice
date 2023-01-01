package com.jacobcai.mmcd;

public class Lc2351_2 {
    public char repeatedCharacter(String s) {
        int mask = 0;
        for (char c : s.toCharArray()) {
            if ((mask >> (c - 'a') & 1) == 1) {
                return c;
            }
            mask |= 1 << (c - 'a');
        }
        return ' ';
    }
    
    public static void main(String[] args) {
        String s = "abccbaacz";
        Lc2351_2 lc2351_2 = new Lc2351_2();
        char res = lc2351_2.repeatedCharacter(s);
        System.out.println("res = " + res);
    }
}
