package com.jacobcai.ccc;

public class Lc204 { // 超时
    private boolean isPrime(int x) {
        for (int i = 2; i * i <= x; i++)
            if (x % i == 0)
                return false;
        return true;
    }

    public int countPrimes(int n) {
        int res = 0;
        for (int i = 2; i < n; i++)
            if (isPrime(i))
                res++;
        return res;
    }

    public static void main(String[] args) {
        Lc204 lc204 = new Lc204();
        int res = lc204.countPrimes(10);
        System.out.println("res = " + res);
    }
}
