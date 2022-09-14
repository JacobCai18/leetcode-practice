package com.jacobcai.c;

import java.util.Arrays;

public class Lc60 {
    public String getPermutation(int n,
                                 int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; ++i) {
            factorial[i] = factorial[i - 1] * i;
        }
        --k;
        StringBuilder res = new StringBuilder();
        int[] valid = new int[n + 1];
        Arrays.fill(valid,
                    1);
        for (int i = 1; i <= n; ++i) {
            int order = k / factorial[n - i] + 1;
            for (int j = 1; j <= n; ++j) {
                order -= valid[j];
                if (order == 0) {
                    res.append(j);
                    valid[j] = 0;
                    break;
                }
            }
            k %= factorial[n - i];
        }
        return res.toString();
    }
    
    public static void main(String[] args) {
        int n = 4;
        int k = 9;
        Lc60 lc60 = new Lc60();
        String res = lc60.getPermutation(n,
                                         k);
        System.out.println("res = " + res);
    }
}
