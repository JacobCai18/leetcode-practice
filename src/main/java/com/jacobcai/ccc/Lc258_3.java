package com.jacobcai.ccc;

public class Lc258_3 {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }

    public static void main(String[] args) {
        Lc258_3 lc258_3 = new Lc258_3();
        int res = lc258_3.addDigits(38);
        System.out.println("res = " + res);
    }
}
