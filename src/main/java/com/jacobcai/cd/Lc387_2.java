package com.jacobcai.cd;

public class Lc387_2 {
    public int firstUniqChar(String s) {
        int[] map = new int[26];
        char[] sc = s.toCharArray();
        for (char c : sc) {
            map[c - 'a']++;
        }
        for (int i = 0; i < sc.length; i++) {
            if (map[sc[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        String s = "abcdabc";
        Lc387_2 lc387_2 = new Lc387_2();
        int res = lc387_2.firstUniqChar(s);
        System.out.println("res = " + res);
    }
}
