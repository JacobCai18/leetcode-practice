package com.jacobcai.c;

public class Lc36_2 {
    public boolean isValidSudoku(char[][] board) {
        int[] row = new int[10], col = new int[10], box = new int[10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                int n = c - '0';
                int idx = i / 3 * 3 + j / 3;
                if ((((row[i] >> n) & 1) == 1) || (((col[j] >> n) & 1) == 1) || (((box[idx] >> n) & 1) == 1)) {
                    return false;
                }
                row[i] |= (1 << n);
                col[j] |= (1 << n);
                box[idx] |= (1 << n);
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        Lc36_2 lc36_2 = new Lc36_2();
        boolean res = lc36_2.isValidSudoku(board);
        System.out.println("res = " + res);
    }
}
