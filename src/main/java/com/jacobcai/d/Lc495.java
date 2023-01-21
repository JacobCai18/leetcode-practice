package com.jacobcai.d;

public class Lc495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0, n = timeSeries.length;
        for (int i = 1; i < n; i++)
            res += Math.min(timeSeries[i] - timeSeries[i - 1], duration);
        return res + duration;
    }

    public static void main(String[] args) {
        Lc495 lc495 = new Lc495();
        int[] timeSeries = {1, 4};
        int res = lc495.findPoisonedDuration(timeSeries, 2);
        System.out.println("res = " + res);
    }
}
