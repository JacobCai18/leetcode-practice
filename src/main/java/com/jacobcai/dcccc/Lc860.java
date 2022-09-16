package com.jacobcai.dcccc;

public class Lc860 {
    public boolean lemonadeChange(int[] bills) {
        int five, ten;
        five = ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        int[] bills = {5, 5, 5, 10, 20};
        Lc860 lc860 = new Lc860();
        boolean res = lc860.lemonadeChange(bills);
        System.out.println("res = " + res);
    }
}
