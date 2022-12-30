package com.jacobcai.ccc;

public class Lc231 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
    
    public static void main(String[] args) {
        Lc231 lc231 = new Lc231();
        boolean res = lc231.isPowerOfTwo(8);
        System.out.println("res = " + res);
    }
}
