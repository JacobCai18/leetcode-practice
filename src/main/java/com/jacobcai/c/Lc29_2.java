package com.jacobcai.c;

public class Lc29_2 {
    public int divide(int dividend,
                      int divisor) {
        int LIMIT = Integer.MIN_VALUE >> 1;
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        // 让正数变为负数
        boolean flag = false;
        if (dividend > 0) {
            dividend = -dividend;
            flag = true;
        }
        if (divisor > 0) {
            divisor = -divisor;
            flag = !flag;
        }
        int res = 0;
        while (dividend <= divisor) {
            // count * divisor = sum
            int sum, count;
            sum = divisor;
            count = -1;
            while (sum >= LIMIT && count >= LIMIT && sum >= dividend - sum) {
                sum <<= 1;
                count <<= 1;
            }
            dividend -= sum;
            res += count;
        }
        return flag ?
               res :
               -res;
    }
    
    public static void main(String[] args) {
        int dividend = 80;
        int divisor = 3;
        Lc29_2 lc29_2 = new Lc29_2();
        int res = lc29_2.divide(dividend,
                                divisor);
        System.out.println("res = " + res);
    }
}
