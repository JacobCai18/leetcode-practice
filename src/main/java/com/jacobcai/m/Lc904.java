package com.jacobcai.m;

import java.util.HashMap;
import java.util.Map;

public class Lc904 {
    public int totalFruit(int[] fruits) {
        // <type, occCnt>
        Map<Integer, Integer> map = new HashMap<>();
        int le = 0, maxCnt = 0;
        for (int ri = 0; ri < fruits.length; ri++) {
            map.put(fruits[ri], map.getOrDefault(fruits[ri], 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[le], map.get(fruits[le]) - 1);
                if (map.get(fruits[le]) == 0)
                    map.remove(fruits[le]);
                le++;
            }
            maxCnt = Math.max(maxCnt, ri - le + 1);
        }
        return maxCnt;
    }

    public static void main(String[] args) {
        Lc904 lc904 = new Lc904();
        int[] fruits = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        int res = lc904.totalFruit(fruits);
        System.out.println("res = " + res);
    }
}
