package com.jacobcai.c;

public class Lc70 {
    public int climbStairs(int n) {
        if (n < 2) {
            return 1;
        }
        int a, b, c;
        a = 1;
        b = 2;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
    
    public static void main(String[] args) {
        int n = 3;
        Lc70 lc70 = new Lc70();
        int res = lc70.climbStairs(n);
        System.out.println("res = " + res);
    }
}
