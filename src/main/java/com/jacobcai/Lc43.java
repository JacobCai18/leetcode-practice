package com.jacobcai;

public class Lc43 {
    public String multiply(String num1,
                           String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        // 两数的乘积的最大长度为m+n,最小长度为m+n-1
        // 使用int[]在i + j + 1存放x * y
        int[] resArr = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                resArr[i + j + 1] += x * y;
            }
        }
        // 进位
        for (int i = m + n - 1; i > 0; i--) {
            resArr[i - 1] += resArr[i] / 10;
            resArr[i] %= 10;
        }
        StringBuilder res = new StringBuilder();
        // 判断首位是否为0
        int k = resArr[0] == 0 ?
                1 :
                0;
        for (; k < m + n; k++) {
            res.append(resArr[k]);
        }
        return res.toString();
    }
    
    public static void main(String[] args) {
        String num1 = "1234";
        String num2 = "567";
        Lc43 lc43 = new Lc43();
        String res = lc43.multiply(num1,
                                   num2);
        System.out.println("res = " + res);
    }
}
