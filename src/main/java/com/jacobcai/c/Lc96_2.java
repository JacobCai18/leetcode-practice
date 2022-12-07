package com.jacobcai.c;

public class Lc96_2 {
    public int numTrees(int n) {
        // 用 long 类型防止计算过程中的溢出
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2L * i + 1) / (i + 2);
        }
        return (int) C;
    }
    
    public static void main(String[] args) {
        Lc96_2 lc96_2 = new Lc96_2();
        int res = lc96_2.numTrees(3);
        System.out.println("res = " + res);
    }
}
