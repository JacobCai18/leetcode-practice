package com.jacobcai.mdcccc;

import java.util.Arrays;

public class Lc1828 {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];
        int i = 0;
        for (int[] q : queries) {
            int x = q[0], y = q[1], r = q[2], cnt = 0;
            for (int[] p : points) {
                int xx = p[0], yy = p[1];
                int dis = (x - xx) * (x - xx) + (y - yy) * (y - yy);
                if (dis <= r * r) cnt++;
            }
            res[i++] = cnt;
        }
        return res;
    }

    public static void main(String[] args) {
        Lc1828 lc1828 = new Lc1828();
        int[][] points = {{1, 3}, {3, 3}, {5, 3}, {2, 2}};
        int[][] queries = {{2, 3, 1}, {4, 3, 1}, {1, 1, 2}};
        int[] res = lc1828.countPoints(points, queries);
        System.out.println("res = " + Arrays.toString(res));
    }
}
