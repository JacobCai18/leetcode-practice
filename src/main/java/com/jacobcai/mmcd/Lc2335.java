package com.jacobcai.mmcd;

import java.util.Arrays;

public class Lc2335 {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        if (amount[2] > amount[1] + amount[0]) return amount[2];
        return (amount[0] + amount[1] + amount[2] + 1) / 2;
    }

    public static void main(String[] args) {
        Lc2335 lc2335 = new Lc2335();
        int[] amount = {1, 4, 2};
        int res = lc2335.fillCups(amount);
        System.out.println("res = " + res);
    }
}
