package com.jacobcai;

import java.util.*;

public class Lc49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 将String转化为char[]，方便Arrays.sort
            char[] charArr;
            String k;
            List<String> v;
            // 字母异位词排序后结果相同
            Arrays.sort(charArr = str.toCharArray());
            v = map.getOrDefault(k = new String(charArr),
                                 new ArrayList<>());
            v.add(str);
            map.put(k,
                    v);
        }
        return new ArrayList<>(map.values());
    }
    
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Lc49 lc49 = new Lc49();
        List<List<String>> res = lc49.groupAnagrams(strs);
        System.out.println("res = " + res);
    }
}
