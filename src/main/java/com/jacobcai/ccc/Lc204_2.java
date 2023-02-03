package com.jacobcai.ccc;

import java.util.Arrays;

public class Lc204_2 {
    public int countPrimes(int n) {
        int res = 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                res++;
                if ((long) i * i < n)
                    for (int j = i * i; j < n; j += i)
                        isPrime[j] = false; // i 的倍数不可能是质数
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Lc204_2 lc204 = new Lc204_2();
        int res = lc204.countPrimes(10);
        System.out.println("res = " + res);
    }
}
