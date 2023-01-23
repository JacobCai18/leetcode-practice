package com.jacobcai.mmcd;

public class Lc2303 {
    public double calculateTax(int[][] brackets, int income) {
        double tax = 0;
        int pre = 0;
        for (int[] b : brackets) {
            int cur = b[0], percent = b[1];
            if (cur < income) {
                tax += (cur - pre) * percent;
                pre = cur;
            } else {
                tax += (income - pre) * percent;
                break;
            }
        }
        return tax / 100.0;
    }

    public static void main(String[] args) {
        Lc2303 lc2303 = new Lc2303();
        int[][] brackets = {{3, 50}, {7, 10}, {12, 25}};
        int income = 10;
        double res = lc2303.calculateTax(brackets, income);
        System.out.println("res = " + res);
    }
}
