package com.jacobcai.cd;

public class Lc383 {
    public boolean canConstruct(String ransomNote,
                                String magazine) {
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (--cnt[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        Lc383 lc383 = new Lc383();
        boolean res = lc383.canConstruct(ransomNote,
                                         magazine);
        System.out.println("res = " + res);
    }
}
