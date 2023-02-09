package com.jacobcai.cd;

public class Lc326 {
    public boolean isPowerOfThree(int n) {
        while (n > 0 && n % 3 == 0) n /= 3;
        return n == 1;
    }

    public static void main(String[] args) {
        Lc326 lc326 = new Lc326();
        boolean res = lc326.isPowerOfThree(81);
        System.out.println("res = " + res);
    }
}
