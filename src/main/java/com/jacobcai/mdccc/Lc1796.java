package com.jacobcai.mdccc;

public class Lc1796 {
    public int secondHighest(String s) {
        int first, second;
        first = second = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int num = ch - '0';
                if (num > first) {
                    second = first;
                    first = num;
                } else if (num > second && num < first) {
                    second = num;
                }
            }
        }
        return second;
    }
    
    public static void main(String[] args) {
        String s = "dfa12321afd";
        Lc1796 lc1796 = new Lc1796();
        int res = lc1796.secondHighest(s);
        System.out.println("res = " + res);
    }
}
