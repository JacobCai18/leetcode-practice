package com.jacobcai.cd;

public class Lc374 {
    private int guess(int n) {
        return -1;
    }

    public int guessNumber(int n) {
        int le = 1, ri = n;
        while (le < ri) {
            int mid = le + (ri - le) / 2;
            if (guess(mid) <= 0)
                ri = mid;
            else
                le = mid + 1;
        }
        return le;
    }
}
