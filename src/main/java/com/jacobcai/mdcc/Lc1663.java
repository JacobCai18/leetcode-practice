package com.jacobcai.mdcc;

public class Lc1663 {
    public String getSmallestString(int n, int k) {
        int z = (k - n) / 25;
        int a = n - z;
        StringBuilder sb = new StringBuilder();
        sb.append("a".repeat(Math.max(0, a - 1)));
        if (a > 0) sb.append('a' + (k - n) % 25);
        sb.append("z".repeat(Math.max(0, z)));
        return sb.toString();
    }

    public static void main(String[] args) {
        Lc1663 lc1663 = new Lc1663();
        String res = lc1663.getSmallestString(5, 130);
        System.out.println("res = " + res);
    }
}
