package com.jacobcai.d;

public class Lc482 {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int ct = 0;
        for (int i = s.length() - 1; i > -1; i--) {
            if (s.charAt(i) == '-') continue;
            sb.append(Character.toUpperCase(s.charAt(i)));
            ct++;
            if (ct % k == 0)
                sb.append('-');
        }
        if (!sb.isEmpty() && sb.charAt(sb.length() - 1) == '-')
            sb.deleteCharAt(sb.length() - 1);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Lc482 lc482 = new Lc482();
        String s = "5F3Z-2e-9-w";
        String res = lc482.licenseKeyFormatting(s, 4);
        System.out.println("res = " + res);
    }
}
