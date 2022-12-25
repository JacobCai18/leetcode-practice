package com.jacobcai.mdccc;

public class Lc1739_2 {
    public int minimumBoxes(int n) {
        int i, j;
        int le = 1, ri = Math.min(n,
                                  100000);
        while (le < ri) {
            int mid = (le + ri) >>> 1;
            long sum = (long) mid * (mid + 1) * (mid + 2) / 6;
            if (sum >= n) {
                ri = mid;
            } else {
                le = mid + 1;
            }
        }
        i = le;
        n -= (long) (i - 1) * i * (i + 1) / 6;
        le = 1;
        ri = i;
        while (le < ri) {
            int mid = (le + ri) >>> 1;
            long sum = (long) mid * (mid + 1) / 2;
            if (sum >= n) {
                ri = mid;
            } else {
                le = mid + 1;
            }
        }
        j = le;
        return (i - 1) * i / 2 + j;
    }
    
    public static void main(String[] args) {
        Lc1739_2 lc1739_2 = new Lc1739_2();
        int res = lc1739_2.minimumBoxes(15);
        System.out.println("res = " + res);
    }
}
