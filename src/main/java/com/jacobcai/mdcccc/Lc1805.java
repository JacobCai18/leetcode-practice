package com.jacobcai.mdcccc;

import java.util.HashSet;
import java.util.Set;

public class Lc1805 {
    public int numDifferentIntegers(String word) {
        int len, le, ri;
        len = word.length();
        le = 0;
        Set<String> set = new HashSet<>();
        while (true) {
            // le 去到第一个数字
            while (le < len && !Character.isDigit(word.charAt(le))) {
                le++;
            }
            if (le == len) {
                break;
            }
            // ri 从第一个数字开始去到第一个字母
            ri = le;
            while (ri < len && Character.isDigit(word.charAt(ri))) {
                ri++;
            }
            // 数字长度至少为 1 的情况下，le 去到第一个非 0 数字
            while (ri - le > 1 && word.charAt(le) == '0') {
                le++;
            }
            set.add(word.substring(le,
                                   ri));
            le = ri;
        }
        return set.size();
    }
    
    public static void main(String[] args) {
        String word = "a123bc34d8ef34";
        Lc1805 lc1805 = new Lc1805();
        int res = lc1805.numDifferentIntegers(word);
        System.out.println("res = " + res);
    }
}
