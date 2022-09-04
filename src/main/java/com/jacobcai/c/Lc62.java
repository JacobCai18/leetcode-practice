package com.jacobcai.c;

public class Lc62 {
    public int uniquePaths(int m,
                           int n) {
        int a, b;
        if (m > n) {
            a = m;
            b = n;
        } else {
            a = n;
            b = m;
        }
        int[] dp = new int[b];
        for (int j = 0; j < b; j++) {
            dp[j] = 1;
        }
        for (int i = 1; i < a; i++) {
            for (int j = 1; j < b; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[b - 1];
    }
    
    public static void main(String[] args) {
        int m, n;
        m = 3;
        n = 7;
        Lc62 lc62 = new Lc62();
        int res = lc62.uniquePaths(m,
                                   n);
        System.out.println("res = " + res);
    }
}
