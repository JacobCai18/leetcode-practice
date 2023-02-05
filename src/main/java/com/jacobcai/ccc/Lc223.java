package com.jacobcai.ccc;

public class Lc223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int x, y;
        x = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));
        y = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));
        return (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1) - x * y;
    }

    public static void main(String[] args) {
        Lc223 lc223 = new Lc223();
        int res = lc223.computeArea(-3, 0, 3, 4, 0, -1, 9, 2);
        System.out.println("res = " + res);
    }
}
