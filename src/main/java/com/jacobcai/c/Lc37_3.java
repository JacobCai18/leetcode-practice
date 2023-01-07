package com.jacobcai.c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc37_3 {
    private final int[] row = new int[9];
    private final int[] col = new int[9];
    private final int[][] block = new int[3][3];
    private boolean valid = false;
    private final List<int[]> spaces = new ArrayList<>();
    
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.')
                    flip(i, j, c - '0' - 1);
            }
        }
        // 将空格唯一确定的数填入该空格，直至所有空格的数都不唯一确定
        while (true) {
            boolean modified = false;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') {
                        int mask = ~(row[i] | col[j] | block[i / 3][j / 3]) & 0x1ff;
                        if ((mask & (-mask)) == 0) {
                            int digit = Integer.bitCount(mask - 1);
                            board[i][j] = (char) (digit + '0' + 1);
                            flip(i, j, digit);
                            modified = true;
                        }
                    }
                }
            }
            if (!modified) break;
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                if (board[i][j] == '.')
                    spaces.add(new int[]{i, j});
        }
        backtrack(0, board);
    }
    
    private void backtrack(int pos,
                           char[][] board) {
        if (pos == spaces.size()) {
            valid = true;
            return;
        }
        int[] space = spaces.get(pos);
        int i = space[0], j = space[1];
        // 1：可以使用的数字
        int mask = ~(row[i] | col[j] | block[i / 3][j / 3]) & 0x1ff;
        // valid: 只要找到了，就不再进入循环
        // mask &= (mask - 1) 将最低位的 1 置 0
        for (; mask != 0 && !valid; mask &= (mask - 1)) {
            // 取出最低位的 1
            int digitMask = mask & (-mask);
            // 将最低位的 1 还原为数字
            int digit = Integer.bitCount(digitMask - 1);
            // 在一个空位置尝试填入一个数字
            board[i][j] = (char) (digit + '0' + 1);
            flip(i, j, digit);
            backtrack(pos + 1, board);
            flip(i, j, digit);
        }
    }
    
    /**
     * 0 可使用该数字，1 不能使用该数字
     *
     * @param i board 行
     * @param j board 列
     * @param digit 填入 board 的 1 - 9 digit
     */
    private void flip(int i,
                      int j,
                      int digit) {
        row[i] ^= (1 << digit);
        col[j] ^= (1 << digit);
        block[i / 3][j / 3] ^= (1 << digit);
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
        Lc37_3 lc37_3 = new Lc37_3();
        lc37_3.solveSudoku(board);
        System.out.println("board = " + Arrays.deepToString(board));
    }
}
