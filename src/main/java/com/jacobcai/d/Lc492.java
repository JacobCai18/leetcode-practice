package com.jacobcai.d;

import java.util.Arrays;

public class Lc492 {
    public int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);
        while (area % w != 0) w--;
        return new int[]{area / w, w};
    }

    public static void main(String[] args) {
        Lc492 lc492 = new Lc492();
        int[] res = lc492.constructRectangle(4);
        System.out.println("res = " + Arrays.toString(res));
    }
}
