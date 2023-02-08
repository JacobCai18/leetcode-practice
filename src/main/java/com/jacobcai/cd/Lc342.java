package com.jacobcai.cd;

public class Lc342 {
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;
    }

    public static void main(String[] args) {
        Lc342 lc342 = new Lc342();
        boolean res = lc342.isPowerOfFour(16);
        System.out.println("res = " + res);
    }
}
