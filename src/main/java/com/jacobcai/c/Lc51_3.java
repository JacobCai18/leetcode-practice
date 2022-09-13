package com.jacobcai.c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc51_3 {
    private int n;
    private List<List<String>> res;
    private int[] queens;
    
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        res = new ArrayList<>();
        queens = new int[n];
        backtrack(0,
                  0,
                  0,
                  0);
        return res;
    }
    
    /**
     * @param row
     * @param cols  0可放 1不可放
     * @param dias1 0可放 1不可放
     * @param dias2 0可放 1不可放
     */
    private void backtrack(int row,
                           int cols,
                           int dias1,
                           int dias2) {
        if (row == n) {
            res.add(generateBoard());
            return;
        }
        // avaPos: 0不可放 1可放
        int avaPos = ((1 << n) - 1) & (~(cols | dias1 | dias2));
        while (avaPos != 0) {
            // 获得最低位1的位置
            int pos = avaPos & -avaPos;
            // 将最低位的1置0
            avaPos &= avaPos - 1;
            // 获得pos对应的列
            queens[row] = Integer.bitCount(pos - 1);
            backtrack(row + 1,
                      cols | pos,
                      (dias1 | pos) << 1,
                      (dias2 | pos) >> 1);
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
        Lc51_3 lc51_3 = new Lc51_3();
        List<List<String>> res = lc51_3.solveNQueens(n);
        System.out.println("res = " + res);
    }
}
