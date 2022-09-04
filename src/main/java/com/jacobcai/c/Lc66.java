package com.jacobcai.c;

import java.util.Arrays;

public class Lc66 {
    public int[] plusOne(int[] digits) {
        int len;
        for (int i = (len = digits.length) - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }
        int[] res = new int[len + 1];
        res[0] = 1;
        return res;
    }
    
    public static void main(String[] args) {
        int[] digits = {9, 9, 9};
        Lc66 lc66 = new Lc66();
        int[] res = lc66.plusOne(digits);
        System.out.println("res = " + Arrays.toString(res));
    }
}
