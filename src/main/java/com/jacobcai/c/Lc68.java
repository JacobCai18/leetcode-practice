package com.jacobcai.c;

import java.util.ArrayList;
import java.util.List;

public class Lc68 {
    private String blank(int n) {
        return " ".repeat(Math.max(0, n));
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        // 单词个数：当前这一行的字符数 charCnt，当前这一行的字符串数 strCnt，words 中第 i 个字符串
        // -一个单词：单词后面用 ' ' 填满
        // -多个单词：
        // --不是最后一行：空格数 spaceCnt，最少需要 strCnt - 1 个空格，每个空位置放 per = spaceCnt / (strCnt - 1) 个空格
        //            q 个 位置需要多放 1 个 ' '，q = spaceCnt % (strCnt - 1)
        // --最后一行：左对齐，单词间一个 ' '，最后用 ' ' 填满
        List<String> res = new ArrayList<>();
        int n = words.length, i = 0;
        boolean isLast = false;
        while (i < n) {
            int charCnt = 0, strCnt = 0;
            while (charCnt + words[i + strCnt].length() + strCnt <= maxWidth) {
                charCnt += words[i + strCnt].length();
                strCnt++;
                if (i + strCnt == n) {
                    isLast = true;
                    break;
                }
            }
            StringBuilder sb = new StringBuilder(maxWidth);
            if (strCnt == 1) {
                sb.append(words[i]).append(blank(maxWidth - charCnt));
            } else if (!isLast) { // strCnt > 1
                int spaceCnt = maxWidth - charCnt, per = spaceCnt / (strCnt - 1), q = spaceCnt % (strCnt - 1);
                for (int j = i; j < i + strCnt - 1; j++) {
                    sb.append(words[j]).append(blank(per));
                    if (q != 0) {
                        sb.append(' ');
                        q--;
                    }
                }
                sb.append(words[i + strCnt - 1]);
            } else { // strCnt > 1 && isLast
                for (int j = i; j < i + strCnt - 1; j++) sb.append(words[j]).append(' ');
                sb.append(words[i + strCnt - 1]).append(blank(maxWidth - (charCnt + strCnt - 1)));
            }
            res.add(sb.toString());
            i += strCnt;
        }
        return res;
    }

    public static void main(String[] args) {
        Lc68 lc68 = new Lc68();
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> res = lc68.fullJustify(words, 16);
        System.out.println("res = " + res);
    }
}
