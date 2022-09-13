package com.jacobcai.c;

public class Lc52 {
    private int n;
    private int res;
    
    public int totalNQueens(int n) {
        this.n = n;
        res = 0;
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
            res++;
            return;
        }
        // avaPos: 0不可放 1可放
        int avaPos = ((1 << n) - 1) & (~(cols | dias1 | dias2));
        while (avaPos != 0) {
            // 获得最低位1的位置
            int pos = avaPos & -avaPos;
            // 将最低位的1置0
            avaPos &= avaPos - 1;
            backtrack(row + 1,
                      cols | pos,
                      (dias1 | pos) << 1,
                      (dias2 | pos) >> 1);
        }
    }
    
    public static void main(String[] args) {
        int n = 4;
        Lc52 lc52 = new Lc52();
        int res = lc52.totalNQueens(n);
        System.out.println("res = " + res);
    }
}
