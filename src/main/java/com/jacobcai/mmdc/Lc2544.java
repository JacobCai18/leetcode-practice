package com.jacobcai.mmdc;

public class Lc2544 {
    public int alternateDigitSum(int n) {
        int ans = 0, sign = 1;
        while (n != 0) {
            ans += n % 10 * sign;
            n /= 10;
            sign = -sign;
        }
        return ans * -sign;
    }

    public static void main(String[] args) {
        Lc2544 lc2544 = new Lc2544();
        int n = 521;
        int res = lc2544.alternateDigitSum(n);
        System.out.println("res = " + res);
    }
}
