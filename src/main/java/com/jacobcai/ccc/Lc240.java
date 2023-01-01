package com.jacobcai.ccc;

public class Lc240 {
    public boolean searchMatrix(int[][] matrix,
                                int target) {
        int rowLen, colLen, x, y;
        rowLen = matrix.length;
        colLen = matrix[0].length;
        x = 0;
        y = colLen - 1;
        while (x < rowLen && y >= 0) {
            int cur = matrix[x][y];
            if (cur == target) {
                return true;
            }
            if (cur < target) {
                x++;
            } else {
                y--;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15},
                          {2, 5, 8, 12, 19},
                          {3, 6, 9, 16, 22},
                          {10, 13, 14, 17, 24},
                          {18, 21, 23, 26, 30}};
        int target = 5;
        Lc240 lc240 = new Lc240();
        boolean res = lc240.searchMatrix(matrix,
                                         target);
        System.out.println("res = " + res);
    }
}
