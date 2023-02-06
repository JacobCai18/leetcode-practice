package com.jacobcai.mdcc;

import java.util.*;

public class Lc1604 {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> mp = new HashMap<>(); // <name, time list>
        int n = keyName.length;
        for (int i = 0; i < n; i++) {
            String name = keyName[i];
            String time = keyTime[i]; // to minutes
            mp.putIfAbsent(name, new ArrayList<>());
            int hour = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
            int minute = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
            mp.get(name).add(hour * 60 + minute);
        }
        List<String> res = new ArrayList<>();
        for (String name : mp.keySet()) {
            List<Integer> list = mp.get(name);
            Collections.sort(list);
            for (int i = 2; i < list.size(); i++) {
                if (list.get(i) - list.get(i - 2) <= 60) {
                    res.add(name);
                    break;
                }
            }
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        Lc1604 lc1604 = new Lc1604();
        String[] keyName = {"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"};
        String[] keyTime = {"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"};
        List<String> res = lc1604.alertNames(keyName, keyTime);
        System.out.println("res = " + res);
    }
}
