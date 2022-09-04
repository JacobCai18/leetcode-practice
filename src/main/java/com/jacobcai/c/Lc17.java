package com.jacobcai.c;

import java.util.ArrayList;
import java.util.List;

public class Lc17 {
    // 数字到字母集的映射
    private static final String[] MAP = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> res;
    private StringBuilder sb;
    private int len;
    
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        len = digits.length();
        if (len == 0) {
            return res;
        }
        sb = new StringBuilder(len);
        backtrack(digits,
                  0);
        return res;
    }
    
    private void backtrack(String digits,
                           int curr) {
        if (curr == len) {
            res.add(sb.toString());
            return;
        }
        // 当前数字
        char digit = digits.charAt(curr);
        // 由当前数字获得当前字母集
        char[] letters = MAP[digit - '2'].toCharArray();
        for (char c : letters) {
            sb.append(c);
            backtrack(digits,
                      curr + 1);
            sb.deleteCharAt(curr);
        }
    }
    
    public static void main(String[] args) {
        String digits = "23";
        Lc17 lc17 = new Lc17();
        List<String> res = lc17.letterCombinations(digits);
        System.out.println(res);
    }
}
