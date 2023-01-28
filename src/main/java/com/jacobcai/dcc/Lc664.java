package com.jacobcai.dcc;

public class Lc664 {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] f = new int[n][n];
        for (int j = 0; j < n; j++) {
            f[j][j] = 1;
            for (int i = j - 1; i > -1; i--) {
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i][j - 1];
                } else {
                    int minn = Integer.MAX_VALUE;
                    for (int k = j; k > i; k--)
                        minn = Math.min(minn, f[i][k - 1] + f[k][j]);
                    f[i][j] = minn;
                }
            }
        }
        return f[0][n - 1];
    }

    public static void main(String[] args) {
        Lc664 lc664 = new Lc664();
        String s = "aabbaabb";
        int res = lc664.strangePrinter(s);
        System.out.println("res = " + res);
    }
}
