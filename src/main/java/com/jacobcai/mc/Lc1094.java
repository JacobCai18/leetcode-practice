package com.jacobcai.mc;

public class Lc1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];
        for (var t : trips) {
            diff[t[1]] += t[0];
            diff[t[2]] -= t[0];
        }
        int sum = 0;
        for (var d : diff) {
            sum += d;
            if (sum > capacity) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Lc1094 lc1094 = new Lc1094();
        int[][] trips = {{2, 1, 5}, {3, 3, 7}};
        boolean res = lc1094.carPooling(trips, 4);
        System.out.println("res = " + res);
    }
}
