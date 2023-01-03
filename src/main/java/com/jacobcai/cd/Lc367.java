package com.jacobcai.cd;

public class Lc367 {
    public boolean isPerfectSquare(int num) {
        int le, ri;
        le = 1;
        ri = num;
        while (le <= ri) {
            int mid = (le + ri) >>> 1;
            // 注意越界
            long square = (long) mid * mid;
            if (square == num) {
                return true;
            } else if (square < num) {
                le = mid + 1;
            } else {
                ri = mid - 1;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int num = 16;
        Lc367 lc367 = new Lc367();
        boolean res = lc367.isPerfectSquare(num);
        System.out.println("res = " + res);
    }
}
