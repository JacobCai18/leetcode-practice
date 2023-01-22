package com.jacobcai.cc;

public class Lc190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            rev |= (n & 1) << (31 - i); // 取 n 最低位，左移至翻转后位置
            n >>>= 1; // n 无符号右移 1 位
        }
        return rev;
    }

    public static void main(String[] args) {
        Lc190 lc190 = new Lc190();
        int n = 43261596;
        int res = lc190.reverseBits(n);
        System.out.println("res = " + res);
        // 00000010100101000001111010011100
        // 00111001011110000010100101000000
    }
}
