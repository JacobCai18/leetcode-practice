package com.jacobcai.c;

public class Lc10 {
    public boolean isMatch(String s,
                           String p) {
        char[] sc, pc;
        int sLen, pLen;
        sc = s.toCharArray();
        pc = p.toCharArray();
        // dp[i][j]: s的前i个字符，p的前j个字符是否能够匹配
        boolean[][] dp = new boolean[(sLen = sc.length) + 1][(pLen = pc.length) + 1];
        // s为空，p为空，能匹配上
        dp[0][0] = true;
        // p为空，s不为空，必为false(boolean数组默认值为false，无需处理)
        // s为空，p不为空，由于*可以匹配0个字符，所以有可能为true
        for (int j = 1; j <= pLen; j++) {
            if (pc[j - 1] == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        // 填格子
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                // 文本串s和模式串p末位字符能匹配上
                if (sc[i - 1] == pc[j - 1] || pc[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc[j - 1] == '*') { // 模式串p末位是*
                    // 模式串p*的前一个字符能够跟文本串s的末位匹配上
                    if (sc[i - 1] == pc[j - 2] || pc[j - 2] == '.') {
                        dp[i][j] = dp[i][j - 2]      // *匹配0次的情况
                                || dp[i - 1][j];     // *匹配1次或多次的情况
                    } else { // 模式串p*的前一个字符不能够跟文本串s的末位匹配
                        dp[i][j] = dp[i][j - 2];     // *只能匹配0次
                    }
                }
            }
        }
        return dp[sLen][pLen];
    }
    
    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        Lc10 lc10 = new Lc10();
        boolean res = lc10.isMatch(s,
                                   p);
        System.out.println("res = " + res);
    }
}
