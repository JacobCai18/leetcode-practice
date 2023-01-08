package com.jacobcai.mdcccc;

import java.util.Arrays;

public class Lc1806 {
    public int reinitializePermutation(int n) {
        int[] perm = new int[n];
        int[] target = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
            target[i] = i;
        }
        int opt = 0;
        do {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                if ((i & 1) == 0) {
                    arr[i] = perm[i / 2];
                } else {
                    arr[i] = perm[n / 2 + (i - 1) / 2];
                }
            }
            perm = arr;
            opt++;
        } while (!Arrays.equals(perm,
                                target));
        return opt;
    }
    
    public static void main(String[] args) {
        Lc1806 lc1806 = new Lc1806();
        int res = lc1806.reinitializePermutation(4);
        System.out.println("res = " + res);
    }
}
