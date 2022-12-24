package com.jacobcai.mdccc;

public class Lc1754 {
    public String largestMerge(String word1,
                               String word2) {
        StringBuilder merge = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length() && word1.substring(i)
                                           .compareTo(word2.substring(j)) > 0) {
                merge.append(word1.charAt(i++));
            } else {
                merge.append(word2.charAt(j++));
            }
        }
        return merge.toString();
    }
    
    public static void main(String[] args) {
        String word1 = "abcabc";
        String word2 = "abdcaba";
        Lc1754 lc1754 = new Lc1754();
        String res = lc1754.largestMerge(word1,
                                         word2);
        System.out.println("res = " + res);
    }
}
