package com.jacobcai.cc;

public class Lc134 {
    public int canCompleteCircuit(int[] gas,
                                  int[] cost) {
        int len = gas.length;
        int i = 0;
        while (i < len) {
            int sumG, sumC, cnt;
            sumG = sumC = cnt = 0;
            while (cnt < len) {
                int j = (i + cnt) % len;
                sumG += gas[j];
                sumC += cost[j];
                if (sumG < sumC) {
                    break;
                }
                cnt++;
            }
            if (cnt == len) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        Lc134 lc134 = new Lc134();
        int res = lc134.canCompleteCircuit(gas,
                                           cost);
        System.out.println("res = " + res);
    }
}
