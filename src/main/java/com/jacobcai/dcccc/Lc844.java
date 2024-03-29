package com.jacobcai.dcccc;

public class Lc844 {
    public boolean backspaceCompare(String s,
                                    String t) {
        int i = s.length() - 1, j = t.length() - 1;
        int skipS = 0, skipT = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }
    
    public static void main(String[] args) {
        String s = "ab#c";
        String t = "ad#c";
        Lc844 lc844 = new Lc844();
        boolean res = lc844.backspaceCompare(s,
                                             t);
        System.out.println("res = " + res);
    }
}
