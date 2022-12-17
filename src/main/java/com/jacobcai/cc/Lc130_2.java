package com.jacobcai.cc;

import java.util.Arrays;

public class Lc130_2 {
    private int[] uf;
    private int len;
    
    public void solve(char[][] board) {
        int rowLen, colLen;
        rowLen = board.length;
        colLen = board[0].length;
        len = rowLen * colLen;
        // 将最后一位当作在四周的 'O' 的根
        uf = new int[len + 1];
        uf[len] = len;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (board[i][j] == 'X') {
                    continue;
                }
                int k = i * colLen + j;
                uf[k] = k;
                if (i == 0 || i == rowLen - 1 || j == 0 || j == colLen - 1) {
                    union(len, k);
                }
                if (j > 0 && board[i][j - 1] == 'O') {
                    union(k - 1, k);
                }
                if (i > 0 && board[i - 1][j] == 'O') {
                    union(k - colLen, k);
                }
            }
        }
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (board[i][j] == 'O' && find(i * colLen + j) != len) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private void union(int p,
                       int q) {
        p = find(p);
        q = find(q);
        if (p == len) {
            uf[q] = p;
        } else {
            uf[p] = q;
        }
    }
    
    private int find(int p) {
        if (uf[p] != p) {
            uf[p] = find(uf[p]);
        }
        return uf[p];
    }
    
    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        Lc130_2 lc130 = new Lc130_2();
        lc130.solve(board);
        System.out.println("board = " + Arrays.deepToString(board));
    }
}
