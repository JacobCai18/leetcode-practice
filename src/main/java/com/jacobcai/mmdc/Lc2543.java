package com.jacobcai.mmdc;

public class Lc2543 {
    private int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    public boolean isReachable(int targetX, int targetY) {
        int g = gcd(targetX, targetY);
        return (g & (g - 1)) == 0;
    }

    public static void main(String[] args) {
        Lc2543 lc2543 = new Lc2543();
        boolean res = lc2543.isReachable(4, 7);
        System.out.println("res = " + res);
    }
}
