package com.jacobcai.dccc;

public class Lc717 {
    public boolean isOneBitCharacter(int[] bits) {
        int len = bits.length;
        int i = 0;
        while (i < len - 1) {
            i += bits[i] + 1;
        }
        return i == len - 1;
    }
    
    public static void main(String[] args) {
        int[] bits = {1, 0, 0};
        Lc717 lc717 = new Lc717();
        boolean res = lc717.isOneBitCharacter(bits);
        System.out.println("res = " + res);
    }
}
