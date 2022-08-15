package com.jacobcai;

import java.util.*;

public class Lc49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 将String转化为char[]，方便Arrays.sort
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            // key
            String key = new String(charArray);
            // value
            List<String> list = map.getOrDefault(key,
                                                 new ArrayList<>());
            list.add(str);
            // put
            map.put(key,
                    list);
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
