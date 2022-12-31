package com.jacobcai.cc;

public class Lc191 {
    public int hammingWeight(int n) {
        int cnt = 0;
        while (n != 0) {
            n &= n - 1;
            cnt++;
        }
        return cnt;
    }
    
    public static void main(String[] args) {
        Lc191 lc191 = new Lc191();
        int res = lc191.hammingWeight(-3);
        System.out.println("res = " + res);
    }
}
