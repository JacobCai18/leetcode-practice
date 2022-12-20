package com.jacobcai.cd;

import java.util.Arrays;

public class Lc344 {
    public void reverseString(char[] s) {
        int len, le, ri;
        len = s.length;
        le = 0;
        ri = len - 1;
        while (le < ri) {
            swap(le++,
                 ri--,
                 s);
        }
    }
    
    private void swap(int le,
                      int ri,
                      char[] s) {
        char tmp = s[le];
        s[le] = s[ri];
        s[ri] = tmp;
    }
    
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        Lc344 lc344 = new Lc344();
        lc344.reverseString(s);
        System.out.println("s = " + Arrays.toString(s));
    }
}
