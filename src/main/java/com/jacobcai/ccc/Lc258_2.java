package com.jacobcai.ccc;

public class Lc258_2 {
    public int addDigits(int num) {
        while (num > 9) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

    public static void main(String[] args) {
        Lc258_2 lc258_2 = new Lc258_2();
        int res = lc258_2.addDigits(38);
        System.out.println("res = " + res);
    }
}
