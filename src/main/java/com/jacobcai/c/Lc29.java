package com.jacobcai.c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lc29 {
    public int divide(int dividend,
                      int divisor) {
        // 预处理
        // 被除数为最小值
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 除数为最小值
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ?
                   1 :
                   0;
        }
        // 被除数为0
        if (dividend == 0) {
            return 0;
        }
        // 一般情况
        boolean flag = false;
        long x = dividend;
        int y = divisor;
        if (x < 0) {
            x = -x;
            flag = true;
        }
        if (y < 0) {
            y = -y;
            flag = !flag;
        }
        if (x < y) {
            return 0;
        }
        // 3*1=3, 3*2=6, 3*4=12, 3*8=24, 3*16=48, 3*32=96
        // 96>80 res+=16 80-48=32
        // 32>=24 res+=8 32-24=8
        // 8>=6 res+=2 8-6=2
        // 2<3 return res
        // a个divisor的和为b
        long a, b;
        List<long[]> list = new ArrayList<>();
        a = 1;
        b = y;
        // x==y时要进入，让list非空
        while (b <= x) {
            list.add(new long[]{a, b});
            a <<= 1;
            b <<= 1;
        }
        int len = list.size();
        int count = (int) list.get(len - 1)[0];
        int newDividend = (int) (x - list.get(len - 1)[1]);
        while (newDividend >= y) {
            // 本来就有序，可二分找下标
            int i = Collections.binarySearch(list,
                                             new long[]{0, newDividend},
                                             Comparator.comparingLong(o -> o[1]));
            if (i < 0) { // 未找到
                i = ~i - 1;
            }
            newDividend -= list.get(i)[1];
            count += list.get(i)[0];
        }
        return flag ?
               -count :
               count;
    }
    
    public static void main(String[] args) {
        int dividend = 1;
        int divisor = 2;
        Lc29 lc29 = new Lc29();
        int res = lc29.divide(dividend,
                              divisor);
        System.out.println("res = " + res);
    }
}
