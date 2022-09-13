package com.jacobcai.c;

import java.util.Arrays;

public class Lc59 {
    public int[][] generateMatrix(int n) {
        int le, ri, top, bot, num, tar;
        le = top = 0;
        ri = bot = n - 1;
        num = 1;
        tar = n * n;
        int[][] res = new int[n][n];
        while (num <= tar) {
            for (int i = le; i <= ri; i++) {
                res[top][i] = num++; // left to right.
            }
            top++;
            for (int i = top; i <= bot; i++) {
                res[i][ri] = num++; // top to bottom.
            }
            ri--;
            for (int i = ri; i >= le; i--) {
                res[bot][i] = num++; // right to left.
            }
            bot--;
            for (int i = bot; i >= top; i--) {
                res[i][le] = num++; // bottom to top.
            }
            le++;
        }
        return res;
    }
    
    public static void main(String[] args) {
        int n = 3;
        Lc59 lc59 = new Lc59();
        int[][] res = lc59.generateMatrix(n);
        System.out.println("res = " + Arrays.deepToString(res));
    }
}
