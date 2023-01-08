package com.jacobcai.mdcccc;

public class Lc1806_2 {
    public int reinitializePermutation(int n) {
        if (n == 2) {
            return 1;
        }
        int step = 1, pow2 = 2;
        while (pow2 != 1) {
            step++;
            pow2 = pow2 * 2 % (n - 1);
        }
        return step;
    }
    
    public static void main(String[] args) {
        Lc1806_2 lc1806 = new Lc1806_2();
        int res = lc1806.reinitializePermutation(4);
        System.out.println("res = " + res);
    }
}
