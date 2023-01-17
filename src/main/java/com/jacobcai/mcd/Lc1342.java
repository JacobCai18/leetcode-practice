package com.jacobcai.mcd;

public class Lc1342 {
    public int numberOfSteps(int num) {
        int cnt = 0;
        while (num != 0) {
            num = (num & 1) == 1 ? num - 1 : num >> 1;
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Lc1342 lc1342 = new Lc1342();
        int res = lc1342.numberOfSteps(14);
        System.out.println("res = " + res);
    }
}
