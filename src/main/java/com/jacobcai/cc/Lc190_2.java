package com.jacobcai.cc;

public class Lc190_2 {
    private static final int M1 = 0x55555555; // 01010101010101010101010101010101
    private static final int M2 = 0x33333333; // 00110011001100110011001100110011
    private static final int M4 = 0x0f0f0f0f; // 00001111000011110000111100001111
    private static final int M8 = 0x00ff00ff; // 00000000111111110000000011111111

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        n = n >>> 1 & M1 | (n & M1) << 1;
        n = n >>> 2 & M2 | (n & M2) << 2;
        n = n >>> 4 & M4 | (n & M4) << 4;
        n = n >>> 8 & M8 | (n & M8) << 8;
        return n >>> 16 | n << 16;
    }

    public static void main(String[] args) {
        Lc190_2 lc190 = new Lc190_2();
        int n = 43261596;
        int res = lc190.reverseBits(n);
        System.out.println("res = " + res);
        // 00000010100101000001111010011100
        // 00111001011110000010100101000000
    }
}
