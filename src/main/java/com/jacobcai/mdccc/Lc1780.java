package com.jacobcai.mdccc;

public class Lc1780 {
    public boolean checkPowersOfThree(int n) {
        while (n != 0) {
            // 转换为 3 进制，每 1 位只能为 0 或 1，不能为 2
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Lc1780 lc1780 = new Lc1780();
        boolean res = lc1780.checkPowersOfThree(12);
        System.out.println("res = " + res);
    }
}
