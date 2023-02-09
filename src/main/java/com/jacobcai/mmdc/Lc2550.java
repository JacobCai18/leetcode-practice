package com.jacobcai.mmdc;

public class Lc2550 {
    private static final int MOD = (int) 1e9 + 7;

    private int pow(long x, int n) {
        int res = 1;
        while (n > 0) {
            if ((n & 1) == 1) res = (int) (res * x % MOD);
            x = x * x % MOD;
            n >>= 1;
        }
        return res;
    }

    public int monkeyMove(int n) {
        return (pow(2, n) - 2 + MOD) % MOD;
    }

    public static void main(String[] args) {
        Lc2550 lc2550 = new Lc2550();
        int res = lc2550.monkeyMove(4);
        System.out.println("res = " + res);
    }
}
