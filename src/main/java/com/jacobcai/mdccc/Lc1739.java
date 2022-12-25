package com.jacobcai.mdccc;

public class Lc1739 {
    public int minimumBoxes(int n) {
        int cur = 1, i = 1, j = 1;
        while (cur < n) {
            n -= cur;
            cur += ++i;
        }
        cur = 1;
        while (cur < n) {
            n -= cur++;
            j++;
        }
        return (i - 1) * i / 2 + j;
    }
    
    public static void main(String[] args) {
        Lc1739 lc1739 = new Lc1739();
        int res = lc1739.minimumBoxes(15);
        System.out.println("res = " + res);
    }
}
