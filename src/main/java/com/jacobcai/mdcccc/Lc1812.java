package com.jacobcai.mdcccc;

public class Lc1812 {
    public boolean squareIsWhite(String coordinates) {
        return ((coordinates.charAt(0) + coordinates.charAt(1)) & 1) == 1;
    }
    
    public static void main(String[] args) {
        Lc1812 lc1812 = new Lc1812();
        boolean res = lc1812.squareIsWhite("h3");
        System.out.println("res = " + res);
    }
}
