package com.jacobcai.cd;

public class Lc304 {
    private int[][] sums;
    
    public Lc304(int[][] matrix) {
        int rowLen = matrix.length;
        if (rowLen > 0) {
            int colLen = matrix[0].length;
            sums = new int[rowLen + 1][colLen + 1];
            for (int i = 0; i < rowLen; i++) {
                for (int j = 0; j < colLen; j++) {
                    sums[i + 1][j + 1] = sums[i][j + 1] + sums[i + 1][j] - sums[i][j] + matrix[i][j];
                }
            }
        }
    }
    
    public int sumRegion(int row1,
                         int col1,
                         int row2,
                         int col2) {
        return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];
    }
    
    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        Lc304 lc304 = new Lc304(matrix);
        int res = lc304.sumRegion(2,
                                  1,
                                  4,
                                  3);
        System.out.println("res = " + res);
    }
}
