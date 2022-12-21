package com.jacobcai.mdccc;

import java.util.Arrays;

public class Lc1753 {
    public int maximumScore(int a,
                            int b,
                            int c) {
        int[] v = {a, b, c};
        Arrays.sort(v);
        if (v[0] + v[1] <= v[2]) {
            return v[0] + v[1];
        } else {
            return (v[0] + v[1] + v[2]) / 2;
        }
    }
    
    public static void main(String[] args) {
        Lc1753 lc1753 = new Lc1753();
        int res = lc1753.maximumScore(2,
                                      4,
                                      6);
        System.out.println("res = " + res);
    }
}
