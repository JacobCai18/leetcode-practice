package com.jacobcai.mmccc;

public class Lc2299 {
    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) return false;
        char pre = ' ', mask = 0;
        for (char c : password.toCharArray()) {
            if (c == pre) return false;
            pre = c;
            if (Character.isLowerCase(c)) mask |= 1;
            else if (Character.isUpperCase(c)) mask |= 2;
            else if (Character.isDigit(c)) mask |= 4;
            else mask |= 8;
        }
        return mask == 15;
    }

    public static void main(String[] args) {
        Lc2299 lc2299 = new Lc2299();
        String password = "IloveLe3tcode!";
        boolean res = lc2299.strongPasswordCheckerII(password);
        System.out.println("res = " + res);
    }
}
