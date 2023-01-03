package com.jacobcai.cd;

public class Lc389 {
    public char findTheDifference(String s,
                                  String t) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            if (--cnt[c - 'a'] == -1) {
                return c;
            }
        }
        return ' ';
    }
    
    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        Lc389 lc389 = new Lc389();
        char res = lc389.findTheDifference(s,
                                           t);
        System.out.println("res = " + res);
    }
}
