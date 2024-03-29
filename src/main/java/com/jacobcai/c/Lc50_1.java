package com.jacobcai.c;

public class Lc50_1 {
    // 快速幂+递归
    public double myPow(double x, int n) {
        // 如果用int，n取Integer.MIN_VALUE时-n会越界
        return n >= 0 ? quickMul(x, n) : 1.0 / quickMul(x, -(long) n);
    }
    
    private double quickMul(double x, long n) {
        if (n == 0) return 1.0;
        double y = quickMul(x, n / 2);
        return (n & 1) == 1 ? y * y : y * y * x;
    }
    
    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        Lc50_1 lc50_1 = new Lc50_1();
        double res = lc50_1.myPow(x, n);
        System.out.println("res = " + res);
    }
}
