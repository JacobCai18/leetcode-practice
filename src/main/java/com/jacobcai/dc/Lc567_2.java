package com.jacobcai.dc;

public class Lc567_2 {
    public boolean checkInclusion(String s1,
                                  String s2) {
        int le, ri;
        int[] cnt = new int[26];
        le = ri = 0;
        for (char c : s1.toCharArray()) {
            cnt[c - 'a']--;
        }
        while (ri < s2.length()) {
            int riIndex = s2.charAt(ri++) - 'a';
            cnt[riIndex]++;
            while (cnt[riIndex] > 0) {
                cnt[s2.charAt(le++) - 'a']--;
            }
            if (ri - le == s1.length()) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "dbac";
        Lc567_2 lc567_2 = new Lc567_2();
        boolean res = lc567_2.checkInclusion(s1,
                                             s2);
        System.out.println("res = " + res);
    }
}
