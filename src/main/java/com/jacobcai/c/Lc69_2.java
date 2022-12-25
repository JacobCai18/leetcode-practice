package com.jacobcai.c;

public class Lc69_2 {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        double x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + (double) x / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }
    
    public static void main(String[] args) {
        Lc69_2 lc69 = new Lc69_2();
        int res = lc69.mySqrt(8);
        System.out.println("res = " + res);
    }
}
