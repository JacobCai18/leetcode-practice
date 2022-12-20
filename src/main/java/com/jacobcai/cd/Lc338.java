package com.jacobcai.cd;

import java.util.Arrays;

public class Lc338 {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = countOnes(i);
        }
        return res;
    }
    
    private int countOnes(int i) {
        int ones = 0;
        while (i > 0) {
            // Brian Kernighan: 将 i 二进制表示的最后一个 1 变为 0
            i &= (i - 1);
            ones++;
        }
        return ones;
    }
    
    public static void main(String[] args) {
        Lc338 lc338 = new Lc338();
        int[] res = lc338.countBits(15);
        System.out.println("res = " + Arrays.toString(res));
    }
}
