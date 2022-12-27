package com.jacobcai.cd;

public class Lc392 {
    public boolean isSubsequence(String s,
                                 String t) {
        int ps, pt;
        ps = pt = 0;
        while (ps < s.length() && pt < t.length()) {
            if (s.charAt(ps) == t.charAt(pt)) {
                ps++;
            }
            pt++;
        }
        return ps == s.length();
    }
    
    public static void main(String[] args) {
        String s = "ace";
        String t = "abcde";
        Lc392 lc392 = new Lc392();
        boolean res = lc392.isSubsequence(s,
                                          t);
        System.out.println("res = " + res);
    }
}
