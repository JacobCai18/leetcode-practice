package com.jacobcai.c;

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
        backtrack(0,
                  0);
        return strList;
    }
    
    private void backtrack(int le,
                           int ri) {
        if (le == n && ri == n) {
            strList.add(sb.toString());
            return;
        }
        if (le < ri) {
            return;
        }
        if (le < n) {
            sb.append('(');
            backtrack(le + 1,
                      ri);
            sb.deleteCharAt(le + ri);
        }
        if (ri < n) {
            sb.append(')');
            backtrack(le,
                      ri + 1);
            sb.deleteCharAt(le + ri);
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
