package com.jacobcai.cc;

import java.util.Arrays;

public class Lc167 {
    public int[] twoSum(int[] numbers,
                        int target) {
        int le, ri, len;
        len = numbers.length;
        le = 0;
        ri = len - 1;
        while (le < ri) {
            int curSum = numbers[le] + numbers[ri];
            if (curSum == target) {
                break;
            } else if (curSum < target) {
                le++;
            } else {
                ri--;
            }
        }
        return new int[]{le + 1, ri + 1};
    }
    
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 4, 9, 56, 90};
        int target = 8;
        Lc167 lc167 = new Lc167();
        int[] res = lc167.twoSum(numbers,
                                 target);
        System.out.println("res = " + Arrays.toString(res));
    }
}
