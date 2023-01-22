package com.jacobcai.dc;

import java.util.Arrays;

public class Lc566 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] res = new int[r][c];
        int m = mat.length, n = mat[0].length;
        if (m * n != r * c) return mat;
        for (int i = 0; i < m * n; i++)
            res[i / c][i % c] = mat[i / n][i % n];
        return res;
    }

    public static void main(String[] args) {
        Lc566 lc566 = new Lc566();
        int[][] mat = {{1, 2}, {3, 4}};
        int[][] res = lc566.matrixReshape(mat, 1, 4);
        System.out.println("res = " + Arrays.deepToString(res));
    }
}
