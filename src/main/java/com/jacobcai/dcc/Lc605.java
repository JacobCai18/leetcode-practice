package com.jacobcai.dcc;

public class Lc605 {
    public boolean canPlaceFlowers(int[] flowerbed,
                                   int n) {
        int cnt = 0;
        int one = -2;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                if (i - one > 3) {
                    cnt += (i - one) / 2 - 1;
                }
                one = i;
            }
        }
        if (flowerbed.length + 1 - one > 3) {
            cnt += (flowerbed.length + 1 - one) / 2 - 1;
        }
        return cnt >= n;
    }
    
    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0};
        int n = 4;
        Lc605 lc605 = new Lc605();
        boolean res = lc605.canPlaceFlowers(flowerbed,
                                            n);
        System.out.println("res = " + res);
    }
}
