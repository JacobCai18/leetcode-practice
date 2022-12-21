package com.jacobcai.dcc;

public class Lc647 {
    private String s;
    private int cnt;
    
    public int countSubstrings(String s) {
        this.s = s;
        cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            expandFromMid(i,
                          i);
            expandFromMid(i,
                          i + 1);
        }
        return cnt;
    }
    
    private void expandFromMid(int i,
                               int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            cnt++;
            i--;
            j++;
        }
    }
    
    public static void main(String[] args) {
        String s = "aaa";
        Lc647 lc647 = new Lc647();
        int res = lc647.countSubstrings(s);
        System.out.println("res = " + res);
    }
}
