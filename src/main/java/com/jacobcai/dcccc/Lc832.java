package com.jacobcai.dcccc;

import java.util.Arrays;

public class Lc832 {
    public int[][] flipAndInvertImage(int[][] image) {
        int m = image.length, n = image[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0, k = n - 1; j <= k; j++, k--) {
                int tmp = image[i][j] ^ 1;
                image[i][j] = image[i][k] ^ 1;
                image[i][k] = tmp;
            }
        }
        return image;
    }

    public static void main(String[] args) {
        Lc832 lc832 = new Lc832();
        int[][] image = {{1, 1, 0},
                {1, 0, 1},
                {0, 0, 0}};
        int[][] res = lc832.flipAndInvertImage(image);
        System.out.println("res = " + Arrays.deepToString(res));
    }
}
