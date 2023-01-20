package com.jacobcai.cc;

public class Lc171 {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        for (char c : columnTitle.toCharArray())
            res = res * 26 + (c - 'A' + 1);
        return res;
    }

    public static void main(String[] args) {
        Lc171 lc171 = new Lc171();
        String columnTitle = "AB";
        int res = lc171.titleToNumber(columnTitle);
        System.out.println("res = " + res);
    }
}
