package com.jacobcai.dccc;

import java.util.ArrayList;
import java.util.List;

public class Lc784 {
    public List<String> letterCasePermutation(String s) {
        int m = 0, n = s.length();
        char[] ca = s.toCharArray();
        List<String> res = new ArrayList<>();
        for (char c : ca) if (Character.isLetter(c)) m++; // 统计有多少个字母
        for (int mask = 0; mask < (1 << m); mask++) { // 2^m 种可能性
            StringBuilder sb = new StringBuilder(n);
            for (int j = 0, k = 0; j < n; j++)
                if (Character.isLetter(ca[j]) && (mask & (1 << k++)) != 0) // k 表示第 k 个字母; 注意 != 0
                    sb.append(Character.toUpperCase(ca[j]));
                else
                    sb.append(Character.toLowerCase(ca[j]));
            res.add(sb.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        Lc784 lc784 = new Lc784();
        String s = "a1b2c3d4";
        List<String> res = lc784.letterCasePermutation(s);
        System.out.println("res = " + res);
    }
}
