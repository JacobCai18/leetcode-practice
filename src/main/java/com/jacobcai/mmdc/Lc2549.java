package com.jacobcai.mmdc;

public class Lc2549 {
    public int distinctIntegers(int n) {
        return n == 1 ? 1 : n - 1;
    }

    public static void main(String[] args) {
        Lc2549 lc2549 = new Lc2549();
        int res = lc2549.distinctIntegers(5);
        System.out.println("res = " + res);
    }
}
