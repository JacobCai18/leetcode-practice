package com.jacobcai.cc;

public class Lc172 {
    public int trailingZeroes(int n) {
        int cnt = 0;
        while (n > 0) {
            n /= 5;
            cnt += n;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Lc172 lc172 = new Lc172();
        int res = lc172.trailingZeroes(25);
        System.out.println("res = " + res);
    }
}
