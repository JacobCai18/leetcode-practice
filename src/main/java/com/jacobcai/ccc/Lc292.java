package com.jacobcai.ccc;

public class Lc292 {
    public boolean canWinNim(int n) {
        return (n & 3) != 0;
    }

    public static void main(String[] args) {
        Lc292 lc292 = new Lc292();
        boolean res = lc292.canWinNim(4);
        System.out.println("res = " + res);
    }
}
