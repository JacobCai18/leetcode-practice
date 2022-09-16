package com.jacobcai.d;

import java.util.Arrays;

public class Lc455 {
    public int findContentChildren(int[] g,
                                   int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        for (int num : s) {
            if (res < g.length && num >= g[res]) {
                res++;
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] g = {2, 3};
        int[] s = {1, 2, 3};
        Lc455 lc455 = new Lc455();
        int res = lc455.findContentChildren(g,
                                            s);
        System.out.println("res = " + res);
    }
}
