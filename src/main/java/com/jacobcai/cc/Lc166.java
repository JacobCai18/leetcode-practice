package com.jacobcai.cc;

import java.util.HashMap;
import java.util.Map;

public class Lc166 {
    public String fractionToDecimal(int numerator, int denominator) {
        long x = numerator, y = denominator; // 防止溢出
        if (x % y == 0) return String.valueOf(x / y); // 能整除
        StringBuilder sb = new StringBuilder();
        if (x * y < 0) sb.append('-'); // 其一为负数
        x = Math.abs(x);
        y = Math.abs(y);
        sb.append(x / y).append("."); // 整数部分
        x %= y;
        Map<Long, Integer> mp = new HashMap<>(); // <余数, 出现位置>
        while (x != 0 && !mp.containsKey(x)) {
            mp.put(x, sb.length());
            x *= 10;
            sb.append(x / y);
            x %= y;
        }
        if (x != 0) {
            int i = mp.get(x);
            sb.insert(i, '(');
            sb.append(')');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Lc166 lc166 = new Lc166();
        String res = lc166.fractionToDecimal(4, 333);
        System.out.println("res = " + res);
    }
}
