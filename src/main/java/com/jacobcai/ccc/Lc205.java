package com.jacobcai.ccc;

public class Lc205 {
    public boolean isIsomorphic(String s,
                                String t) {
        int[] s2t = new int[128];
        int[] t2s = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if ((s2t[a] != 0 && s2t[a] != b) || (t2s[b] != 0 && t2s[b] != a)) {
                return false;
            }
            s2t[a] = b;
            t2s[b] = a;
        }
        return true;
    }
    
    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        Lc205 lc205 = new Lc205();
        boolean res = lc205.isIsomorphic(s,
                                         t);
        System.out.println("res = " + res);
    }
}
