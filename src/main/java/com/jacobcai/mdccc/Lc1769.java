package com.jacobcai.mdccc;

import java.util.Arrays;

public class Lc1769 {
    public int[] minOperations(String boxes) {
        int len = boxes.length();
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int count = 0;
            for (int j = 0; j < len; j++) {
                if (boxes.charAt(j) == '1') {
                    count += Math.abs(i - j);
                }
            }
            res[i] = count;
        }
        return res;
    }
    
    public static void main(String[] args) {
        String boxes = "001011";
        Lc1769 lc1769 = new Lc1769();
        int[] res = lc1769.minOperations(boxes);
        System.out.println("res = " + Arrays.toString(res));
    }
}
