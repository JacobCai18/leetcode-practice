package com.jacobcai.md;

import java.util.ArrayList;
import java.util.List;

public class Lc1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length, mx = 0;
        for (int c : candies) mx = Math.max(mx, c);
        List<Boolean> res = new ArrayList<>(n);
        for (int c : candies) res.add(c + extraCandies >= mx);
        return res;
    }

    public static void main(String[] args) {
        Lc1431 lc1431 = new Lc1431();
        int[] candies = {2, 3, 5, 1, 3};
        List<Boolean> res = lc1431.kidsWithCandies(candies, 3);
        System.out.println("res = " + res);
    }
}
