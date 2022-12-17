package com.jacobcai.cc;

import java.util.Arrays;

public class Lc130 {
    private char[][] board;
    private int rowLen;
    private int colLen;
    
    public void solve(char[][] board) {
        this.board = board;
        rowLen = board.length;
        colLen = board[0].length;
        for (int i = 0; i < rowLen; i++) {
            dfs(i, 0);
            dfs(i, colLen - 1);
        }
        for (int j = 1; j < colLen - 1; j++) {
            dfs(0, j);
            dfs(rowLen - 1, j);
        }
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private void dfs(int i,
                     int j) {
        if (i < 0 || i >= rowLen || j < 0 || j >= colLen || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '*';
        dfs(i, j + 1);
        dfs(i + 1, j);
        dfs(i, j - 1);
        dfs(i - 1, j);
    }
    
    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        Lc130 lc130 = new Lc130();
        lc130.solve(board);
        System.out.println("board = " + Arrays.deepToString(board));
    }
}
