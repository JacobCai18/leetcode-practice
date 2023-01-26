package com.jacobcai.dccc;

import java.util.Arrays;

public class Lc733 {
    private final int[] di = {1, 0, -1, 0};
    private final int[] dj = {0, 1, 0, -1};

    private void dfs(int[][] image, int oldColor, int color, int i, int j) {
        if (i < 0 || i == image.length || j < 0 || j == image[0].length || image[i][j] != oldColor) return;
        image[i][j] = color;
        for (int k = 0; k < 4; k++)
            dfs(image, oldColor, color, i + di[k], j + dj[k]);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if (oldColor != color)
            dfs(image, oldColor, color, sr, sc);
        return image;
    }

    public static void main(String[] args) {
        Lc733 lc733 = new Lc733();
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] res = lc733.floodFill(image, 1, 1, 2);
        System.out.println("res = " + Arrays.deepToString(res));
    }
}
