package com.jacobcai.ccc;

public class Lc263 {
    public boolean isUgly(int n) {
        if (n <= 0) return false;
        while (n % 2 == 0) n /= 2;
        while (n % 3 == 0) n /= 3;
        while (n % 5 == 0) n /= 5;
        return n == 1;
    }

    public static void main(String[] args) {
        Lc263 lc263 = new Lc263();
        boolean res = lc263.isUgly(6);
        System.out.println("res = " + res);
    }
}
