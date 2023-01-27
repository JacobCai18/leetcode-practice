package com.jacobcai.mmdc;

public class Lc2546 {
    public boolean makeStringsEqual(String s, String target) {
        return s.contains("1") == target.contains("1"); // 都有 1 或都没有 1
    }

    public static void main(String[] args) {
        Lc2546 lc2546 = new Lc2546();
        String s = "1010";
        String target = "0110";
        boolean res = lc2546.makeStringsEqual(s, target);
        System.out.println("res = " + res);
    }
}
