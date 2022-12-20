package com.jacobcai.cd;

import java.util.Arrays;

public class Lc338_2 {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            res[i] = res[i - highBit] + 1;
        }
        return res;
    }
    
    public static void main(String[] args) {
        Lc338_2 lc338_2 = new Lc338_2();
        int[] res = lc338_2.countBits(15);
        System.out.println("res = " + Arrays.toString(res));
    }
}
