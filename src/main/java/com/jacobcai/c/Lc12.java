package com.jacobcai.c;

public class Lc12 {
    public String intToRoman(int num) {
        int[] ns = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ns.length; ++i) {
            while (num >= ns[i]) {
                sb.append(romans[i]);
                num -= ns[i];
            }
            if (num == 0) {
                break;
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        int num = 1994;
        Lc12 lc12 = new Lc12();
        String res = lc12.intToRoman(num);
        System.out.println("res = " + res);
    }
}
