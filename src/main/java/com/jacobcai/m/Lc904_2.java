package com.jacobcai.m;

public class Lc904_2 {
    public int totalFruit(int[] fruits) {
        // <type, occCnt>
        int[] map = new int[fruits.length];
        int le = 0, maxCnt = 0, typeCnt = 0;
        for (int ri = 0; ri < fruits.length; ri++) {
            if (map[fruits[ri]]++ == 0)
                typeCnt++;
            while (typeCnt > 2) {
                if (--map[fruits[le]] == 0)
                    typeCnt--;
                le++;
            }
            maxCnt = Math.max(maxCnt, ri - le + 1);
        }
        return maxCnt;
    }

    public static void main(String[] args) {
        Lc904_2 lc904_2 = new Lc904_2();
        int[] fruits = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        int res = lc904_2.totalFruit(fruits);
        System.out.println("res = " + res);
    }
}
