package com.jacobcai.d;

public class Lc434 {
    public int countSegments(String s) {
        int cnt = 0, n = s.length();
        if (n == 0) return 0;
        for (int i = 1; i < n; i++)
            if (s.charAt(i) == ' ' && s.charAt(i - 1) != ' ')
                cnt++;
        if (s.charAt(n - 1) != ' ') cnt++;
        return cnt;
    }

    public static void main(String[] args) {
        Lc434 lc434 = new Lc434();
        String s = "Hello, my name is Jacob";
        int res = lc434.countSegments(s);
        System.out.println("res = " + res);
    }
}
