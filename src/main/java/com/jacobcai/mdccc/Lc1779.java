package com.jacobcai.mdccc;

public class Lc1779 {
    public int nearestValidPoint(int x,
                                 int y,
                                 int[][] points) {
        int len = points.length;
        int minDist = 0x3f3f3f3f;
        int res = -1;
        for (int i = 0; i < len; i++) {
            int px = points[i][0];
            int py = points[i][1];
            if (x == px) {
                int dist = Math.abs(y - py);
                if (dist < minDist) {
                    minDist = dist;
                    res = i;
                }
            } else if (y == py) {
                int dist = Math.abs(x - px);
                if (dist < minDist) {
                    minDist = dist;
                    res = i;
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[][] points = {{1, 2}, {3, 1}, {2, 4}, {2, 3}, {4, 4}};
        Lc1779 lc1779 = new Lc1779();
        int res = lc1779.nearestValidPoint(3,
                                           4,
                                           points);
        System.out.println("res = " + res);
    }
}
