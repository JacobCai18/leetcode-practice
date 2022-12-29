package com.jacobcai.d;

public class Lc461 {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int cnt = 0;
        while (z != 0) {
            z &= z - 1;
            cnt++;
        }
        return cnt;
    }
    
    public static void main(String[] args) {
        int x = 1;
        int y = 4;
        Lc461 lc461 = new Lc461();
        int res = lc461.hammingDistance(x,
                                        y);
        System.out.println("res = " + res);
    }
}
