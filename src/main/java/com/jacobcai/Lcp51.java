package com.jacobcai;

public class Lcp51 {
    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        int ans = -1;
        for (int i = 0; i < 1 << cookbooks.length; i++) {
            int[] sum = new int[5];
            int x = 0, y = 0;
            for (int j = 0; j < cookbooks.length; j++) {
                if ((i >> j & 1) == 1) {
                    for (int k = 0; k < 5; k++) {
                        sum[k] += cookbooks[j][k];
                    }
                    x += attribute[j][0];
                    y += attribute[j][1];
                }
            }
            boolean flag = y >= limit;
            for (int j = 0; j < 5; j++) {
                if (sum[j] > materials[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) ans = Math.max(ans, x);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] materials = {10, 10, 10, 10, 10};
        int[][] cookbooks = {{1, 1, 1, 1, 1}, {3, 3, 3, 3, 3}, {10, 10, 10, 10, 10}};
        int[][] attribute = {{5, 5}, {6, 6}, {10, 10}};
        int limit = 1;
        Lcp51 solutions = new Lcp51();
        int ans = solutions.perfectMenu(materials, cookbooks, attribute, limit);
        System.out.println(ans);
    }
}
