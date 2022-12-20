package com.jacobcai.cd;

public class Lc343 {
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int quotient = n / 3;
        int remainder = n % 3;
        if (remainder == 0) {
            return (int) Math.pow(3, quotient);
        } else if (remainder == 1) {
            return (int) Math.pow(3, quotient - 1) * 4;
        } else {
            return (int) Math.pow(3, quotient) * 2;
        }
    }
    
    public static void main(String[] args) {
        Lc343 lc343 = new Lc343();
        int res = lc343.integerBreak(10);
        System.out.println("res = " + res);
    }
}
