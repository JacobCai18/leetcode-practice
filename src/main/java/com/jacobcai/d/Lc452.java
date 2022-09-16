package com.jacobcai.d;

import java.util.Arrays;
import java.util.Comparator;

public class Lc452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,
                    Comparator.comparingInt(o -> o[1]));
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
        Lc452 lc452 = new Lc452();
        int res = lc452.findMinArrowShots(points);
        System.out.println("res = " + res);
    }
}
