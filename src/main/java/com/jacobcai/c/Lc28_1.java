package com.jacobcai.c;

public class Lc28_1 {
    public int strStr(String haystack,
                      String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i + m <= n; i++) {
            boolean flag = true;
            // 只要无法完全匹配needle中的所有char，则break
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        Lc28_1 lc28_1 = new Lc28_1();
        int res = lc28_1.strStr(haystack,
                                needle);
        System.out.println("res = " + res);
    }
}
