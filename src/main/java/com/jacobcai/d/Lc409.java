package com.jacobcai.d;

public class Lc409 {
    public int longestPalindrome(String s) {
        int[] cnt = new int[128];
        for (char c : s.toCharArray()) {
            cnt[c]++;
        }
        int res = 0;
        for (int v : cnt) {
            res += v / 2 * 2;
        }
        return res < s.length() ?
               res + 1 :
               res;
    }
    
    public static void main(String[] args) {
        String s = "abccccdd";
        Lc409 lc409 = new Lc409();
        int res = lc409.longestPalindrome(s);
        System.out.println("res = " + res);
    }
}
