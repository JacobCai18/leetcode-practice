package com.jacobcai;

import java.util.ArrayList;
import java.util.List;

public class Lc22 {
    List<String> strList;
    StringBuilder sb;
    int n;

    public List<String> generateParenthesis(int n) {
        strList = new ArrayList<>();
        sb = new StringBuilder(2 * n);
        this.n = n;
        backtrack(0, 0);
        return strList;
    }

    private void backtrack(int left, int right) {
        if (left == n && right == n) {
            strList.add(sb.toString());
            return;
        }
        if (left < right) {
            return;
        }
        if (left < n) {
            sb.append('(');
            backtrack(left + 1, right);
            sb.deleteCharAt(left + right);
        }
        if (right < n) {
            sb.append(')');
            backtrack(left, right + 1);
            sb.deleteCharAt(left + right);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        Lc22 lc22 = new Lc22();
        List<String> strList = new ArrayList<>();
        strList = lc22.generateParenthesis(n);
        System.out.println(strList);
    }
}
