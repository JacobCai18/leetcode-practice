package com.jacobcai.mdcccc;

public class Lc1802 {
    public int maxValue(int n,
                        int index,
                        int maxSum) {
        // [le, mid), [mid, ri]
        int le, ri;
        le = 0;
        ri = maxSum;
        while (le < ri) {
            int mid = (le + ri + 1) >>> 1;
            if (getMinSum(mid,
                          n,
                          index) <= maxSum) {
                le = mid;
            } else {
                ri = mid - 1;
            }
        }
        return le;
    }
    
    private long getMinSum(int res,
                           int n,
                           int index) {
        int le, ri, leLen, riLen;
        le = 0;
        ri = n - 1;
        long sum = 0;
        leLen = index - le + 1;
        riLen = ri - index + 1;
        if (leLen >= res) {
            sum += (long) (1 + res) * res / 2 + leLen - res;
        } else {
            sum += (2L * res - leLen + 1) * leLen / 2;
        }
        if (riLen >= res) {
            sum += (long) (1 + res) * res / 2 + riLen - res;
        } else {
            sum += (2L * res - riLen + 1) * riLen / 2;
        }
        sum -= res;
        return sum;
    }
    
    public static void main(String[] args) {
        Lc1802 lc1802 = new Lc1802();
        int res = lc1802.maxValue(4,
                                  0,
                                  4);
        System.out.println("res = " + res);
    }
}
