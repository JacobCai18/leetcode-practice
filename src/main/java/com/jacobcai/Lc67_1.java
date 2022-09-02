package com.jacobcai;

public class Lc67_1 {
    public String addBinary(String a,
                            String b) {
        int len, aLen, bLen;
        len = Math.max(aLen = a.length(),
                       bLen = b.length()) + 1;
        int[] resArr = new int[len];
        for (int i = aLen - 1, k = len - 1; i >= 0; i--, k--) {
            resArr[k] = a.charAt(i) - '0';
        }
        for (int j = bLen - 1, k = len - 1; j >= 0; j--, k--) {
            resArr[k] += b.charAt(j) - '0';
        }
        // 进位
        for (int k = len - 1; k > 0; k--) {
            resArr[k - 1] += resArr[k] / 2;
            resArr[k] %= 2;
        }
        StringBuilder res = new StringBuilder();
        // 判断首位
        int x = resArr[0] == 1 ?
                0 :
                1;
        for (; x < len; x++) {
            res.append(resArr[x]);
        }
        return res.toString();
    }
    
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        Lc67_1 lc67_1 = new Lc67_1();
        String res = lc67_1.addBinary(a,
                                      b);
        System.out.println("res = " + res);
    }
}
