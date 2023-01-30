package com.jacobcai.mmcd;

public class Lc2319 {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if ((i == j || i + j == n - 1) == (grid[i][j] == 0))
                    return false;
        return true;
    }

    public static void main(String[] args) {
        Lc2319 lc2319 = new Lc2319();
        int[][] grid = {{5, 0, 0, 1},
                {0, 4, 1, 5},
                {0, 5, 2, 0},
                {4, 1, 0, 2}};
        boolean res = lc2319.checkXMatrix(grid);
        System.out.println("res = " + res);
    }
}
