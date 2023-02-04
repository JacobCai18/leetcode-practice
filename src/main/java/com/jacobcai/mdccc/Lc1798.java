package com.jacobcai.mdccc;

import java.util.Arrays;

public class Lc1798 {
    public int getMaximumConsecutive(int[] coins) {
        int res = 1;
        Arrays.sort(coins);
        for (var c : coins) {
            if (res < c) break;
            res += c;
        }
        return res;
    }

    public static void main(String[] args) {
        Lc1798 lc1798 = new Lc1798();
        int[] coins = {1, 2, 4, 6, 9};
        int res = lc1798.getMaximumConsecutive(coins);
        System.out.println("res = " + res);
    }
}
