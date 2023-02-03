package com.jacobcai.cc;

public class Lc149_2 {
    public int maxPoints(int[][] points) {
        int n = points.length;
        int res = 1;
        for (int i = 0; i < n; i++) {
            if (res >= n - i || res > n / 2) break;
            int[] x = points[i];
            for (int j = i + 1; j < n; j++) {
                int[] y = points[j];
                int ct = 2;
                for (int k = j + 1; k < n; k++) {
                    int[] p = points[k];
                    int s1 = (y[1] - x[1]) * (p[0] - y[0]);
                    int s2 = (p[1] - y[1]) * (y[0] - x[0]);
                    if (s1 == s2) ct++;
                }
                res = Math.max(res, ct);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Lc149_2 lc149 = new Lc149_2();
        int[][] points = {{1, 1},
                {3, 2},
                {5, 3},
                {4, 1},
                {2, 3},
                {1, 4}};
        int res = lc149.maxPoints(points);
        System.out.println("res = " + res);
    }
}
