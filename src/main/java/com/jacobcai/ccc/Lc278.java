package com.jacobcai.ccc;

public class Lc278 {
    public int firstBadVersion(int n) {
        int le = 1, ri = n;
        while (le < ri) {
            int mid = (le + ri) >>> 1;
            if (isBadVersion(mid)) {
                ri = mid;
            } else {
                le = mid + 1;
            }
        }
        return le;
    }
    
    private boolean isBadVersion(int version) {
        return false;
    }
}
