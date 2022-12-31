package com.jacobcai.mmc;

import java.util.Arrays;

public class Lc2037 {
    public int minMovesToSeat(int[] seats,
                              int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int res = 0;
        for (int i = 0; i < seats.length; i++) {
            res += Math.abs(seats[i] - students[i]);
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] seats = {12, 14, 19, 19, 12};
        int[] students = {19, 2, 17, 20, 7};
        Lc2037 lc2037 = new Lc2037();
        int res = lc2037.minMovesToSeat(seats,
                                        students);
        System.out.println("res = " + res);
    }
}
