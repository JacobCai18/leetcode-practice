package com.jacobcai.mdcccc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc1807 {
    public String evaluate(String s, List<List<String>> knowledge) {
        // 构建返回值
        StringBuilder sb = new StringBuilder();
        // 将键值对加入哈希表，使搜索时间复杂度从 O(n) 降为 O(1)
        Map<String, String> map = new HashMap<>(knowledge.size());
        for (List<String> pair : knowledge)
            map.put(pair.get(0), pair.get(1));
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                // 记录 '(' 下一位的下标
                int begin = ++i;
                // 出循环时 i 为 ')' 的下标
                while (s.charAt(i) != ')') i++;
                // 在哈希表查找括号中字符串，若找到则在 sb 加入该字符串对应的值，否则加入 "?"
                sb.append(map.getOrDefault(s.substring(begin, i), "?"));
            } else {
                // 括号外的字符直接加入 sb
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "(name)is(age)yearsold";
        String[][] kvs = {{"name", "bob"}, {"age", "two"}};
        List<List<String>> knowledge = new ArrayList<>();
        int i = 0;
        for (String[] kv : kvs) {
            knowledge.add(new ArrayList<>());
            for (String st : kv) {
                knowledge.get(i).add(st);
            }
            i++;
        }
        Lc1807 lc1807 = new Lc1807();
        String res = lc1807.evaluate(s, knowledge);
        System.out.println("res = " + res);
    }
}
