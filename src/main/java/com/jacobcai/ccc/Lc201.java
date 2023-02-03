package com.jacobcai.ccc;

public class Lc201 {
    public int rangeBitwiseAnd(int left, int right) {
        int shiftCt = 0;
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shiftCt++;
        }
        return left << shiftCt;
    }

    public static void main(String[] args) {
        Lc201 lc201 = new Lc201();
        int res = lc201.rangeBitwiseAnd(5, 7);
        System.out.println("res = " + res);
    }
}
