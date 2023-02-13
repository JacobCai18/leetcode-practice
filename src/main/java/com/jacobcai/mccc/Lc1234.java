package com.jacobcai.mccc;

public class Lc1234 {
    private boolean check(int[] cnt, int limit) {
        return cnt[16] <= limit && cnt[22] <= limit && cnt[4] <= limit && cnt[17] <= limit;
    }

    public int balancedString(String s) {
        int n = s.length(), limit = n / 4, i = 0, j = 0, res = n;
        int[] cnt = new int[26];
        for (var c : s.toCharArray()) cnt[c - 'A']++;
        if (check(cnt, limit)) return 0;
        while (i < n) {
            while (j < n && !check(cnt, limit)) cnt[s.charAt(j++) - 'A']--;
            if (!check(cnt, limit)) break;
            res = Math.min(res, j - i);
            cnt[s.charAt(i++) - 'A']++;
        }
        return res;
    }

    public static void main(String[] args) {
        Lc1234 lc1234 = new Lc1234();
        String s = "QQQQ";
        int res = lc1234.balancedString(s);
        System.out.println("res = " + res);
    }
}
