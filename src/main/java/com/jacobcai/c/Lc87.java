package com.jacobcai.c;

public class Lc87 {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        int n = s1.length();
        boolean[][][] f = new boolean[n][n][n + 1]; // i = s1 idx, j = s2 idx, k = len, f[i][j][k] = isScramble
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                f[i][j][1] = s1.charAt(i) == s2.charAt(j);
        for (int k = 2; k <= n; k++)
            for (int i = 0; i <= n - k; i++)
                for (int j = 0; j <= n - k; j++)
                    for (int m = 1; m < k; m++)
                        if (f[i][j][m] && f[i + m][j + m][k - m] || f[i][j + k - m][m] && f[i + m][j][k - m]) {
                            f[i][j][k] = true;
                            break;
                        }
        return f[0][0][n];
    }

    public static void main(String[] args) {
        Lc87 lc87 = new Lc87();
        String s1 = "great", s2 = "rgeat";
        boolean res = lc87.isScramble(s1, s2);
        System.out.println("res = " + res);
    }
}
