package com.jacobcai.ccc;

public class Lc201_2 {
    public int rangeBitwiseAnd(int left, int right) {
        while (left < right) right &= right - 1;
        return right;
    }

    public static void main(String[] args) {
        Lc201_2 lc201 = new Lc201_2();
        int res = lc201.rangeBitwiseAnd(5, 7);
        System.out.println("res = " + res);
    }
}
