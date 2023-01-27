package com.jacobcai.mmcd;

public class Lc2306 {
    public String greatestLetter(String s) {
        int lower = 0, upper = 0;
        char[] cs = s.toCharArray();
        for (char c : cs)
            if (c >= 'a' && c <= 'z')
                lower |= 1 << (c - 'a');
            else
                upper |= 1 << (c - 'A');
        for (int i = 25; i > -1; i--)
            if ((lower & upper & (1 << i)) != 0) // 100000
                return String.valueOf((char) ('A' + i));
        return "";
    }

    public static void main(String[] args) {
        Lc2306 lc2306 = new Lc2306();
        String s = "arAzFif";
        String res = lc2306.greatestLetter(s);
        System.out.println("res = " + res);
    }
}
