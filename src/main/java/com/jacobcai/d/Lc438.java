package com.jacobcai.d;

import java.util.ArrayList;
import java.util.List;

public class Lc438 {
    public List<Integer> findAnagrams(String s,
                                      String p) {
        int sLen, pLen;
        List<Integer> res = new ArrayList<>();
        if ((sLen = s.length()) < (pLen = p.length())) {
            return res;
        }
        int[] sMap = new int[26];
        int[] pMap = new int[26];
        for (int i = 0; i < pLen; i++) {
            pMap[p.charAt(i) - 'a']++;
        }
        int sLe, sRi;
        sLe = sRi = 0;
        for (; sRi < sLen; sRi++) {
            int sMRi;
            sMap[sMRi = s.charAt(sRi) - 'a']++;
            // sLe++至sMap[sMRi]==pMap[sMRi]
            while (sMap[sMRi] > pMap[sMRi]) {
                sMap[s.charAt(sLe++) - 'a']--;
            }
            if (sRi - sLe + 1 == pLen) {
                res.add(sLe);
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        Lc438 lc438 = new Lc438();
        List<Integer> res = lc438.findAnagrams(s,
                                               p);
        System.out.println("res = " + res);
    }
}
