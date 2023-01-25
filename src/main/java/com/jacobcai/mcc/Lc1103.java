package com.jacobcai.mcc;

import java.util.Arrays;

public class Lc1103 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int i = 0;
        while (candies > i) {
            res[i % num_people] += ++i;
            candies -= i;
        }
        res[i % num_people] += candies;
        return res;
    }

    public static void main(String[] args) {
        Lc1103 lc1103 = new Lc1103();
        int[] res = lc1103.distributeCandies(7, 4);
        System.out.println("res = " + Arrays.toString(res));
    }
}
