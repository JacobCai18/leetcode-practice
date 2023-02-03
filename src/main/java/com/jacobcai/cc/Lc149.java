package com.jacobcai.cc;

import java.util.HashMap;
import java.util.Map;

public class Lc149 {
    private int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (res >= n - i || res > n / 2) break;
            Map<Integer, Integer> mp = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                if (x == 0) {
                    y = 1;
                } else if (y == 0) {
                    x = 1;
                } else {
                    if (y < 0) {
                        x = -x;
                        y = -y;
                    }
                    int gcdXY = gcd(Math.abs(x), Math.abs(y));
                    x /= gcdXY;
                    y /= gcdXY;
                }
                int key = y + x * 20001;
                mp.put(key, mp.getOrDefault(key, 0) + 1);
            }
            int mx = 0;
            for (var v : mp.values())
                mx = Math.max(mx, v + 1);
            res = Math.max(res, mx);
        }
        return res;
    }

    public static void main(String[] args) {
        Lc149 lc149 = new Lc149();
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
