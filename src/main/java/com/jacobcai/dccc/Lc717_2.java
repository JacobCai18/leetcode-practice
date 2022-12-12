package com.jacobcai.dccc;

public class Lc717_2 {
    public boolean isOneBitCharacter(int[] bits) {
        int len = bits.length;
        int i = len - 2;
        while (i >= 0 && bits[i] == 1) {
            i--;
        }
        return ((len - i) & 1) == 0;
    }
    
    public static void main(String[] args) {
        int[] bits = {1, 0, 0};
        Lc717_2 lc717 = new Lc717_2();
        boolean res = lc717.isOneBitCharacter(bits);
        System.out.println("res = " + res);
    }
}
