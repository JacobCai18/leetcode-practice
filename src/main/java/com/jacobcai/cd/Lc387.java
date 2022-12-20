package com.jacobcai.cd;

import java.util.Arrays;

public class Lc387 {
    public int firstUniqChar(String s) {
        int[] map = new int[26];
        Arrays.fill(map, -1);
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (map[index] == -1) {
                map[index] = i;
            } else if (map[index] != -2) {
                map[index] = -2;
            }
        }
        int index = s.length();
        for (int i : map) {
            if (i != -1 && i != -2) {
                index = Math.min(index, i);
            }
        }
        return index == s.length() ? -1 : index;
    }
    
    public static void main(String[] args) {
        String s = "abcdabc";
        Lc387 lc387 = new Lc387();
        int res = lc387.firstUniqChar(s);
        System.out.println("res = " + res);
    }
}
