package com.jacobcai.c;

import java.util.ArrayList;
import java.util.List;

public class Lc54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowLen, colLen, le, ri, top, bot, tar;
        rowLen = matrix.length;
        colLen = matrix[0].length;
        le = top = 0;
        ri = colLen - 1;
        bot = rowLen - 1;
        tar = rowLen * colLen;
        List<Integer> res = new ArrayList<>();
        // 注意长方形
        while (tar >= 1) {
            // left to right
            for (int i = le; i <= ri && tar >= 1; i++) {
                res.add(matrix[top][i]);
                tar--;
            }
            top++;
            // top to bottom
            for (int i = top; i <= bot && tar >= 1; i++) {
                res.add(matrix[i][ri]);
                tar--;
            }
            ri--;
            // right to left
            for (int i = ri; i >= le && tar >= 1; i--) {
                res.add(matrix[bot][i]);
                tar--;
            }
            bot--;
            // bottom to top
            for (int i = bot; i >= top && tar >= 1; i--) {
                res.add(matrix[i][le]);
                tar--;
            }
            le++;
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        Lc54 lc54 = new Lc54();
        List<Integer> res = lc54.spiralOrder(matrix);
        System.out.println("res = " + res);
    }
}
