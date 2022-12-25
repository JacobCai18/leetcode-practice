package com.jacobcai.c;

public class Lc69 {
    public int mySqrt(int x) {
        int le, ri;
        le = 0;
        ri = x;
        while (le <= ri) {
            int mid = (le + ri) >>> 1;
            if ((long) mid * mid == x) {
                return mid;
            } else if ((long) mid * mid < x) {
                le = mid + 1;
            } else {
                ri = mid - 1;
            }
        }
        return le - 1;
    }
    
    public static void main(String[] args) {
        Lc69 lc69 = new Lc69();
        int res = lc69.mySqrt(8);
        System.out.println("res = " + res);
    }
}
