package com.jacobcai.mcc;

import java.util.Arrays;

public class Lc1109 {
    public int[] corpFlightBookings(int[][] bookings,
                                    int n) {
        int[] res = new int[n];
        for (int[] b : bookings) {
            int first, last, seats;
            first = b[0];
            last = b[1];
            seats = b[2];
            for (int i = first - 1; i < last; i++) {
                res[i] += seats;
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[][] bookings = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int n = 5;
        Lc1109 lc1109 = new Lc1109();
        int[] res = lc1109.corpFlightBookings(bookings,
                                              n);
        System.out.println("res = " + Arrays.toString(res));
    }
}
