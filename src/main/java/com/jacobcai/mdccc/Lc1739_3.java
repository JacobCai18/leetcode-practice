package com.jacobcai.mdccc;

public class Lc1739_3 {
    public int minimumBoxes(int n) {
        int i = (int) Math.pow(6.0 * n,
                               1.0 / 3);
        if (g(i) < n) {
            i++;
        }
        n -= g(i - 1);
        int j = (int) Math.ceil((Math.sqrt((long) 8 * n + 1) - 1) / 2);
        return (i - 1) * i / 2 + j;
    }
    
    private long g(int i) {
        return (long) i * (i + 1) * (i + 2) / 6;
    }
    
    public static void main(String[] args) {
        Lc1739_3 lc1739_3 = new Lc1739_3();
        int res = lc1739_3.minimumBoxes(15);
        System.out.println("res = " + res);
    }
}
