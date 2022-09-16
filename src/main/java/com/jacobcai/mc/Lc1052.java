package com.jacobcai.mc;

public class Lc1052 {
    public int maxSatisfied(int[] customers,
                            int[] grumpy,
                            int minutes) {
        int nor, len, sum, max, ri;
        nor = 0;
        for (int i = 0; i < (len = customers.length); i++) {
            if (grumpy[i] == 0) {
                nor += customers[i];
            }
        }
        sum = 0;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                sum += customers[i];
            }
        }
        max = sum;
        ri = minutes;
        while (ri < len) {
            if (grumpy[ri] == 1 && grumpy[ri - minutes] == 1) {
                sum += (customers[ri] - customers[ri - minutes]);
                max = Math.max(max,
                               sum);
            } else if (grumpy[ri] == 1) {
                sum += customers[ri];
                max = Math.max(max,
                               sum);
            } else if (grumpy[ri - minutes] == 1) {
                sum -= customers[ri - minutes];
                max = Math.max(max,
                               sum);
            }
            ri++;
        }
        return nor + max;
    }
    
    public static void main(String[] args) {
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        int minutes = 3;
        Lc1052 lc1052 = new Lc1052();
        int res = lc1052.maxSatisfied(customers,
                                      grumpy,
                                      minutes);
        System.out.println("res = " + res);
    }
}
