package com.jacobcai.mc;

public class Lc1052_2 {
    public int maxSatisfied(int[] customers,
                            int[] grumpy,
                            int minutes) {
        int nor, len, sum, max, ri;
        nor = 0;
        for (int i = 0; i < (len = customers.length); i++) {
            if (grumpy[i] == 0) {
                nor += customers[i];
                // 下次遍历就都是grumpy[i]==1的情况
                customers[i] = 0;
            }
        }
        sum = 0;
        for (int i = 0; i < minutes; i++) {
            sum += customers[i];
        }
        max = sum;
        ri = minutes;
        while (ri < len) {
            sum += (customers[ri] - customers[ri - minutes]);
            max = Math.max(max,
                           sum);
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
