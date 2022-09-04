package com.jacobcai.c;

public class Lc13 {
    public int romanToInt(String s) {
        if (s.length() == 1) {
            return getVal(s.charAt(0));
        }
        int p = s.length() - 2;
        int res = getVal(s.charAt(p + 1));
        while (p > -1) {
            if (getVal(s.charAt(p)) < getVal(s.charAt(p + 1))) {
                res -= getVal(s.charAt(p));
            } else {
                res += getVal(s.charAt(p));
            }
            p--;
        }
        return res;
    }
    
    private int getVal(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
    
    public static void main(String[] args) {
        String s = "MCMXCIV";
        Lc13 solution = new Lc13();
        int a = solution.romanToInt(s);
        System.out.println(a);
    }
}


