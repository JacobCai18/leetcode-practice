package com.jacobcai.c;

import java.util.Arrays;

public class Lc73 {
    public void setZeroes(int[][] matrix) {
        int rowLen, colLen;
        boolean[] row, col;
        rowLen = matrix.length;
        colLen = matrix[0].length;
        row = new boolean[rowLen];
        col = new boolean[colLen];
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        Lc73 lc73 = new Lc73();
        lc73.setZeroes(matrix);
        System.out.println("matrix = " + Arrays.deepToString(matrix));
    }
}
