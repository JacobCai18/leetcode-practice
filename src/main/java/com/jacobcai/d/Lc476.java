package com.jacobcai.d;

public class Lc476 {
    public int findComplement(int num) {
        int mask = num;
        mask |= mask >> 1;
        mask |= mask >> 2;
        mask |= mask >> 4;
        mask |= mask >> 8;
        mask |= mask >> 16;
        return num ^ mask;
    }

    public static void main(String[] args) {
        Lc476 lc476 = new Lc476();
        int res = lc476.findComplement(5);
        System.out.println("res = " + res);
    }
}
