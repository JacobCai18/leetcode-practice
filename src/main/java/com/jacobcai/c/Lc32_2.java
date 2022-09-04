package com.jacobcai.c;

public class Lc32_2 {
    public int longestValidParentheses(String s) {
        int res = 0;
        // dp[i] = 以s.charAt(i)结尾的最长有效括号的长度
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    // dp[i] = dp[i - 2] + 2
                    dp[i] = (i - 2 >= 0 ?
                             dp[i - 2] :
                             0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    // dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) - 2 >= 0 ?
                                         dp[i - dp[i - 1] - 2] :
                                         0) + 2;
                }
                res = Math.max(res,
                               dp[i]);
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        String s = "()(()())";
        Lc32_2 lc32_2 = new Lc32_2();
        int res = lc32_2.longestValidParentheses(s);
        System.out.println("res = " + res);
    }
}
