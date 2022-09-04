package com.jacobcai.c;

public class Lc06 {
    public String convert(String s,
                          int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] sbs = new StringBuilder[numRows];
        // 初始化每一行的sb
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }
        int flag = -1;
        int row = 0;
        for (int i = 0; i < s.length(); i++) {
            sbs[row].append(s.charAt(i));
            // row到最后一行或第一行时flag取相反数
            if (row == numRows - 1 || row == 0) {
                flag = -flag;
            }
            row += flag;
        }
        // 将每行的sb拼接起来
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : sbs) {
            res.append(sb);
        }
        return res.toString();
    }
    
    public static void main(String[] args) {
        String s = "PAYPALISHIPING";
        int numRows = 3;
        Lc06 lc06 = new Lc06();
        String res = lc06.convert(s,
                                  numRows);
        System.out.println("res = " + res);
    }
}
