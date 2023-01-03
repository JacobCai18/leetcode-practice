package com.jacobcai.mcc;

import java.util.Arrays;

public class Lc1109_2 {
    public int[] corpFlightBookings(int[][] bookings,
                                    int n) {
        int[] res = new int[n];
        for (int[] b : bookings) {
            res[b[0] - 1] += b[2];
            if (b[1] < n) {
                res[b[1]] -= b[2];
            }
        }
        for (int i = 1; i < n; i++) {
            res[i] += res[i - 1];
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[][] bookings = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int n = 5;
        Lc1109_2 lc1109 = new Lc1109_2();
        int[] res = lc1109.corpFlightBookings(bookings,
                                              n);
        System.out.println("res = " + Arrays.toString(res));
    }
}
