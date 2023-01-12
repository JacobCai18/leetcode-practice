package com.jacobcai.mmccc;

public class Lc2287 {
    public int rearrangeCharacters(String s, String target) {
        int[] mapT = new int[26];
        int[] mapS = new int[26];
        for (char c : target.toCharArray())
            mapT[c - 'a']++;
        for (char c : s.toCharArray())
            if (mapT[c - 'a'] != 0)
                mapS[c - 'a']++;
        int cnt = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++)
            if (mapT[i] != 0)
                cnt = Math.min(cnt, mapS[i] / mapT[i]);
        return cnt;
    }

    public static void main(String[] args) {
        Lc2287 lc2287 = new Lc2287();
        String s = "ilovecodingonleetcode";
        String target = "code";
        int res = lc2287.rearrangeCharacters(s, target);
        System.out.println("res = " + res);
    }
}
