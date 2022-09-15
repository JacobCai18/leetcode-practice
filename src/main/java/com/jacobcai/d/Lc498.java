package com.jacobcai.d;

import java.util.Arrays;

public class Lc498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int rowLen = mat.length;
        int colLen = mat[0].length;
        int[] res = new int[rowLen * colLen];
        int pos = 0;
        for (int i = 0; i < rowLen + colLen - 1; i++) {
            if ((i & 1) == 1) {
                int x = i < colLen ?
                        0 :
                        i - colLen + 1;
                int y = i < colLen ?
                        i :
                        colLen - 1;
                while (x < rowLen && y >= 0) {
                    res[pos++] = mat[x++][y--];
                }
            } else {
                int x = i < rowLen ?
                        i :
                        rowLen - 1;
                int y = i < rowLen ?
                        0 :
                        i - rowLen + 1;
                while (x >= 0 && y < colLen) {
                    res[pos++] = mat[x--][y++];
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Lc498 lc498 = new Lc498();
        int[] res = lc498.findDiagonalOrder(mat);
        System.out.println("res = " + Arrays.toString(res));
    }
}
