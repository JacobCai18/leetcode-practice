package com.jacobcai.cd;

import java.util.Arrays;

public class Lc338_3 {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }
    
    public static void main(String[] args) {
        Lc338_3 lc338_3 = new Lc338_3();
        int[] res = lc338_3.countBits(15);
        System.out.println("res = " + Arrays.toString(res));
    }
}
