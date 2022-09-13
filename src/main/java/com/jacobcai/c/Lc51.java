package com.jacobcai.c;

import java.util.*;

public class Lc51 {
    private int n;
    private List<List<String>> res;
    private int[] queens;
    private Set<Integer> cols;
    private Set<Integer> dias1;
    private Set<Integer> dias2;
    
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        res = new ArrayList<>();
        queens = new int[n];
        cols = new HashSet<>();
        dias1 = new HashSet<>();
        dias2 = new HashSet<>();
        backtrack(0);
        return res;
    }
    
    private void backtrack(int row) {
        if (row == n) {
            res.add(generateBoard());
            return;
        }
        for (int j = 0; j < n; j++) {
            if (cols.contains(j)) {
                continue;
            }
            int dia1 = row - j;
            if (dias1.contains(dia1)) {
                continue;
            }
            int dia2 = row + j;
            if (dias2.contains(dia2)) {
                continue;
            }
            queens[row] = j;
            cols.add(j);
            dias1.add(dia1);
            dias2.add(dia2);
            backtrack(row + 1);
            cols.remove(j);
            dias1.remove(dia1);
            dias2.remove(dia2);
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
        Lc51 lc51 = new Lc51();
        List<List<String>> res = lc51.solveNQueens(n);
        System.out.println("res = " + res);
    }
}
