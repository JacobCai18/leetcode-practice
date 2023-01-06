package com.jacobcai.mmcc;

public class Lc2180_2 {
    public int countEven(int num) {
        if ((num & 1) == 1) {
            return num >> 1;
        }
        int n = num / 10;
        int s = 0;
        while (n != 0) {
            s += n % 10;
            n /= 10;
        }
        return (num >> 1) - (s & 1);
    }
    
    public static void main(String[] args) {
        int num = 112;
        Lc2180_2 lc2180 = new Lc2180_2();
        int res = lc2180.countEven(num);
        System.out.println("res = " + res);
    }
}
