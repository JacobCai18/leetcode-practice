package com.jacobcai;

public class Lc50_2 {
    // 快速幂+迭代
    public double myPow(double x,
                        int n) {
        return n >= 0 ?
               quickMul(x,
                        n) :
               1.0 / quickMul(x,
                              -(long) n);
    }
    
    private double quickMul(double x,
                            long n) {
        double res = 1.0;
        double x_contribute = x;
        // 对N进行二进制拆分
        // e.g. 十进制10 == 二进制1010，x^10 == (x^2)^1 * (x^2)^3
        while (n > 0) {
            if (n % 2 == 1) {
                res *= x_contribute;
            }
            x_contribute *= x_contribute;
            n >>= 1;
        }
        return res;
    }
    
    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        Lc50_2 lc50_2 = new Lc50_2();
        double res = lc50_2.myPow(x,
                                  n);
        System.out.println("res = " + res);
    }
}
