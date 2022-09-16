package com.jacobcai.d;

import java.util.Arrays;

public class Lc452_2 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,
                    (o1, o2) -> {
                        if (o1[1] == o2[1]) {
                            return 0;
                        }
                        return o1[1] < o2[1] ?
                               -1 :
                               1;
                    });
        int ri = points[0][1];
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            if (ri < points[i][0]) {
                ri = points[i][1];
                count++;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        int[][] points = {{1, 6}, {2, 8}, {7, 12}, {10, 16}};
        Lc452_2 lc452_2 = new Lc452_2();
        int res = lc452_2.findMinArrowShots(points);
        System.out.println("res = " + res);
    }
}
