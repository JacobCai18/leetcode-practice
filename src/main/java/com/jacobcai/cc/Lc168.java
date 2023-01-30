package com.jacobcai.cc;

public class Lc168 {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            sb.append((char) (--columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        Lc168 lc168 = new Lc168();
        String res = lc168.convertToTitle(701);
        System.out.println("res = " + res);
    }
}
