package com.jacobcai.mdccc;

public class Lc1754_2 {
    public String largestMerge(String word1,
                               String word2) {
        int len1 = word1.length(), len2 = word2.length();
        String str = word1 + "@" + word2 + "*";
        int[] suffixArray = buildSuffixArray(str);
        int[] rank = new int[len1 + len2 + 2];
        for (int i = 0; i < len1 + len2 + 2; i++) {
            rank[suffixArray[i]] = i;
        }
        StringBuilder merge = new StringBuilder();
        int i = 0, j = 0;
        while (i < len1 || j < len2) {
            if (i < len1 && rank[i] > rank[len1 + 1 + j]) {
                merge.append(word1.charAt(i++));
            } else {
                merge.append(word2.charAt(j++));
            }
        }
        return merge.toString();
    }
    
    public int[] buildSuffixArray(String text) {
        int[] order = sortCharacters(text);
        int[] classify = computeCharClasses(text,
                                            order);
        int len = text.length();
        for (int i = 1; i < len; i <<= 1) {
            order = sortDoubled(text,
                                i,
                                order,
                                classify);
            classify = updateClasses(order,
                                     classify,
                                     i);
        }
        return order;
    }
    
    public int[] sortCharacters(String text) {
        int len = text.length();
        int[] count = new int[128];
        int[] order = new int[len];
        for (int i = 0; i < len; i++) {
            char c = text.charAt(i);
            count[c]++;
        }
        for (int i = 1; i < 128; i++) {
            count[i] += count[i - 1];
        }
        for (int i = len - 1; i >= 0; i--) {
            count[text.charAt(i)]--;
            order[count[text.charAt(i)]] = i;
        }
        return order;
    }
    
    public int[] computeCharClasses(String text,
                                    int[] order) {
        int len = text.length();
        int[] res = new int[len];
        res[order[0]] = 0;
        for (int i = 1; i < len; i++) {
            if (text.charAt(order[i]) != text.charAt(order[i - 1])) {
                res[order[i]] = res[order[i - 1]] + 1;
            } else {
                res[order[i]] = res[order[i - 1]];
            }
        }
        return res;
    }
    
    public int[] sortDoubled(String text,
                             int length,
                             int[] order,
                             int[] classify) {
        int len = text.length();
        int[] count = new int[len];
        int[] newOrder = new int[len];
        for (int i = 0; i < len; i++) {
            count[classify[i]]++;
        }
        for (int i = 1; i < len; i++) {
            count[i] += count[i - 1];
        }
        for (int i = len - 1; i >= 0; i--) {
            int start = (order[i] - length + len) % len;
            int cl = classify[start];
            count[cl]--;
            newOrder[count[cl]] = start;
        }
        return newOrder;
    }
    
    public int[] updateClasses(int[] newOrder,
                               int[] classify,
                               int length) {
        int len = newOrder.length;
        int[] newClassify = new int[len];
        newClassify[newOrder[0]] = 0;
        for (int i = 1; i < len; i++) {
            int curr = newOrder[i];
            int prev = newOrder[i - 1];
            int mid = curr + length;
            int midPrev = (prev + length) % len;
            if (classify[curr] != classify[prev] || classify[mid] != classify[midPrev]) {
                newClassify[curr] = newClassify[prev] + 1;
            } else {
                newClassify[curr] = newClassify[prev];
            }
        }
        return newClassify;
    }
    
    public static void main(String[] args) {
        String word1 = "abcabc";
        String word2 = "abdcaba";
        Lc1754_2 lc1754 = new Lc1754_2();
        String res = lc1754.largestMerge(word1,
                                         word2);
        System.out.println("res = " + res);
    }
}
