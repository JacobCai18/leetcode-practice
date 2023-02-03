package com.jacobcai.ccc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc204_3 {
    public int countPrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) primes.add(i);
            for (var p : primes) {
                if (i * p >= n) break;
                isPrime[i * p] = false;
                if (i % p == 0) break; // 每个合数只被其最小质因数标记
            }
        }
        return primes.size();
    }

    public static void main(String[] args) {
        Lc204_3 lc204 = new Lc204_3();
        int res = lc204.countPrimes(10);
        System.out.println("res = " + res);
    }
}
