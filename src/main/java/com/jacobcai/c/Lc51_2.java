package com.jacobcai.c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc51_2 {
    private int n;
    private List<List<String>> res;
    private int[] queens;
    private boolean[] cols;
    private boolean[] dias1;
    private boolean[] dias2;
    
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        res = new ArrayList<>();
        queens = new int[n];
        cols = new boolean[n];
        dias1 = new boolean[2 * n - 1];
        dias2 = new boolean[2 * n - 1];
        backtrack(0);
        return res;
    }
    
    private void backtrack(int row) {
        if (row == n) {
            res.add(generateBoard());
            return;
        }
        for (int j = 0; j < n; j++) {
            int dia1, dia2;
            if (cols[j] || dias1[dia1 = row - j + n - 1] || dias2[dia2 = row + j]) {
                continue;
            }
            queens[row] = j;
            cols[j] = true;
            dias1[dia1] = true;
            dias2[dia2] = true;
            backtrack(row + 1);
            cols[j] = false;
            dias1[dia1] = false;
            dias2[dia2] = false;
        }
    }
    
    private List<String> generateBoard() {
        List<String> board = new ArrayList<>();
        for (int queen : queens) {
            char[] row = new char[n];
            Arrays.fill(row,
                        '.');
            row[queen] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
    
    public static void main(String[] args) {
        int n = 4;
        Lc51_2 lc51_2 = new Lc51_2();
        List<List<String>> res = lc51_2.solveNQueens(n);
        System.out.println("res = " + res);
    }
}
