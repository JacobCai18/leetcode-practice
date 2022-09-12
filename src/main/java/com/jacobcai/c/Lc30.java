package com.jacobcai.c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc30 {
    public List<Integer> findSubstring(String s,
                                       String[] words) {
        List<Integer> res = new ArrayList<>();
        int wRowLen = words.length;
        int wordLen = words[0].length();
        // k: word, v: count
        Map<String, Integer> pMap = new HashMap<>();
        for (String word : words) {
            pMap.put(word,
                     pMap.getOrDefault(word,
                                       0) + 1);
        }
        // 将所有移动分成 wordLen 类情况
        for (int j = 0; j < wordLen; j++) {
            Map<String, Integer> sMap = new HashMap<>();
            // sMap单词数
            int num = 0;
            // 每次移动一个单词长度
            for (int i = j; i < s.length() - wRowLen * wordLen + 1; i += wordLen) {
                while (num < wRowLen) {
                    String word = s.substring(i + num * wordLen,
                                              i + (num + 1) * wordLen);
                    if (pMap.containsKey(word)) {
                        sMap.put(word,
                                 sMap.getOrDefault(word,
                                                   0) + 1);
                        // 情况三，遇到了符合的单词，但是次数超了
                        if (sMap.get(word) > pMap.get(word)) {
                            int removeNum = 0;
                            // 一直移除单词，直到次数符合了
                            while (sMap.get(word) > pMap.get(word)) {
                                String firstWord = s.substring(i + removeNum * wordLen,
                                                               i + (removeNum + 1) * wordLen);
                                sMap.put(firstWord,
                                         sMap.get(firstWord) - 1);
                                removeNum++;
                            }
                            // 加 1 是因为我们把当前单词加入到了 sMap 中
                            num = num - removeNum + 1;
                            // 这里依旧是考虑到了最外层的 for 循环，看情况二的解释
                            i = i + (removeNum - 1) * wordLen;
                            break;
                        }
                        num++;
                        // 情况二，遇到了不匹配的单词，直接将 i 移动到该单词的后边（但其实这里只是移动到了出现问题单词的地方，
                        // 因为最外层有 for 循环， i 还会移动一个单词然后刚好就移动到了单词后边）
                    } else {
                        sMap.clear();
                        i = i + num * wordLen;
                        num = 0;
                        break;
                    }
                }
                // 情况一，子串完全匹配
                if (num == wRowLen) {
                    res.add(i);
                    String firstWord = s.substring(i,
                                                   i + wordLen);
                    sMap.put(firstWord,
                             sMap.get(firstWord) - 1);
                    num--;
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        Lc30 lc30 = new Lc30();
        List<Integer> res = lc30.findSubstring(s,
                                               words);
        System.out.println("res = " + res);
    }
}
