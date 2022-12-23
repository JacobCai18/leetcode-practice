package com.jacobcai.mmc;

public class Lc2011 {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String operation : operations) {
            if (operation.charAt(1) == '+') {
                x++;
            } else {
                x--;
            }
        }
        return x;
    }
    
    public static void main(String[] args) {
        String[] operations = {"--X", "X++", "X++"};
        Lc2011 lc2011 = new Lc2011();
        int res = lc2011.finalValueAfterOperations(operations);
        System.out.println("res = " + res);
    }
}
