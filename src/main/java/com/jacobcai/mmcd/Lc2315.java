package com.jacobcai.mmcd;

public class Lc2315 {
    public int countAsterisks(String s) {
        boolean valid = true;
        int cnt = 0;
        for (char c : s.toCharArray())
            if (c == '|') valid = !valid;
            else if (c == '*' && valid) cnt++;
        return cnt;
    }

    public static void main(String[] args) {
        Lc2315 lc2315 = new Lc2315();
        String s = "l|*e*et|c**o|*de|";
        int res = lc2315.countAsterisks(s);
        System.out.println("res = " + res);
    }
}
