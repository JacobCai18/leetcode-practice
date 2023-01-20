package com.jacobcai.mcc;

public class Lc1154 {
    public int dayOfYear(String date) {
        int y = Integer.parseInt(date.substring(0, 4));
        int m = Integer.parseInt(date.substring(5, 7));
        int d = Integer.parseInt(date.substring(8));
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (y % 400 == 0 || (y % 4 == 0 && y % 100 != 0)) months[1]++;
        int ans = 0;
        for (int i = 0; i < m - 1; i++) ans += months[i];
        return ans + d;
    }

    public static void main(String[] args) {
        Lc1154 lc1154 = new Lc1154();
        String date = "2023-01-21";
        int res = lc1154.dayOfYear(date);
        System.out.println("res = " + res);
    }
}
