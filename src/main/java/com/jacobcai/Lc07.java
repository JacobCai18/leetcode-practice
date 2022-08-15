package com.jacobcai;

public class Lc07 {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            // Integer.MIN_VALUE <= res * 10 + x % 10 <= Integer.MAX_VALUE
            if (res < Integer.MIN_VALUE / 10 || res > Integer.MAX_VALUE / 10) {
                return 0;
            }
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }
    
    public static void main(String[] args) {
        int x = 123;
        Lc07 lc07 = new Lc07();
        int res = lc07.reverse(x);
        System.out.println("res = " + res);
    }
}
