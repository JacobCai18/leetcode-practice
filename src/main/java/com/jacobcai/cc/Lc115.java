package com.jacobcai.cc;

public class Lc115 {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) return 0;
        char[] sc = s.toCharArray(), tc = t.toCharArray();
        int[][] f = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) f[i][0] = 1;
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                if (sc[i - 1] == tc[j - 1])
                    f[i][j] = f[i - 1][j - 1] + f[i - 1][j];
                else
                    f[i][j] = f[i - 1][j];
        return f[m][n];
    }

    public static void main(String[] args) {
        Lc115 lc115 = new Lc115();
        String s = "rabbbit";
        String t = "rabbit";
        int res = lc115.numDistinct(s, t);
        System.out.println("res = " + res);
    }
}
