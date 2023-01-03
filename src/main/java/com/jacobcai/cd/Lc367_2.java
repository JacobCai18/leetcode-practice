package com.jacobcai.cd;

public class Lc367_2 {
    public boolean isPerfectSquare(int num) {
        double x0 = num;
        while (true) {
            double x1 = (x0 + num / x0) / 2;
            if (x0 - x1 < 1e-6) {
                break;
            }
            x0 = x1;
        }
        int x = (int) x0;
        return x * x == num;
    }
    
    public static void main(String[] args) {
        int num = 16;
        Lc367_2 lc367_2 = new Lc367_2();
        boolean res = lc367_2.isPerfectSquare(num);
        System.out.println("res = " + res);
    }
}
