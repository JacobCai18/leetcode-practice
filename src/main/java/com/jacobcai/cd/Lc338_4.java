package com.jacobcai.cd;

import java.util.Arrays;

public class Lc338_4 {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }
    
    public static void main(String[] args) {
        Lc338_4 lc338_4 = new Lc338_4();
        int[] res = lc338_4.countBits(15);
        System.out.println("res = " + Arrays.toString(res));
    }
}
