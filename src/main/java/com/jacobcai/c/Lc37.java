package com.jacobcai.c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc37 {
    private final boolean[][] row = new boolean[9][9];
    private final boolean[][] col = new boolean[9][9];
    private final boolean[][][] block = new boolean[3][3][9];
    private boolean valid = false;
    private final List<int[]> spaces = new ArrayList<>();
    
    public void solveSudoku(char[][] board) {
        // 先处理 board 已有信息
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int d = c - '0' - 1;
                    row[i][d] = col[j][d] = block[i / 3][j / 3][d] = true;
                } else {
                    spaces.add(new int[]{i, j});
                }
            }
        }
        backtrack(0,
                  board);
    }
    
    private void backtrack(int p,
                           char[][] board) {
        if (p == spaces.size()) {
            valid = true;
            return;
        }
        int[] space = spaces.get(p);
        int i = space[0], j = space[1];
        // valid: 只要找到了，就不再进入循环
        for (int d = 0; d < 9 && !valid; d++) {
            if (!row[i][d] && !col[j][d] && !block[i / 3][j / 3][d]) {
                // 在一个空位置尝试填入一个数字
                board[i][j] = (char) (d + '0' + 1);
                row[i][d] = col[j][d] = block[i / 3][j / 3][d] = true;
                backtrack(p + 1,
                          board);
                row[i][d] = col[j][d] = block[i / 3][j / 3][d] = false;
            }
        }
    }
    
    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                          {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                          {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                          {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                          {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                          {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                          {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                          {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                          {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        Lc37 lc37 = new Lc37();
        lc37.solveSudoku(board);
        System.out.println("board = " + Arrays.deepToString(board));
    }
}
