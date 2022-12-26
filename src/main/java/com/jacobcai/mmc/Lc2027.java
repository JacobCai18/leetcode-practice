package com.jacobcai.mmc;

public class Lc2027 {
    public int minimumMoves(String s) {
        int len, ops;
        len = s.length();
        ops = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'X') {
                ops++;
                i += 2;
            }
        }
        return ops;
    }
    
    public static void main(String[] args) {
        String s = "XXOXXOOXXXXOXX";
        Lc2027 lc2027 = new Lc2027();
        int res = lc2027.minimumMoves(s);
        System.out.println("res = " + res);
    }
}
