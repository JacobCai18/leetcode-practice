package com.jacobcai.d;

public class Lc441 {
    public int arrangeCoins(int n) {
        int le = 1, ri = n;
        while (le < ri) {
            int mid = (le + ri + 1) >>> 1;
            if ((long) mid * (mid + 1) <= (long) 2 * n)
                le = mid;
            else
                ri = mid - 1;
        }
        return le;
    }

    public static void main(String[] args) {
        Lc441 lc441 = new Lc441();
        int res = lc441.arrangeCoins(5);
        System.out.println("res = " + res);
    }
}
