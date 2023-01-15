package com.jacobcai.ccc;

public class Lc258 {
    public int addDigits(int num) {
        if (num < 10) return num;
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return addDigits(sum);
    }

    public static void main(String[] args) {
        Lc258 lc258 = new Lc258();
        int res = lc258.addDigits(38);
        System.out.println("res = " + res);
    }
}
