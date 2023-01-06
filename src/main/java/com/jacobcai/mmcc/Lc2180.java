package com.jacobcai.mmcc;

public class Lc2180 {
    public int countEven(int num) {
        int one, ten, cnt, tenSum;
        one = num % 10;
        ten = num / 10;
        cnt = ten * 5;
        tenSum = 0;
        while (ten != 0) {
            tenSum += ten % 10;
            ten /= 10;
        }
        if ((tenSum & 1) == 1) {
            cnt += (one + 1) >> 1;
        } else {
            cnt += (one >> 1) + 1;
        }
        return cnt - 1;
    }
    
    public static void main(String[] args) {
        int num = 30;
        Lc2180 lc2180 = new Lc2180();
        int res = lc2180.countEven(num);
        System.out.println("res = " + res);
    }
}
