package com.jacobcai.cc;

import java.util.Arrays;

public class Lc132 {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] pal = new boolean[n][n];
        for (int j = 0; j < n; j++)
            for (int i = j; i > -1; i--)
                pal[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || pal[i + 1][j - 1]);
        int[] f = new int[n];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int j = 0; j < n; j++) {
            if (pal[0][j]) {
                f[j] = 0;
                continue;
            }
            for (int i = j; i > 0; i--)
                if (pal[i][j])
                    f[j] = Math.min(f[j], f[i - 1] + 1);
        }
        return f[n - 1];
    }

    public static void main(String[] args) {
        Lc132 lc132 = new Lc132();
        String s = "aabb";
        int res = lc132.minCut(s);
        System.out.println("res = " + res);
    }
}
